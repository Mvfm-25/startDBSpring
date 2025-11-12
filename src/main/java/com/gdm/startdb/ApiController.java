// Parte do REST API.
// [mvfm]

// Criado : 12/11/2025  || Última vez alterado : 12/11/2025

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

@RestController
public class ApiController {

    @Autowired private NiceService niceService;

    @PostMapping("/addnicer")
    public String addNicer(@RequestBody List<Membros> novosNicers){
        niceService.addNicers(novosNicers);
        return "Nice(s) adicionado com sucesso!";
    }

}