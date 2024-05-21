/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;

/**
 * Implemente o BubbleSort.
 * Entrada:
 * Seu programa deve ler da entrada apenas uma linha contendo uma sequência de inteiros 
 * separados por espaço.
 * Saída:
 * Seu programa deve imprimir o conteúdo do array a cada iteração do Bubble.
 * Seu programa deve parar assim que imprimir a sequência ordenada.
 * Restrições:
 * Você não pode usar coleção ou método algum do Collections framework. 
 * Sua implementação deve ser baseada em arrays.
 */

public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        bubbleSort(array, 0, array.length - 1);
    }

    private static void bubbleSort(int[] array, int left, int right) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    swapped = true;
                }
            }
            if (swapped) {
                String result = "";
                for (int i = 0; i <= right; i++) {
                    result += String.valueOf(array[i]) + " ";
                }
                System.out.println(result.trim());
            }
        }
    }
    
}
