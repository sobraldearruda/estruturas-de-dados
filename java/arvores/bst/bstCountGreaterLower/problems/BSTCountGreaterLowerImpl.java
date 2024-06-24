/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstCountGreaterLower.problems;

import adt.bst.BSTNode;
import java.util.Scanner;

public class BSTCountGreaterLowerImpl implements BSTCountGreaterLower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        BSTInteger tree = new BSTInteger();
        BSTCountGreaterLowerImpl bst = new BSTCountGreaterLowerImpl();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        System.out.println(bst.countGreater(tree.getRoot(), num));
        System.out.println(bst.countLower(tree.getRoot(), num));
    }

    @Override
    public int countGreater(BSTNode<Integer> bst, int n) {
        return this.countGreaterAux(bst, n);
    }

    private int countGreaterAux(BSTNode<Integer> node, Integer n) {
        int count = 0;
        if (!node.isEmpty()) {
            if (n != null) {
                if (n >= node.getData()) {
                    count = this.countGreaterAux((BSTNode<Integer>) node.getRight(), n);
                }
                else {
                    count = 1 + this.countGreaterAux((BSTNode<Integer>) node.getLeft(), n) + 
                            this.countGreaterAux((BSTNode<Integer>) node.getRight(), n);
                }
            }
        }
        return count;
    }

    @Override
    public int countLower(BSTNode<Integer> bst, int n) {
        return this.countLowerAux(bst, n);
    }

    private int countLowerAux(BSTNode<Integer> node, Integer n) {
        int count = 0;
        if (!node.isEmpty()) {
            if (n != null) {
                if (n <= node.getData()) {
                    count = this.countLowerAux((BSTNode<Integer>) node.getLeft(), n);
                }
                else {
                    count = 1 + this.countLowerAux((BSTNode<Integer>) node.getLeft(), n) + 
                            this.countLowerAux((BSTNode<Integer>) node.getRight(), n);
                }
            }
        }
        return count;
    }

}
