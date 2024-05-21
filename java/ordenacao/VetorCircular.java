/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;

/**
 * Escreva um programa que imprime um vetor de maneira circular.
 * Seu programa deve receber uma sequência de valores e um inteiro N e deve imprimir 
 * as N posições da sequência lida. Naturalmente, N pode ser maior do que o tamanho 
 * da sequência lida. Nesses casos, você deve reiniciar a impressão partindo novamente 
 * do início do vetor.
 * Entrada:
 * Seu programa receberá na primeira linha uma sequência de valores separados por espaço e, 
 * na segunda linha, um valor N que dirá quantos elementos devem ser impressos.
 * Saída:
 * Seu programa deve imprimir a sequencia de números com N elementos de forma circular.
 * Ou seja, quando o último elemento for impresso ele deve voltar para o primeiro e 
 * continuar até chegar a N elementos impressos.
 */

public class VetorCircular {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        vetorCircular(array, 0, array.length - 1, num);
    }

    private static void vetorCircular(int[] array, int left, int right, int num) {
        String aux = "";
        while (aux.length() < num) {
            for (int i = left; i <= right; i++) {
                if (num > right && num != aux.length()) {
                    aux += String.valueOf(array[i]);
                }
                else if (num < right && num != aux.length()) {
                    aux += String.valueOf(array[i]);
                }
            }
        }
        System.out.println(aux.replaceAll("", " ").trim());
    }
    
}
