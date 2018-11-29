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

    private Integer idComentario;
    private Integer idPost;
    private String tituloPost;
    private String comentario;
    private Integer idAutor;
    private String nomeAutor;

    public Comentario(Integer idComentario, Integer idPost, String tituloPost, String comentario, Integer idAutor, String nomeAutor, String data) {
        this.idComentario = idComentario;
        this.idPost = idPost;
        this.tituloPost = tituloPost;
        this.comentario = comentario;
        this.idAutor = idAutor;
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
        return idComentario;
    }

    public void setId_comentario(Integer id_comentario) {
        this.idComentario = id_comentario;
    }

    public Integer getId_post() {
        return idPost;
    }

    public void setId_post(Integer id_post) {
        this.idPost = id_post;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getId_autor() {
        return idAutor;
    }

    public void setId_autor(Integer id_autor) {
        this.idAutor = id_autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
