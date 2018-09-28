/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.controle;

import java.util.ArrayList;

/**
 *
 * @author leonardo
 */
public class ControleSessao {

    public static ArrayList<String> sessao = new ArrayList();

    private ControleSessao() {
    }

    public static void adicionarSessao(String id) {
        sessao.add(id);
        System.out.println("Usuario adicionado a sessao");
    }

    public static void removeSessao(String id) {
        sessao.remove(id);
        System.out.println("Usuario removido da sessao");
    }

    public static boolean procuraSessao(String id) {
        for (String string : sessao) {
            if (string.equals(id)) {
                return true;
            }
        }
        return false;
    }

}
