/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        insertionSort(array, 0, array.length - 1);
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int aux = i - 1;
            while (aux >= left && array[aux] > key) {
                array[aux + 1] = array[aux];
                aux--;
            }
            array[aux + 1] = key;
        }
        System.out.println(Arrays.toString(array));
    }
    
}
