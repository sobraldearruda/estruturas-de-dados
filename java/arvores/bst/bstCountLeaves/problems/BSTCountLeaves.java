/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstCountLeaves.problems;

import adt.bst.BSTNode;

/**
 * Interface contendo métodos com variações de processamentos de uma BST
 **/
public interface BSTCountLeaves {

    /**
     * Conta o número de folhas em uma árvore.
     */
    public int countLeaves(BSTNode<Integer> bst);

}
