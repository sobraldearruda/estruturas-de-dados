/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package ordenacao;

import java.util.Scanner;
import java.util.Arrays;

/**
  * Para atender uma demanda alta de requisições no dia de matrícula, o desenvolvedor do sistema 
  * utilizou as requisições em um array ordenado por ordem de chegada.
  * Implemente um método para transformar duas sequências ordenadas em uma sequência ordenada.
  * Entrada:
  * Seu programa irá ler dois arrays de entrada, que consiste em listas de inteiros 
  * separados por espaço.
  * Saída:
  * Na saída, deve ser impresso o status do array final ordenado.
  * Dica:
  * Imprima o array com Arrays.toString(array).
  */

public class MergeTwoArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int[] array1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            array1[i] = Integer.parseInt(input1[i]);
        }
        String[] input2 = sc.nextLine().split(" ");
        int[] array2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            array2[i] = Integer.parseInt(input2[i]);
        }
        merge(array1, array2);
    }

    private static void merge(int[] array1, int[] array2) {
        int[] aux = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                aux[k++] = array1[i++];
            }
            else {
                aux[k++] = array2[j++];
            }
        }
        while (i < array1.length) {
            aux[k++] = array1[i++];
        }
        while (j < array2.length) {
           aux[k++] = array2[j++];
        }
        System.out.println(Arrays.toString(aux));
    }
    
}
