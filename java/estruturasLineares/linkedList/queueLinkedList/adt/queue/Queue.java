/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.linkedList.queueLinkedList.adt.queue;

/**
 * The interface of a generic queue. The queue is able to store any kind of
 * data.
 */
public interface Queue<T> {

	/**
	 * Inserts a new element in the queue or returns an exception if the queue
	 * is full. Null elements are not allowed (the queue remains unchanged).
	 * @param element
	 * @throws QueueOverflowException
	 */
	public void enqueue(T element) throws QueueOverflowException;

	/**
	 * If the queue has elements, it removes the oldest of the queue and returns
	 * it; otherwise, it throws an exception.
	 * @throws QueueUnderflowException
	 */
	public T dequeue() throws QueueUnderflowException;

	/**
	 * Returns (without removing) the oldest element of the queue; or 
	 * null if the queue is empty.
	 */
	public T head();

	/**
	 * Returns true if the queue is empty; or false, otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Returns true if the queue is full; or false, otherwise.
	 */
	public boolean isFull();

}
