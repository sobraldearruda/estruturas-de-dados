/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.queue.queueDoubleStackContains.stack;

/**
 * The interface of a generic stack. The stack is able to store any kind of
 * data.
 */
public interface Stack<T> {

	/**
	 * Inserts a new element in the stack or returns an exception if the stack
	 * is full. Null elements are not allowed (the stack remains unchanged).
	 * @param element
	 * @throws StackOverflowException
	 */
	public void push(T element) throws StackOverflowException;

	/**
	 * If the stack has elements, it removes the top of the stack and returns
	 * it; otherwise, it returns an exception.
	 * @throws StackUnderflowException
	 */
	public T pop() throws StackUnderflowException;

	/**
	 * Returns (without removing) the top element of the stack or null if the
	 * stack is empty.
	 */
	public T top();

	/**
	 * Returns true if the stack is empty or false, otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Returns true if the stack is full or false, otherwise.
	 */
	public boolean isFull();

}
