package br.nemo.ufes.scap.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/*")
public class IndexController {

	@RequestMapping(value="/")
	public String index(Principal principal){
		System.out.println(principal.getName());
		return "index/index";
	}
	
	@RequestMapping(value="/index/msgErro", method=RequestMethod.POST)
	public void msgErro(String msg){
		//("msg",msg);
	}
	
}
