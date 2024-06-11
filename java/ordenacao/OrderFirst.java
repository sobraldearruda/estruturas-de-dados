/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implemente um método que posiciona o primeiro elemento de uma sequência de forma
 * a ordená-la. A sequência de entrada está sempre ordenada de forma crescente,
 * exceto pelo primeiro número.
 * Restrições:
 * Você não pode usar coleção ou método algum do Collections framework. 
 * Sua implementação deve ser baseada em arrays.
 */

public class OrderFirst {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        orderFirst(array, 0, array.length - 1);
    }

    private static void orderFirst(int[] array, int left, int right) {
        int i = left;
        while (i < right && array[i + 1] < array[i]) {
            int aux = array[i];
            array[i] = array[i + 1];
            array[i + 1] = aux;
            i++;
        }
        System.out.println(Arrays.toString(array));
    }
    
}
