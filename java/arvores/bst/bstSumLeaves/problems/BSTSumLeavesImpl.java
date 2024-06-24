/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstSumLeaves.problems;

import adt.bst.BST;
import adt.bst.BSTNode;
import java.util.Scanner;

public class BSTSumLeavesImpl implements BSTSumLeaves {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        BSTInteger tree = new BSTInteger();
        BSTSumLeavesImpl bst = new BSTSumLeavesImpl();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        System.out.println(bst.sumLeaves(tree));
    }

    @Override
    public int sumLeaves(BST<Integer> bst) {
        return this.sumLeavesRecursive((BSTNode<Integer>) bst.getRoot());
    }

    private int sumLeavesRecursive(BSTNode<Integer> node) {
        int result = 0;
        if (node != null && !node.isEmpty()) {
            if (node.isLeaf()) {
                result = node.getData();
            }
            else {
                result = this.sumLeavesRecursive((BSTNode<Integer>) node.getLeft()) 
                        + this.sumLeavesRecursive((BSTNode<Integer>) node.getRight());
            }
        }
        return result;
    }

}
