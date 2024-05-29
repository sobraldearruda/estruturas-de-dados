/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.linkedList.mixLinkedList.problems;

import estruturasLineares.linkedList.mixLinkedList.singleLinkedList.SingleLinkedListNode;

/**
 * Classe contendo método utilitário para fazer o mix de duas listas 
 * simplesmente ligadas já ordenadas a partir de seus primeiros nós.
 */
public interface LinkedListMix<T extends Comparable<T>> {
    
    /**
     * Método que faz o merge de duas listas ordenadas a partir de seus nós.
     * O método modifica os nós recebidos como parâmetros, ligando corretamente os nós 
     * das listas, de forma a fazer o merge delas in-place.
     * A ideia é ir olhando sempre os elementos da esquerda para a direita e alterar 
     * os apontadores dos nós, de forma conveniente, para que eles sejam corretamente 
     * encadeados e produzam uma lista final ordenada.
     * 
     * Restrições:
     * - Você não pode usar nenhuma outra estrutura auxiliar
     * - Voce não pode converter as listas em coleção e depois operar as coleções
     * - Seu algoritmo DEVE ter performance O(k(N+M)) onde k=1, N é o tamanho da lista 1 
     *   (cujo head é node1) e M é o tamanho da lista 2 (cujo head é node2)
     * - As listas passadas como parâmetros NÃO possuem elementos em comum
     * 
     * @param node1 o primeiro nó da primeira lista. A lista já está ordenada
     * @param node2 o primeiro nó da segunda lista. A lista já está ordenada
     */
    public void mix(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2);

}
