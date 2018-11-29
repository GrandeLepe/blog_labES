/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Usuario extends Identificador{
    private Long id;
    private String nome;
    private String senha;
    private String nomeUsuario;
    private String email;
    private Integer papel;
    
    public Usuario(){}
    public Usuario(Long id, String nome, String senha,
                   String nomeUsuario, String email,
                   Integer papel){
        super(id);
        this.setNome(nome);
        this.setSenha(senha);
        this.setNomeUsuario(nomeUsuario);
        this.setEmail(email);
        this.setPapel(papel);               
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPapel() {
        return papel;
    }

    public void setPapel(Integer papel) {
        this.papel = papel;
    }
    
    
    
}
