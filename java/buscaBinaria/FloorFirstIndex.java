/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package buscaBinaria;

import java.util.Scanner;

/**
 * Usa a Busca Binária para encontrar o primeiro índice de um número.
 * A sequência está ordenada e contém números possivelmente repetidos.
 * Entrada:
 * Na primeira linha, uma sequência de inteiros ordenados.
 * Na segunda linha, o número procurado.
 * Saída:
 * O índice da primeira aparição do número procurado.
 */

public class FloorFirstIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        System.out.println(floorFirstIndex(array, num, 0, array.length - 1));
    }

    private static int floorFirstIndex(int[] array, int num, int left, int right) {
        int result = -1;
        int mid = (left + right) / 2;
        if (left <= right) {
            if (num == array[mid] && (mid == 0 || num > array[mid - 1])) {
                result = mid;
            } else if (num <= array[mid]) {
                result = floorFirstIndex(array, num, left, mid - 1);
            }
            else {
                result = floorFirstIndex(array, num, mid + 1, right);
            }
        }
        return result;
    }
    
}
