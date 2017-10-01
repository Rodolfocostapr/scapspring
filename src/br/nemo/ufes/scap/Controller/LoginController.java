package br.nemo.ufes.scap.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
     
    return "login";
     
    }
    
    @RequestMapping(value="/ok", method = RequestMethod.GET)
    public String home(ModelMap model, Principal principal ) {
     
    String name = principal.getName();
    model.addAttribute("username", name);
    return "home";
     
    }
     
     
    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
    model.addAttribute("error", "true");
    model.addAttribute("msg", "invalid login credentials");
    return "login";
     
    }
}
