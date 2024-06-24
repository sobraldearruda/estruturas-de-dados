/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstSumLeaves.problems;

import adt.bst.BST;

/**
 * Interface contendo métodos com variações de processamentos de uma BST
 **/
public interface BSTSumLeaves {

    /**
     * Método para somar todas as folhas de uma BST de inteiros.
     * Restrições e informações:
     * - A classe BSTInteger é fornecida para que vocês não implementem 
     *   nenhuma BST. Vocês podem usá-la para testar a implementção de seu método
     * - Voce DEVE implementar o método USANDO RECURSÃO. Você pode usar método auxiliar 
     *   desde que implementado na classe BSTSumLeavesImpl
     * - Voce NÃO pode editar nenhuma outra classe
     * - Voce NÃO pode implementar nenhuma outra classe nova
     * - Para implementar o método sumLeaves você DEVE, da classe BSTInteger,
     *   USAR APENAS o método getRoot
     * - Você pode usar qualquer método da classe BSTNode mas NÃO pode modificá-la
     * - Voce DEVE implementar seu algoritmo com complexidade Theta(N)
     * - Sua implementacao DEVE ter relação de recorrência T(N) = 2T(N) + O(1)
     * - Voce NÃO PODE usar nenhuma outra estrutura auxiliar nem converter a BST 
     *   em outra estrutura, string, etc.
     **/
    public int sumLeaves(BST<Integer> bst);

}
