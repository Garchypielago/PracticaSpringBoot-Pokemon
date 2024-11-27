package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/",""})
public class HomeController {

    @GetMapping
    public String indexPage() {
        return "index.html";
    }

}
