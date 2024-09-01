package com.exemplo.contador;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contador {

    public static void main(String[] args) throws Exception {

        // Muito mais eficiente que o Scanner
        BufferedReader input = new BufferedReader( new InputStreamReader(System.in) ); // input eh objeto para controle de Entrada

        int first_num;
        int second_num;

        System.out.println("Digite o primeiro parametro: ");
        first_num = Integer.parseInt(input.readLine());
        System.out.println("");

        System.out.println("Digite o segundo parametro: ");
        second_num = Integer.parseInt(input.readLine());
        System.out.println("");

        try{
            contar(first_num, second_num);
        }
        catch(ParametrosInvalidosException ex) {

            // Printando a mensagem de erro
            System.out.println(ex.getMessage());
        }
    }
    

    // --- funcao global (nao depende de nenhuma classe)
    // (essa funcao ja eh instanciada no comeco do programa)
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        
        if(parametroUm > parametroDois) 
            throw new ParametrosInvalidosException("erro: 1o parametro eh maior que o 2o\n");
        
        int contagem = parametroDois - parametroUm;

        for(int i = 1; i <= contagem; i++)
            System.out.println(i);
    }

    // --- Criando excessao customizada (
    // (essa classe ja eh instanciada no comeco do programa)
    static class ParametrosInvalidosException extends Exception {

        // s eh a mensagem de erro a ser mostrada
        public ParametrosInvalidosException(String s) {
            super(s);
        }
    } 

}