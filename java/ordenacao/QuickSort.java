/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array, and
 * all elements greater than the pivot go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */

public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
	}

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, left, i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
    
}
