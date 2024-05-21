/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que 
 * funciona de forma ligeiramente diferente. Relembre que quando o pivot 
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um 
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas 
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o 
 * pivot. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivot.
 * 4. Colocar o pivot na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivot.
 */

public class QuickSortMedianOfThree {

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
        int pivot = pivotMedianOfThree(array, left, right);
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

    private static int pivotMedianOfThree(int[] array, int left, int right) {
		int mid = (left + right) / 2;
		if (array[left] > array[right]) {
			swap(array, right, left);
		}
		if (array[left] > array[mid]) {
			swap(array, mid, left);
		}
		if (array[mid] > array[right]) {
			swap(array, right, mid);
		}
		return mid;
	}

    private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
    
}
