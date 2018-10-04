/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Comentario;
import api.modelo.Postagem;
import api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author leonardo
 */
public interface ComentarioDAO {
    public Integer inserir(Comentario comentario);
    public Comentario procurarPorId(Integer id);
    public List<Comentario> procurarTudo();
    public Comentario atualizar(Comentario comentarioAnt, Comentario comentarioAt);
    public boolean excluir(Integer id);
}
