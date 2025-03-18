package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping({"/","","/home"})
    public String index() {
        return "administration/home";
    }
}
