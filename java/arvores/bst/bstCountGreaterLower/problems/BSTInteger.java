/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstCountGreaterLower.problems;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Esta classe é fornecida como uma implementação de uma BST para propósitos de teste.
 * NÃO MODIFIQUE ESSA CLASSE!!!!
 */
public class BSTInteger extends BSTImpl<Integer>{

    @Override
    public void insert(Integer element) {
        insert(root, element);
    }

    protected void insert(BSTNode<Integer> node, Integer element) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode<Integer>());
            node.getLeft().setParent(node);
            node.setRight(new BSTNode<Integer>());
            node.getRight().setParent(node);
        } else {
            if (element.compareTo(node.getData()) < 0) {
                insert((BSTNode<Integer>)node.getLeft(), element);
            } else if (element.compareTo(node.getData()) > 0) {
                insert((BSTNode<Integer>)node.getRight(), element);
            }
        }
    }
    
}
