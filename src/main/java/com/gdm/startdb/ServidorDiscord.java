// Classs de modelo para representar o Servidor Discord, Canais e Mensagens.
// Usando Jackson agora para manipulação JSON.
// [mvfm]
//
// Criado : 13/11/2025  || Última vez Modificado : 13/11/2025

package com.gdm.startdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Classe principal do Servidor
// Basicamente uma classe gigante simplesmente de getters e setters. Nada muito complexo, mas bem manual.
public class ServidorDiscord {
    private long id;
    private String nome;
    private List<Canal> canais;
    
    public ServidorDiscord() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public List<Canal> getCanais() { return canais; }
    public void setCanais(List<Canal> canais) { this.canais = canais; }
}

// Classe Canal
class Canal {
    private long id;
    private String nome;
    private List<Mensagem> mensagens;
    
    public Canal() {}
    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public List<Mensagem> getMensagens() { return mensagens; }
    public void setMensagens(List<Mensagem> mensagens) { this.mensagens = mensagens; }
}

// Classe Mensagem
class Mensagem {
    private long id;
    
    @JsonProperty("autor_id")
    private long autorId;
    
    @JsonProperty("autor_nome")
    private String autorNome;
    
    private String conteudo;
    private String data;
    private List<String> arquivos;
    
    public Mensagem() {}
    
    // Getters e Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    public long getAutorId() { return autorId; }
    public void setAutorId(long autorId) { this.autorId = autorId; }
    
    public String getAutorNome() { return autorNome; }
    public void setAutorNome(String autorNome) { this.autorNome = autorNome; }
    
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
    
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    
    public List<String> getArquivos() { return arquivos; }
    public void setArquivos(List<String> arquivos) { this.arquivos = arquivos; }
}