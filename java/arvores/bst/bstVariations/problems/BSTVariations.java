/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package problems;

import adt.bst.BSTNode;

/**
 * Interface contendo métodos com variações de processamentos de uma BST
 **/
public interface BSTVariations {

    /**
     * Transforma uma árvore em sua versão espelhada.
     */
    public BSTNode<Integer> mirror(BSTNode<Integer> bst);

    /**
     * Verifica se uma árvore é igual a outra.
     */
    public boolean equals(BSTNode<Integer> bst1, BSTNode<Integer> bst2);

}
