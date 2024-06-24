/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstCountGreaterLower.problems;

import adt.bst.BSTNode;

/**
 * Interface contendo métodos com variações de processamentos de uma BST
 **/
public interface BSTCountGreaterLower {

    /**
     * Conta quantos elemtentos são maiores que um valor n.
     */
    public int countGreater(BSTNode<Integer> bst, int n);

    /**
     * Conta quantos elementos são menores que um valor n.
     */
    public int countLower(BSTNode<Integer> bst, int n);

}
