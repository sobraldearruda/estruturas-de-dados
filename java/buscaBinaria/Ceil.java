/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package buscaBinaria;

import java.util.Scanner;

/**
 * Dado um array arbitrário ordenado de inteiros e um parâmetro x, 
 * ceil é o elemento do array igual a x, ou maior e mais próximo possível 
 * de x (caso x não pertença ao array).
 * Restrições:
 * - seu método deve ter tempo O(n.log n)
 * - seu método deve usar a estratégia de busca binária (recursiva) para buscar o ceil
 * - toda sua solução deve ser in-place
 * - você não pode usar nenhum método pronto de qualquer biblioteca
 * - você pode assumir que o array não tem elementos repetidos
 */

public class Ceil {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        System.out.println(ceil(array, num, 0, array.length - 1));
    }

    private static int ceil(int[] array, int num, int left, int right) {
        int result = -1;
        int mid = (left + right) / 2;
        if (left <= right) {
            if (num == array[mid]) {
                result = array[mid];
            }
            else if (num < array[mid]) {
                result = array[mid];
                if ((mid - 1 >= left) && (num <= array[mid - 1])) {
                    result = ceil(array, num, left, mid - 1);
                }
            }
            else if (num > array[mid]) {
                result = ceil(array, num, mid + 1, right);
            }
        }
        return result;
    }
    
}
