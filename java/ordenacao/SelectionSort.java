/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Escreva um programa que ordena um array de inteiros utilizando o SelectionSort.
 * Seu programa deve imprimir o status do array ao fim de cada iteração.
 * Entrada:
 * Seu programa irá ler apenas uma linha de entrada, que consiste em uma lista de inteiros 
 * separados por espaço.
 * Saída:
 * Na saída, imprima o array de entrada a cada fim de iteração. 
 * Seu programa deve parar assim que imprimir a sequência ordenada.
 * Dica:
 * Use Arrays.toString(array) para imprimir o array.
 */

public class SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        selectionSort(array, 0, array.length - 1);
    }

    private static void selectionSort(int[] array, int left, int right) {
        for (int i = left; i <= right; i++) {
            int lower = i;
            for (int j = i + 1; j <= right; j++) {
                if (array[j] < array[lower]) {
                    lower = j;
                }
            }
            if (lower != i) {
                int aux = array[i];
                array[i] = array[lower];
                array[lower] = aux;
                System.out.println(Arrays.toString(array));
            }
        }
    }

}
