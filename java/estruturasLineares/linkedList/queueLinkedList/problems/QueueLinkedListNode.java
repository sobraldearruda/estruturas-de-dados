package estruturasLineares.linkedList.queueLinkedList.problems;

import estruturasLineares.linkedList.queueLinkedList.adt.queue.Queue;

/**
 * Interface que modela uma fila a ser implementada usando-se 
 * SingleLinkedListNode como estrutura sobrejacente.
 * 
 * Restrições:
 * - Você NÃO pode usar qualquer outra estrutura auxiliar, 
 *   apenas SingleLinkedListNode ou tipos primitivos.
 * - TODOS os métodos precisam ter complexidade O(1).
 * - Você DEVE respeitar a política FIFO seguida por Fila.
 */
public interface QueueLinkedListNode<T> extends Queue<T> {
    
    /**
	 * Retorna a quantidade de elementos existentes na estrutura.
	 */
    public int size();
    
}
