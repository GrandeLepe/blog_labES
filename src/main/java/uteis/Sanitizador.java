/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public final class Sanitizador {

    private List<String> palavroes = new ArrayList<>();

    public Sanitizador() throws FileNotFoundException {
        carregaArqiuvo();
    }

    public void carregaArqiuvo() {
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File arquivo = new File(classLoader.getResource("p.txt").getFile());

            BufferedReader arquivoPalavras = new BufferedReader(new FileReader(arquivo));

            String p;
            while ((p = arquivoPalavras.readLine()) != null) {
                palavroes.add(p);
            }

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("erro ao ler o arquivo de palavroes");
        }

    }

    public String verificaPalavra(String comentario) throws FileNotFoundException, IOException {
        String[] palavras = comentario.split(" ");
        List<String> palavrasLimpas = new ArrayList<>();
        String censura = "*";
        String comentarioLimpo;
        
         for (String palavra : palavras) {

            if (palavroes.contains(palavra.toUpperCase())) {
                palavrasLimpas.add("*");
            }
            else{
                palavrasLimpas.add(palavra);
            }
               

        }
        

        comentarioLimpo = String.join(" ", palavrasLimpas);
        System.out.println(comentarioLimpo);
        return comentarioLimpo;
    }

    public void imprime() {
        for (String p : palavroes) {
            System.out.println(p);
        }
    }

    private List<String> ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//for (String p : palavroes) {
//
//                if (palavra.toLowerCase().equals(p.toLowerCase())) {
//                    palavrasLimpas.add("*");
//                    System.out.println("linha 60");
//                } else {
//                    palavrasLimpas.add(palavra);
//                    System.out.println("linha 62");
//                }
//            }
