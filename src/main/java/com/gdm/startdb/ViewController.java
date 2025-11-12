// Simples controller para testes iniciais.
// [mvfm]

// Criado : 07/11/2025  || Última vez alterado : 12/11/2025

package com.gdm.startdb;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Mbeanregistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


// Parte visual, HTML com Thymeleaf.
@Controller
public class ViewController {

    @Autowired private NiceService niceService;

    private int hits = 0;

    @GetMapping("")
    public String home(Model modelo){
        modelo.addAttribute("message", "G.D.M. IS ONLINE");
        return "home";
    }

    @GetMapping("/gdm")
    public String gdm(Model modelo){
        if(hits == 5){
            hits = 0;
            modelo.addAttribute("message", "G.D.M. - Always improving!");
        } else {
            hits++;
            modelo.addAttribute("message", "G.D.M. - Being nice since 2018!");
        }
        return "gdm";
    }

    @GetMapping("/nice")
    public String showNicers(Model modelo){
        modelo.addAttribute("nicers", niceService.getAllNicers());
        return "nice";
    }

}
