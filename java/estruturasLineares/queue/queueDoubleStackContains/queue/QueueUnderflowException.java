/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.queue.queueDoubleStackContains.queue;

public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Queue is empty");
	}

}
