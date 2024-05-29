/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.queue.queueDoubleStackContains.queue;

import estruturasLineares.queue.queueDoubleStack.stack.StackOverflowException;
import estruturasLineares.queue.queueDoubleStack.stack.StackUnderflowException;

/**
 * The interface of a generic queue. The queue is able to store any kind of
 * data.
 */
public interface Queue<T> {

	/**
	 * Verifies an element in a queue (made of two stacks):
	 * stack1 is the main queue; stack2 is an auxiliary one.
	 * @param element
	 * @return true or false, if the element is in the queue
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	public boolean contains(T element) throws StackOverflowException, StackUnderflowException;

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
