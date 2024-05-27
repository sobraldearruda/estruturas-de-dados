/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package buscaBinaria;

import java.util.Scanner;

/**
 * Usa a Busca Binária para encontrar o último índice de um número.
 * A sequência está ordenada e contém números possivelmente repetidos.
 * Entrada:
 * Na primeira linha, uma sequência de inteiros ordenados.
 * Na segunda linha, o número procurado.
 * Saída:
 * O índice da última aparição do número procurado.
 */

public class FloorLastIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        System.out.println(floorLastIndex(array, num, 0, array.length - 1));
    }

    private static int floorLastIndex(int[] array, int num, int left, int right) {
        int result = -1;
        int mid = (left + right) / 2;
        if (left <= right) {
            if (num == array[mid] && (mid == right || num < array[mid + 1])) {
                result = mid;
            }
            else if (num < array[mid]) {
                result = floorLastIndex(array, num, left, mid - 1);
            }
            else {
                result = floorLastIndex(array, num, mid + 1, right);
            }
        }
        return result;
    }
    
}
