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
    public Usuario findById(Long id);
    public Usuario findByNome(String nomeUsuario);
    public Usuario findByNomeUsuario(String name);
    public List<Usuario> findAll();
    public Usuario update(Usuario usuarioAnt, Usuario usuarioAt);
    public boolean delete(Usuario usuario);
    public boolean delete(Long id); 
    
}
