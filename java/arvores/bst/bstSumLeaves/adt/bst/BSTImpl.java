/**
 * Estruturas de Dados e Algoritmos
 * @author Rafael de Arruda Sobral
 */

package arvores.bst.bstSumLeaves.adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		this.root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			int left = this.height((BSTNode<T>) node.getLeft());
			int right = this.height((BSTNode<T>) node.getRight());
			height = 1 + Math.max(left, right);
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> resp = new BSTNode<T>();
		if (element != null) {
			resp = this.search(element, root);
		}
		return resp;
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> resp = node;
		if (!resp.isEmpty() && !resp.getData().equals(element)) {
			if (element.compareTo(resp.getData()) < 0) {
				resp = this.search(element, (BSTNode<T>) resp.getLeft());
			}
			else {
				resp = this.search(element, (BSTNode<T>) resp.getRight());
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insert(element, this.root);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void insert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>()
						.data(null)
						.left(null)
						.right(null)
						.parent(node)
						.build());
			node.setRight(new BSTNode.Builder<T>()
						.data(null)
						.left(null)
						.right(null)
						.parent(node)
						.build());
		} else {
			if (element.compareTo(node.getData()) < 0) {
				this.insert(element, (BSTNode<T>) node.getLeft());
			}
			else if (element.compareTo(node.getData()) > 0) {
				this.insert(element, (BSTNode<T>) node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> resp = null;
		if (!isEmpty()) {
			resp = this.maximum(root);
		}
		return resp;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> resp = node;
		if (!node.getRight().isEmpty()) {
			resp = this.maximum((BSTNode<T>) node.getRight());
		}
		return resp;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> resp = null;
		if (!isEmpty())
			resp = this.minimum(root);
		return resp;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> resp = node;
		if (!node.getLeft().isEmpty())
			resp = this.minimum((BSTNode<T>) node.getLeft());
		return resp;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> resp = null;
		BSTNode<T> aux = this.search(element);
		if (element != null && !isEmpty() && !aux.isEmpty()) {
			if (!aux.getRight().isEmpty()) {
				resp = this.minimum((BSTNode<T>) aux.getRight());
			}
			else {
				resp = this.sucessor(element, aux);
			}
		}
		return resp;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> node) {
		BSTNode<T> resp = (BSTNode<T>) node.getParent();
		if (resp != null && resp.getRight().equals(node)) {
			resp = this.sucessor(element, resp);
		}
		return resp;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> resp = null;
		BSTNode<T> aux = this.search(element);
		if (element != null && !isEmpty() && !aux.isEmpty()) {
			if (!aux.getLeft().isEmpty()) {
				resp = this.maximum((BSTNode<T>) aux.getLeft());
			}
			else {
				resp = this.predecessor(element, aux);
			}
		}
		return resp;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> resp = (BSTNode<T>) node.getParent();
		if (resp != null && resp.getLeft().equals(node)) {
			resp = this.predecessor(element, resp);
		}
		return resp;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		if (element != null && !node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
			} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
				BSTNode<T> child;
				if (!node.getRight().isEmpty()) {
					child = (BSTNode<T>) node.getRight();
				}
				else {
					child = (BSTNode<T>) node.getLeft();
				}
				if (node.equals(root)) {
					this.root = child;
					this.root.setParent(null);
				} else {
					BSTNode<T> parent = (BSTNode<T>) node.getParent();
					child.setParent(parent);
					if (parent.getLeft().equals(node)) {
						parent.setLeft(child);
					}
					else {
						parent.setRight(child);
					}
				}
			} else {
				T sucessor = this.sucessor(node.getData()).getData();
				this.remove(sucessor);
				node.setData(sucessor);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<T>();
		this.preOrder(list, this.root);
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void preOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			array.add(node.getData());
			this.preOrder(array, (BSTNode<T>) node.getLeft());
			this.preOrder(array, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();
		this.order(list, this.root);
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void order(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			this.order(array, (BSTNode<T>) node.getLeft());
			array.add(node.getData());
			this.order(array, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();
		this.postOrder(list, this.root);
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			this.postOrder(array, (BSTNode<T>) node.getLeft());
			this.postOrder(array, (BSTNode<T>) node.getRight());
			array.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand how
	 * it works and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
