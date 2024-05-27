/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package buscaBinaria;

import java.util.Scanner;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, 
 * usar busca binária para encontrar o número de elementos do array que 
 * são menores do que x.
 * Exemplo:
 * 
 * A = [5, 7, 7, 8, 8, 10]
 * x = 6
 * Saída: 1 (apenas o 5 é menor que 6)
 * 
 * A = [5, 17, 100, 111]
 * x = 3
 * Saída: 0 (não tem nenhum elemento do array menor que 3)
 * 
 * Restrições:
 * - Seu algoritmo NÃO pode usar memória extra
 *   (a nao ser variáveis simples locais e não de coleção/estrutura)
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Você DEVE usar busca binária com recursão
 */

public class CountLessThan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        System.out.println(countLess(array, num));
    }

    private static int countLess(int[] array, int x) {
        return countLessRecursive(array, x, 0, array.length - 1);
    }
    
    private static int countLessRecursive(int[] array, int x, int left, int right) {
        int mid = (left + right) / 2;
        int result = 0;
        if (left >= 0 && left <= right && right >= 0 && right < array.length && array != null) {
            if (x == array[mid]) {
                result = mid - left;
                if (mid - 1 >= left && x == array[mid - 1]) {
                    result = (mid - 1) - left;
                }
            }
            else if (x > array[mid]) {
                result = (mid - left + 1) + countLessRecursive(array, x, mid + 1, right);
            }
            else if (x < array[mid]) {
                result = countLessRecursive(array, x, left, mid - 1);
            }
        }
        return result;
    }
    
}
