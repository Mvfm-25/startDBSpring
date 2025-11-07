// Simples controller para testes iniciais.
// [mvfm]

// Criado : 07/11/2025  || Última vez alterado : 07/11/2025

package com.gdm.startdb;

import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String home() {
        return "API StartDB está funcionando!";
    }
    
}
