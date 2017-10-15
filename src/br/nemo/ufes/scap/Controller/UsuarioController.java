package br.nemo.ufes.scap.Controller;

import javax.ejb.Stateful;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.nemo.ufes.scap.Application.AplPessoa;
import br.nemo.ufes.scap.Domain.Pessoa;

@Stateful
@Controller
public class UsuarioController {

	@Autowired
	private Usuario usuarioWeb;

	@Autowired
	private AplPessoa aplPessoa;

	@RequestMapping("loginForm")
	public String loginForm() {
		return "usuario/login";
	}

	@RequestMapping("efetuaLogin")
	public String logar(Pessoa usuario, HttpSession session, RedirectAttributes rd) {
		Pessoa pessoa = new Pessoa();
		pessoa = aplPessoa.buscaMatricula(usuario.getMatricula());
		if (pessoa != null) {
			if (pessoa.getPassword().equals(usuario.getPassword())) {
				usuarioWeb.login(pessoa);
				session.setAttribute("usuarioWeb", usuarioWeb);
				session.getAttribute("usuarioWeb");
				return "index/index";
			} else {
				rd.addFlashAttribute("variable", "Matricula ou Senha Incorreta");
				return "redirect:loginForm";
			}
		} else {
			rd.addFlashAttribute("variable", "Matricula ou Senha Incorreta");
			return "redirect:loginForm";
		}
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
	/*
	 * public void logout(HttpSession session){ Usuario usuarioWeb =
	 * (Usuario)session.getAttribute("usuarioWeb"); usuarioWeb.logout();
	 * session.removeAttribute("usuarioWeb");
	 * //result.redirectTo(IndexController.class).index(session); }
	 */

	public void naoAutorizado() {
	}

}
