/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstCountLeaves.problems;

import adt.bst.BSTNode;
import java.util.Scanner;

public class BSTCountLeavesImpl implements BSTCountLeaves {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        BSTInteger tree = new BSTInteger();
        BSTCountLeavesImpl bst = new BSTCountLeavesImpl();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        System.out.println(bst.countLeaves(tree.getRoot()));
    }

    @Override
    public int countLeaves(BSTNode<Integer> bst) {
        int result = 0;
        if (!bst.isEmpty()) {
            result = this.countLeavesAux(bst);
        }
        return result;
    }

    private int countLeavesAux(BSTNode<Integer> node) {
        int count = 0;
        if (node.isLeaf()) {
            count = 1;
        }
        else {
            count = this.countLeavesAux((BSTNode<Integer>) node.getLeft()) + 
                    this.countLeavesAux((BSTNode<Integer>) node.getRight());
        }
        return count;
    }

}
