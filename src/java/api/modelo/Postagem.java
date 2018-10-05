/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

import java.util.Date;

/**
 *
 * @author leonardo
 */
public class Postagem {

    private Integer idPost;
    private String titulo;
    private String publicacao;
    private Integer idAutor;
    private String data;

    public Postagem() {
    }

    public Integer getId_post() {
        return idPost;
    }

    public void setId_post(Integer idPost) {
        this.idPost = idPost;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public Integer getId_autor() {
        return idAutor;
    }

    public void setId_autor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
