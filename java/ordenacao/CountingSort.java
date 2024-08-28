/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        countingSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void countingSort(int[] array, int left, int right) {
		int greater = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (array[i] > greater) {
				greater = array[i];
			}
		}
		int[] count = new int[greater + 1];
		for (int i = left; i <= right; i++) {
			count[array[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		int[] aux = new int[right - left + 1];
		for (int i = right; i >= left; i--) {
			aux[count[array[i]] - 1] = array[i];
			count[array[i]]--;
		}
		for (int i = left; i <= right; i++) {
			array[i] = aux[i - left];
		}
	}
    
}
