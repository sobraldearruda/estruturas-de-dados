/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Versão recursiva do BubbleSort.
 */

public class BubbleSortRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        bubbleSortRecursive(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSortRecursive(int[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            if (array[i] > array[i + 1]) {
                int aux = array[i];
                array[i] = array[i + 1];
                array[i + 1] = aux;
            }
        }
        bubbleSortRecursive(array, left, right - 1);
    }
    
}
