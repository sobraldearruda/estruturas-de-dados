/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Escreva um programa que ordena um array de inteiros utilizando o MergeSort.
 * Seu programa deve imprimir o status a cada etapa do algoritmo.
 * Entrada:
 * Seu programa irá ler apenas uma linha de entrada, que consiste em uma lista de inteiros 
 * separados por espaço.
 * Saída:
 * Na saída, deve ser impresso o status do array a cada modificação, 
 * desde a impressão do array inicial até o array ordenado.
 * Restrições:
 * Seu programa deve, obrigatoriamente, imprimir passo a passo cada etapa do MergeSort.
 * Dica:
 * Imprima o array com Arrays.toString(array).
 */

public class MergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        output(array, left, right);
        if (left >= 0 && left < right && right < array.length) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] aux = new int[array.length];
        for (int i = left; i <= right; i++) {
            aux[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                array[k] = aux[i];
                i++;
            }
            else {
                array[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = aux[i];
            i++;
            k++;
        }
        output(array, left, right);
    }

    private static void output(int[] array, int left, int right) {
        int[] output = new int[right - left + 1];
        for (int i = 0; i < output.length; i++) {
          output[i] = array[i + left];
        }
        System.out.println(Arrays.toString(output));
    }
    
}
