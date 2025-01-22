package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Objects;

@Controller
public class BaseController {

    @ModelAttribute(name="activeSection")
    public String addUrl(HttpServletRequest request) {
        String url = request.getRequestURI();
        System.out.println(url);
        return url.equals("/") ? "index" : url.split("/")[1];
    }

}
