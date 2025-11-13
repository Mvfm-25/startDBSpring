// Classe de serviço para manipular dados do Discord
// Também usando Jackson.
// [mvfm]
//
// Criado : 13/11/2025  || Última vez Modificado : 13/11/2025

package com.gdm.startdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscordService {
    private ServidorDiscord servidor;
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @PostConstruct
    public void loadDiscordData() {
        try {
            ClassPathResource resource = new ClassPathResource("gdm_data.json");
            servidor = objectMapper.readValue(
                resource.getInputStream(),
                ServidorDiscord.class
            );
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados do Discord: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Retorna o servidor completo
    public ServidorDiscord getServidor() {
        return servidor;
    }
    
    // Retorna todos os canais
    public List<Canal> getAllCanais() {
        return servidor != null ? servidor.getCanais() : new ArrayList<>();
    }
    
    // Retorna um canal específico por nome
    public Canal getCanalByNome(String nome) {
        if (servidor == null) return null;
        return servidor.getCanais().stream()
            .filter(c -> c.getNome().equalsIgnoreCase(nome))
            .findFirst()
            .orElse(null);
    }
    
    // Retorna todas as mensagens de um canal específico
    public List<Mensagem> getMensagensByCanal(String nomeCanal) {
        Canal canal = getCanalByNome(nomeCanal);
        return canal != null ? canal.getMensagens() : new ArrayList<>();
    }
    
    // Retorna todas as mensagens de todos os canais
    public List<Mensagem> getAllMensagens() {
        if (servidor == null) return new ArrayList<>();
        return servidor.getCanais().stream()
            .flatMap(canal -> canal.getMensagens().stream())
            .collect(Collectors.toList());
    }
    
    // Busca mensagens por autor
    public List<Mensagem> getMensagensByAutor(String autorNome) {
        return getAllMensagens().stream()
            .filter(m -> m.getAutorNome().equalsIgnoreCase(autorNome))
            .collect(Collectors.toList());
    }
}