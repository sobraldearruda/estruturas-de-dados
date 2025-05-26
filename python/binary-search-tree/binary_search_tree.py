"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

class BSTNode:

    def __init__(self, data=None, parent=None):
        self.data = data
        self.left = None
        self.right = None
        self.parent = parent

    def is_empty(self):
        return self.data is None

    def is_leaf(self):
        return not self.is_empty() and self.left.is_empty() and self.right.is_empty()

    def __repr__(self):
        return f"BSTNode({self.data})" if self.data is not None else "Empty"

class BST:

    def __init__(self):
        self.root = BSTNode()

    def is_empty(self):
        return self.root.is_empty()

    def height(self, node=None):
        if node is None:
            node = self.root
        if node.is_empty():
            return -1
        return 1 + max(self.height(node.left), self.height(node.right))

    def search(self, element, node=None):
        if element is None:
            return BSTNode()
        if node is None:
            node = self.root
        if node.is_empty() or node.data == element:
            return node
        elif element < node.data:
            return self.search(element, node.left)
        else:
            return self.search(element, node.right)

    def insert(self, element, node=None, parent=None):
        if element is None:
            return
        if node is None:
            node = self.root
        if node.is_empty():
            node.data = element
            node.left = BSTNode(parent=node)
            node.right = BSTNode(parent=node)
            node.parent = parent
        elif element < node.data:
            self.insert(element, node.left, node)
        elif element > node.data:
            self.insert(element, node.right, node)

    def maximum(self, node=None):
        if self.is_empty():
            return None
        if node is None:
            node = self.root
        while not node.right.is_empty():
            node = node.right
        return node

    def minimum(self, node=None):
        if self.is_empty():
            return None
        if node is None:
            node = self.root
        while not node.left.is_empty():
            node = node.left
        return node

    def successor(self, element):
        node = self.search(element)
        if node.is_empty():
            return None
        if not node.right.is_empty():
            return self.minimum(node.right)
        parent = node.parent
        while parent and parent.right == node:
            node = parent
            parent = parent.parent
        return parent

    def predecessor(self, element):
        node = self.search(element)
        if node.is_empty():
            return None
        if not node.left.is_empty():
            return self.maximum(node.left)
        parent = node.parent
        while parent and parent.left == node:
            node = parent
            parent = parent.parent
        return parent

    def remove(self, element):
        node = self.search(element)
        if node.is_empty():
            return
        if node.is_leaf():
            node.data = None
            node.left = None
            node.right = None
        elif node.left.is_empty() or node.right.is_empty():
            child = node.right if not node.right.is_empty() else node.left
            if node == self.root:
                self.root = child
                self.root.parent = None
            else:
                parent = node.parent
                if parent.left == node:
                    parent.left = child
                else:
                    parent.right = child
                child.parent = parent
        else:
            successor = self.successor(node.data)
            self.remove(successor.data)
            node.data = successor.data

    def size(self, node=None):
        if node is None:
            node = self.root
        if node.is_empty():
            return 0
        return 1 + self.size(node.left) + self.size(node.right)

    def pre_order(self, node=None, result=None):
        if result is None:
            result = []
        if node is None:
            node = self.root
        if not node.is_empty():
            result.append(node.data)
            self.pre_order(node.left, result)
            self.pre_order(node.right, result)
        return result

    def in_order(self, node=None, result=None):
        if result is None:
            result = []
        if node is None:
            node = self.root
        if not node.is_empty():
            self.in_order(node.left, result)
            result.append(node.data)
            self.in_order(node.right, result)
        return result

    def post_order(self, node=None, result=None):
        if result is None:
            result = []
        if node is None:
            node = self.root
        if not node.is_empty():
            self.post_order(node.left, result)
            self.post_order(node.right, result)
            result.append(node.data)
        return result

def test_bst():

    bst = BST()
    data = [10, 5, 15, 3, 7, 13, 17, 1, 4, 6]
    for value in data:
        bst.insert(value)

    print("1. In-Order Traversal:", bst.in_order())
    assert bst.in_order() == sorted(data)

    print("2. Pre-Order Traversal:", bst.pre_order())
    assert bst.pre_order() == [10, 5, 3, 1, 4, 7, 6, 15, 13, 17]

    print("3. Post-Order Traversal:", bst.post_order())
    assert bst.post_order() == [1, 4, 3, 6, 7, 5, 13, 17, 15, 10]

    print("4. Height:", bst.height())
    assert bst.height() == 3

    print("5. Size:", bst.size())
    assert bst.size() == 10

    print("6. Search 13:", bst.search(13).data)
    assert bst.search(13).data == 13

    print("7. Minimum:", bst.minimum().data)
    assert bst.minimum().data == 1

    print("8. Maximum:", bst.maximum().data)
    assert bst.maximum().data == 17

    print("9. Successor of 13:", bst.successor(13).data)
    assert bst.successor(13).data == 15

    print("10. Remove 10 (root)")
    bst.remove(10)

    try:
        assert bst.search(10).is_empty()
        print("True")
    except AssertionError as e:
      print(e)

test_bst()
