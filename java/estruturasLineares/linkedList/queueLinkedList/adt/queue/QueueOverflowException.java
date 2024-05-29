/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.linkedList.queueLinkedList.adt.queue;

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Queue is full");
	}

}
