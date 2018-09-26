/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author leonardo
 */
public interface UsuarioDAO {
    public int insert(Usuario usuario);
    public Usuario procurarPorId(Long id);
    public Usuario procurarPorNome(String nomeUsuario);
    public Usuario procurarPorNomeUsuario(String name);
    public List<Usuario> procurarTudo();
    public Usuario atualizar(Usuario usuarioAnt, Usuario usuarioAt);
    public boolean excluir(Usuario usuario);
    public boolean excluir(Long id); 
    
}
