/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.servico;

import api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author leonardo
 */
public interface ServicoUsuario {
    public void inserir(Usuario usuario);
    public Usuario procurarPorNome(String nome);
    public List<Usuario> procurarTudo();  
    public boolean excluir(Integer id);
}
