// Parte final para o controlador do Discord
// [mvfm]
//
// Criado : 13/11/2025  || Última vez Modificado : 13/11/2025

package com.gdm.startdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscordController {
    
    @Autowired
    private DiscordService discordService;
    
    @GetMapping("/discord")
    public String showDiscord(Model model) {
        model.addAttribute("servidor", discordService.getServidor());
        return "discord"; // nome do arquivo HTML
    }
}