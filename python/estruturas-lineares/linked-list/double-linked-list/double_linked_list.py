"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

class DoubleLinkedListNode:

    def __init__(self, data=None, next_node=None, previous_node=None):
        self.data = data
        self.next = next_node
        self.previous = previous_node

    def is_nil(self):
        return self.data is None

    def set_data(self, data):
        self.data = data

    def get_data(self):
        return self.data

    def set_next(self, next_node):
        self.next = next_node

    def get_next(self):
        return self.next

    def set_previous(self, previous_node):
        self.previous = previous_node

    def get_previous(self):
        return self.previous

class DoubleLinkedList:

    def __init__(self):
        self.last = DoubleLinkedListNode()
        self.head = self.last

    def is_empty(self):
        return self.head.is_nil()

    def insert(self, element):
        if element is not None:
            new_node = DoubleLinkedListNode(data=element, previous_node=self.last)
            self.last.set_next(new_node)
            if self.is_empty():
                self.head = new_node
            self.last = new_node
            nil = DoubleLinkedListNode()
            self.last.set_next(nil)
            nil.set_previous(self.last)

    def insert_first(self, element):
        if element is not None:
            new_node = DoubleLinkedListNode(data=element, next_node=self.head)
            if isinstance(self.head, DoubleLinkedListNode):
                self.head.set_previous(new_node)
            if self.is_empty():
                self.last = new_node
            self.head = new_node
            nil = DoubleLinkedListNode()
            self.head.set_previous(nil)
            nil.set_next(self.head)

    def remove(self, element):
        if element is not None and not self.is_empty():
            if self.head.get_data() == element:
                self.remove_first()
            else:
                current_node = self.head
                while not current_node.is_nil():
                    if current_node.get_data() == element:
                        previous_node = current_node.get_previous()
                        next_node = current_node.get_next()
                        previous_node.set_next(next_node)
                        if isinstance(next_node, DoubleLinkedListNode):
                            next_node.set_previous(previous_node)
                        if next_node.is_nil():
                            self.last = previous_node
                        break
                    current_node = current_node.get_next()

    def remove_first(self):
        if not self.is_empty():
            self.head = self.head.get_next()
            if isinstance(self.head, DoubleLinkedListNode):
                self.head.set_previous(None)
            if self.head.is_nil():
                self.last = DoubleLinkedListNode()
                self.head = self.last

    def remove_last(self):
        if not self.is_empty():
            aux_node = self.last
            self.last = aux_node.get_previous()
            if isinstance(self.last, DoubleLinkedListNode):
                self.last.set_next(aux_node.get_next())
            if self.last is None:
                self.last = DoubleLinkedListNode()
                self.head = self.last

    def to_array(self):
        size = self.size()
        array = [None] * size
        current = self.head
        for i in range(size):
            array[i] = current.get_data()
            current = current.get_next()
        return array

    def get_head(self):
        return self.head

    def set_head(self, head):
        self.head = head

    def get_last(self):
        return self.last

    def set_last(self, last):
        self.last = last

    def size(self):
        size = 0
        current_node = self.head
        while not current_node.is_nil():
            size += 1
            current_node = current_node.get_next()
        return size

    def search(self, element):
        if element is None or self.is_empty():
            return None
        current = self.head
        while not current.is_nil():
            if current.get_data() == element:
                return element
            current = current.get_next()
        return None

class TestDoubleLinkedList:

    def __init__(self):
        self.double_list = DoubleLinkedList()

    def run_tests(self):

        # Test 1: Check if a new list is empty
        if self.double_list.is_empty():
            print("Test 1 Passed: The list is empty.")
        else:
            print("Test 1 Failed: The list is not empty.")

        # Test 2: Check the size of the list after inserting an element
        self.double_list.insert(10)
        if self.double_list.size() == 1:
            print("Test 2 Passed: The list size is correct after one insertion.")
        else:
            print("Test 2 Failed: The list size is incorrect after one insertion.")

        # Test 3: Search for the element in the list
        if self.double_list.search(10) == 10:
            print("Test 3 Passed: The element 10 was found in the list.")
        else:
            print("Test 3 Failed: The element 10 was not found in the list.")

        # Test 4: Insert element at the beginning and verify the list structure
        self.double_list.insert_first(5)
        if self.double_list.size() == 2:
            print("Test 4 Passed: The list size is correct after inserting at the beginning.")
        else:
            print("Test 4 Failed: The list size is incorrect after inserting at the beginning.")

        # Test 5: Insert another element at the end and verify the last element
        self.double_list.insert(20)
        if self.double_list.get_last().get_data() == 20:
            print("Test 5 Passed: The last element is correctly updated after inserting at the end.")
        else:
            print("Test 5 Failed: The last element is not correctly updated after inserting at the end.")

        # Test 6: Convert list to array and verify elements
        if self.double_list.to_array() == [5, 10, 20]:
            print("Test 6 Passed: The array representation of the list is correct.")
        else:
            print("Test 6 Failed: The array representation of the list is incorrect.")

        # Test 7: Remove an element from the list
        self.double_list.remove(10)
        if self.double_list.size() == 2:
            print("Test 7 Passed: The list size is correct after removing an element.")
        else:
            print("Test 7 Failed: The list size is incorrect after removing an element.")

        # Test 8: Remove the first element
        self.double_list.remove_first()
        if self.double_list.size() == 1:
            print("Test 8 Passed: The list size is correct after removing the first element.")
        else:
            print("Test 8 Failed: The list size is incorrect after removing the first element.")

        # Test 9: Remove the last element
        self.double_list.remove_last()
        if self.double_list.is_empty():
            print("Test 9 Passed: The list is empty after removing the last element.")
        else:
            print("Test 9 Failed: The list is not empty after removing the last element.")

        print("All tests completed.")

# Run the tests
test = TestDoubleLinkedList()
test.run_tests()
