/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;
import java.util.Arrays;

/**
 * O algoritmo Odd-EvenSort é uma variação do BubbleSort. Ele funciona através da comparação de 
 * todos os pares indexados com ímpar de elementos adjacentes. Se um par está na ordem errada 
 * (A[i] A[i+1] estão na ordem errada), os elementos são trocados. O próximo passo repete isso 
 * para os pares indexados com par de elementos adjacentes. E o algoritmo continua até que a 
 * entrada esteja ordenada. Você pode pensar no algoritmo como se a cada iteração um BubbleSort é
 * aplicado considerando índices ímpares e outro considerando índices pares (as trocas são feitas
 * entre elementos A[i] e A[i+1]). Quando não houver mais trocas significa que o array 
 * está ordenado. Implemente o Odd-EvenSort.
 */

public class OddEvenSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        oddEvenSort(array, 0, array.length - 1);
    }

    private static void oddEvenSort(int[] array, int left, int right) {
        boolean sorted = false;
        while (sorted == false) {
            sorted = true;
            for (int i = left; i < right; i += 2) {
                if (array[i] > array[i + 1]) {
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    sorted = false;
                }
            }
            for (int i = left + 1; i < right; i += 2) {
                if (array[i] > array[i + 1]) {
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    sorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    
}
