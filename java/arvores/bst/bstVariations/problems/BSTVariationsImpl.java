/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package problems;

import adt.bst.BSTNode;
import java.util.Scanner;

public class BSTVariationsImpl implements BSTVariations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        BSTInteger tree = new BSTInteger();
        BSTVariationsImpl bst = new BSTVariationsImpl();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        System.out.println(bst.mirror(tree.getRoot()));
        System.out.println(bst.equals(tree.getRoot(), tree.getRoot())); // second parameter must be changed
    }

    @Override
    public BSTNode<Integer> mirror(BSTNode<Integer> bst) {
        return this.mirrorAux(bst);
    }

    private BSTNode<Integer> mirrorAux(BSTNode<Integer> bst) {
        BSTNode<Integer> newNode = bst;
        if (!newNode.isEmpty()) {
            newNode.setLeft(this.mirrorAux((BSTNode<Integer>) bst.getRight()));
            newNode.setRight(this.mirrorAux((BSTNode<Integer>) bst.getLeft()));
        }
        return newNode;
    }

    @Override
    public boolean equals(BSTNode<Integer> node1, BSTNode<Integer> node2) {
        return this.equalsRecursive(node1, this.mirror(node2));
    }

    private boolean equalsRecursive(BSTNode<Integer> node1, BSTNode<Integer> node2) {
		boolean left = false;
		boolean right = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			left = true;
			right = true;
		}
		else if (!node1.isEmpty() && !node2.isEmpty() && node1.equals(node2)) {
			left = this.equalsRecursive((BSTNode<Integer>) node1.getLeft(), (BSTNode<Integer>) node2.getLeft());
			right = this.equalsRecursive((BSTNode<Integer>) node1.getRight(), (BSTNode<Integer>) node2.getRight());
		}
		return left && right;
    }

}
