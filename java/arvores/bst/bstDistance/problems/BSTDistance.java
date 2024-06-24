/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstDistance.problems;

import adt.bst.BSTNode;

/**
 * Interface contendo métodos com variações de processamentos de uma BST
 **/
public interface BSTDistance {

    /**
     * Verifica a distância entre a raiz e um nó específico.
     * Considere que o valor do nó faz parte da árvore.
     */
    public int distance(BSTNode<Integer> bst, int elem);

}
