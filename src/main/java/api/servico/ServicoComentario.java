/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.servico;

import api.modelo.Comentario;
import java.util.List;

/**
 *
 * @author leonardo
 */
public interface ServicoComentario {
    public Integer inserir(Comentario comentario);
    public Comentario procurarPorId(Integer id);
    public List<Comentario> procurarTudo();
    public List<Comentario> procurarTudoId_post(Integer id);
    public Comentario atualizar(Comentario comentarioAnt, Comentario comentarioAt);
    public boolean excluir(Integer id);
}
