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

    private Set<Membros> nicers = new HashSet<>();

    public Controller() {
        nicers = new HashSet<Membros>();

        nicers.add(new Membros("Mvfm", "Nicest"));
        nicers.add(new Membros("Kappe", "Nicer"));
        nicers.add(new Membros("Sheedoky", "Nicer"));
    }
    

    int hits = 0;

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String home() {
        
    return """
        <html>
            <body style="font-family: sans-serif; text-align: center; margin-top: 50px;">
                <h1>G.D.M. IS ONLINE</h1>    
                <button type='button' onclick="window.location.href='/gdm'">
                    G.D.M.
                </button>
            </body>
        </html>
    """;
    }

    @GetMapping("/gdm")
    public String gdm(){
        if(hits == 5){
            hits = 0;
            return "G.D.M. - Always improving!";
        }
        
        hits++;
        return "G.D.M. - Being nice since 2018!";
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
