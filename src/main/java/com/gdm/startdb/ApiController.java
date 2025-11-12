// Parte do REST API.
// [mvfm]

// Criado : 12/11/2025  || Última vez alterado : 12/11/2025

package com.gdm.startdb;

import java.util.*;

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

    private Set<Membros> nicers = new HashSet<>();
    public ApiController() {
        nicers = new HashSet<Membros>();

        nicers.add(new Membros("Mvfm", "Nicest"));
        nicers.add(new Membros("Kappe", "Nicer"));
        nicers.add(new Membros("Sheedoky", "Nicer"));
    }

    @GetMapping("/nice")
    public Set<Membros> nice(){
        return nicers;
    }

    @PostMapping("/addnicer")
    public String addNicer(@RequestBody List<Membros> novosNicers){
        nicers.addAll(novosNicers);
        return "Nice(s) adicionado com sucesso!";
    }
}