/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Postagem;
import api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author leonardo
 */
public interface PostagemDAO {
    
    public int inserir(Postagem postagem);
    public Postagem procurarPorId(Integer id);
    public List<Postagem> procurarTudo();
    public Usuario atualizar(Postagem postAnt, Postagem postAt);
    public boolean excluir(Integer id);
}
