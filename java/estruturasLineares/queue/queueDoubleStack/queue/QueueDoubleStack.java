/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package estruturasLineares.queue.queueDoubleStack.queue;

import estruturasLineares.queue.queueDoubleStack.stack.*;

public class QueueDoubleStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueDoubleStack(int size) {
		this.stack1 = new StackImpl<T>(size);
		this.stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			if (element != null) {
				this.stack1.push(element);
			}
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T aux = null;
		try {
			this.turnOver();
			aux = this.stack2.pop();
			this.turnOver();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
		} catch (StackOverflowException e) {
		}
		return aux;
	}

	@Override
	public T head() {
		T aux = null;
		try {
			this.turnOver();
			aux = this.stack2.top();
			this.turnOver();
		} catch (StackUnderflowException e) {
		} catch (StackOverflowException e) {
		}
		return aux;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

	private void turnOver() throws StackOverflowException, StackUnderflowException {
		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty()) {
				this.stack2.push(this.stack1.pop());
			}
		}
		else {
			while (!this.stack2.isEmpty()) {
				this.stack1.push(this.stack2.pop());
			}
		}
	}

}
