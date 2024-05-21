/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;

/**
 * Escreva um programa que recebe uma sequência e verifica se esta possui ou não 
 * elementos duplicados.
 * Restrições:
 * Não é permitido a utilização de nenhum método do Collections ou outra estrutura 
 * de dados diferente de array.
 * Entrada:
 * Seu programa recebe uma sequência qualquer, com os elementos separados por espaço.
 * Saída:
 * Seu programa deve imprimir true se a sequência possuir elementos duplicados 
 * e false caso contrário.
 */

public class ElementosDuplicados {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        elementosDuplicados(array, 0, array.length - 1);
    }

    private static void elementosDuplicados(int[] array, int left, int right) {
        boolean duplicate = false;
        for (int i = 0; i < right; i++) {
            if (array[i] == array[i + 1]) {
                duplicate = true;
            }
        }
        System.out.println(duplicate);
    }
    
}
