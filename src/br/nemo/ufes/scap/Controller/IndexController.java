package br.nemo.ufes.scap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String execute() {
		System.out.println("IndexController");
		return "index";
	}
	
}
