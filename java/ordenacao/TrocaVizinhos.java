/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Escreva um programa que leia uma sequência de números inteiros e troca os elementos vizinhos.
 * Se o tamanho da sequência for ímpar, troque os vizinhos e mantenha o último elemento 
 * em sua posição.
 * Entrada:
 * Seu programa irá ler uma sequência e armazená-la em um array de inteiros.
 * Saída:
 * Na saída, seu programa deve imprimir o array resultante da troca dos elementos vizinhos.
 * Dica: use Arrays.toString() para formatar a saída.
 * Restrições:
 * O algoritmo deve ser in-place.
 * Ou seja, não é permitido utilizar qualquer outro array auxiliar para trocar os elementos.
 */

public class TrocaVizinhos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        trocaVizinhos(array, 0, array.length - 1);
    }

    private static void trocaVizinhos(int[] array, int left, int right) {
        int aux = array[left];
        for (int i = left; i <= right; i++) {
            if ((i % 2 == 0) && (i + 1 <= right)) {
                aux = array[i];
                array[i] = array[i + 1];
            }
            else if (i % 2 != 0) {
                array[i] = aux;
            }
            else {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    
}
