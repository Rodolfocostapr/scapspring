package br.nemo.ufes.scap.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.nemo.ufes.scap.Application.AplMandato;
import br.nemo.ufes.scap.Domain.Mandato;

@Controller
public class MandatoController {

	@Autowired
	private AplMandato aplMandato;

	// @SecretarioRestricted
	@RequestMapping(value = "/mandato/form")
	public String formulario() {
		return "mandato/formulario";
	}

	public void lista() {
	}

	// @SecretarioRestricted
	@RequestMapping(value = "/mandato/salva", method = RequestMethod.POST)
	public String salva(Mandato novoMandato, String matricula, String data_iniMandato, String data_fimMandato,
			HttpSession session) throws ParseException {

		SimpleDateFormat formatada = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal.setTime(formatada.parse(data_iniMandato.replaceAll("-", "/")));
		novoMandato.setData_inicio(cal);
		cal2.setTime(formatada.parse(data_fimMandato.replaceAll("-", "/")));
		novoMandato.setData_fim(cal2);

		aplMandato.salvar(novoMandato, matricula);
		return "index/index";
	}

}
