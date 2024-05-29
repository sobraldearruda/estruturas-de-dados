/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.linkedList.mixLinkedList.problems;

import estruturasLineares.linkedList.mixLinkedList.singleLinkedList.SingleLinkedListNode;

public class LinkedListMixImpl<T extends Comparable<T>> implements LinkedListMix<T> {

    /*
     * Essa resolução transgride a restrição de ser in-place.
     * Para tanto, seria necessário alterar os dois parâmetros, ou apenas um deles.
     */
    public void mix(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
        SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<>();
        if (node1.getData().compareTo(node2.getData()) < 0) {
            auxHead = node1;
            node1 = node1.getNext();
        } else {
            auxHead = node2;
            node2 = node2.getNext();
        }
        SingleLinkedListNode<T> mixed = auxHead;
        while (!node1.isNIL() && !node2.isNIL()) {
            if (node1.getData().compareTo(node2.getData()) < 0) {
                mixed.setNext(node1);
                node1 = node1.getNext();
            }
            else {
                mixed.setNext(node2);
                node2 = node2.getNext();
            }
            mixed = mixed.getNext();
        }
        if (!node1.isNIL()) {
            mixed.setNext(node1);
        }
        if (!node2.isNIL()) {
            mixed.setNext(node2);
        }
    }

}
