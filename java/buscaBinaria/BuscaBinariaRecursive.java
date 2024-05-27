/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package buscaBinaria;

import java.util.Scanner;

/**
 * Implemente um programa que leia uma sequência ordenada de inteiros e um número N, 
 * e que verifica se N está na sequência lida. Seu programa deve fazer uma busca binária 
 * na sequência.
 * Entrada:
 * Seu programa deve ler da entrada duas linhas: a primeira é a linha contendo uma sequência 
 * de inteiros separados por espaço, enquanto a segunda é um número N a ser pesquisado 
 * na sequência.
 * Saída:
 * Seu programa deve imprimir (separadamente em cada linha) os índices visitados 
 * até o fim da execução do algoritmo. Caso não encontre N, deve imprimir o último 
 * índice como sendo -1.
 * Restrições:
 * Você não pode usar coleção ou método algum do Collections framework.
 * Sua implementação deve ser baseada em arrays.
 */

public class BuscaBinariaRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        binarySearch(array, num, 0, array.length - 1);
    }

    private static void binarySearch(int[] array, int num, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right) {
            System.out.println(-1);
        }
        else if (num == array[mid]) {
            System.out.println(mid);
        }
        else if (num < array[mid]) {
            System.out.println(mid);
            binarySearch(array, num, left, mid - 1);
        }
        else {
            System.out.println((mid + 1) - 1);
            binarySearch(array, num, mid + 1, right);
        }
    }
    
}
