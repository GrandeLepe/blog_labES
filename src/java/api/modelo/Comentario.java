/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

/**
 *
 * @author leonardo
 */
public class Comentario {

    private Integer id_comentario;
    private Integer id_post;
    private String tituloPost;
    private String comentario;
    private Integer id_autor;
    private String nomeAutor;

    public Comentario(Integer id_comentario, Integer id_post, String tituloPost, String comentario, Integer id_autor, String nomeAutor, String data) {
        this.id_comentario = id_comentario;
        this.id_post = id_post;
        this.tituloPost = tituloPost;
        this.comentario = comentario;
        this.id_autor = id_autor;
        this.nomeAutor = nomeAutor;
        this.data = data;
    }

    public Comentario() {
    }

    public String getTituloPost() {
        return tituloPost;
    }

    public void setTituloPost(String tituloPost) {
        this.tituloPost = tituloPost;
    }
    
    
    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
    private String data;

    public Integer getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Integer id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
