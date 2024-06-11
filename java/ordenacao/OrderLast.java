/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implemente um método que posiciona o último elemento de uma sequência de forma
 * a ordená-la. A sequência de entrada está sempre ordenada de forma crescente,
 * exceto pelo último número.
 * Restrições:
 * Você não pode usar coleção ou método algum do Collections framework. 
 * Sua implementação deve ser baseada em arrays.
 */

public class OrderLast {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        orderLast(array, 0, array.length - 1);
    }

    private static void orderLast(int[] array, int left, int right) {
        int i = right;
        while (i > left && array[i - 1] > array[i]) {
            int aux = array[i];
            array[i] = array[i - 1];
            array[i - 1] = aux;
            i--;
        }
        System.out.println(Arrays.toString(array));
    }
    
}
