/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstDistance.problems;

import adt.bst.BSTNode;
import java.util.Scanner;

public class BSTDistanceImpl implements BSTDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int num = sc.nextInt();
        BSTInteger tree = new BSTInteger();
        BSTDistanceImpl bst = new BSTDistanceImpl();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        System.out.println(bst.distance(tree.getRoot(), num));
    }

    @Override
    public int distance(BSTNode<Integer> bst, int elem) {
        int result = -1;
        if (!bst.isEmpty()) {
            result = this.distanceAux(bst, elem);
        }
        return result;
    }

    private int distanceAux(BSTNode<Integer> bst, int elem) {
        int result = -1;
        if (elem == bst.getData()) {
            result = 0;
        }
        else {
            if (elem < bst.getData()) {
                result = 1 + this.distanceAux((BSTNode<Integer>) bst.getLeft(), elem);
            }
            else if (elem > bst.getData()) {
                result = 1 + this.distanceAux((BSTNode<Integer>) bst.getRight(), elem);
            }
        }
        return result;
    }

}
