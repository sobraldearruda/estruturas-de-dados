/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.linkedList.queueLinkedList.problems;

import estruturasLineares.linkedList.queueLinkedList.adt.queue.QueueOverflowException;
import estruturasLineares.linkedList.queueLinkedList.adt.queue.QueueUnderflowException;
import estruturasLineares.linkedList.queueLinkedList.adt.singleLinkedList.SingleLinkedListNode;

public class QueueLinkedListNodeImpl<T> implements QueueLinkedListNode<T>{

    private SingleLinkedListNode<T> head;
    private SingleLinkedListNode<T> tail;
    private int capacity;
    private int size;

    /**
     * Construtor da classe. Esse construtor precisa existir.
     * Restrição:
     * - NÃO altere a assinatura desse construtor.
     * - Você pode ajustar apenas o corpo do construtor, se necessário.
     */
    public QueueLinkedListNodeImpl(int size) {
        this.head = new SingleLinkedListNode<>();
        this.tail = new SingleLinkedListNode<>();
        this.capacity = size;
    }

    public void enqueue(T element) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException();
        }
        if (element != null) {
            SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            }
            else {
                this.tail.setNext(newNode);
                this.tail = newNode;
            }
            this.size++;
        }
    }

	public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }
        T aux = this.head();
        if (this.head.getNext().isNIL()) {
            this.head = new SingleLinkedListNode<T>();
            this.tail = new SingleLinkedListNode<T>();
        }
        else {
            this.head = this.head.getNext();
        }
        this.size--;
        return aux;
    }

	public T head() {
        T aux = null;
        if (!this.isEmpty()) {
            aux = this.head.getData();
        }
        return aux;
    }

	public boolean isEmpty() {
        return this.tail.isNIL();
    }

	public boolean isFull() {
        return this.size == this.capacity;
    }

    public int size() {
        return this.size;
    }

}
