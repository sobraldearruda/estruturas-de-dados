/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.linkedList.queueLinkedList.adt.queue;

public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Queue is empty");
	}

}
