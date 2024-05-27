/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package buscaBinaria;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, 
 * possivelmente com mais de uma ocorrência, usar busca binária para encontrar 
 * as posições da primeira e última ocorrências de x em A.
 * Restrições:
 * - Seu algoritmo NÃO pode usar memória extra
 *   (a não ser variáveis simples locais e não de coleção/estrutura)
 * - O tempo de seu algoritmo deve ser O(log n)
 * - Retornar um array com dois elementos [primeiraPosicao, ultimaPosicao], onde primeiraPosicao
 *   tem o valor do índice da primeira ocorrência de x em A, e ultimaPosicao tem o valor do indice 
 *   da última ocorrência de x em A
 * - Note que se x não está em A então o retorno deve ser [-1, -1]
 */

public class StartEndPosition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        System.out.println(Arrays.toString(startEndPosition(array, num, 0, array.length - 1)));
    }

    private static int[] startEndPosition(int[] array, int num, int left, int right) {
        int start = startPosition(array, num, left, right);
        int end = endPosition(array, num, left, right);
        return new int[] {start, end};
    }

    private static int startPosition(int[] array, int num, int left, int right) {
        int result = -1;
        int mid = (left + right) / 2;
        if (left <= right) {
            if (num == array[mid] && (mid == 0 || num > array[mid - 1])) {
                result = mid;
            } else if (num <= array[mid]) {
                result = startPosition(array, num, left, mid - 1);
            }
            else {
                result = startPosition(array, num, mid + 1, right);
            }
        }
        return result;
    }

    private static int endPosition(int[] array, int num, int left, int right) {
        int result = -1;
        int mid = (left + right) / 2;
        if (left <= right) {
            if (num == array[mid] && (mid == right || num < array[mid + 1])) {
                result = mid;
            }
            else if (num < array[mid]) {
                result = endPosition(array, num, left, mid - 1);
            }
            else {
                result = endPosition(array, num, mid + 1, right);
            }
        }
        return result;
    }
    
}
