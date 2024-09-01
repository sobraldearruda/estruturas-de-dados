"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

class SingleLinkedListNode:

    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next = next_node

    def get_data(self):
        return self.data

    def get_next(self):
        return self.next

    def is_nil(self):
        return self.data is None

    def set_data(self, data):
        self.data = data

    def set_next(self, next_node):
        self.next = next_node

class SingleLinkedList:

    def __init__(self):
        self.head = SingleLinkedListNode()

    def is_empty(self):
        return self.head.is_nil()

    def size(self):
        size = 0
        current = self.head
        while not current.is_nil():
            size += 1
            current = current.get_next()
        return size

    def search(self, element):
        if element is None:
            return None
        current = self.head
        while not current.is_nil():
            if current.get_data() == element:
                return element
            current = current.get_next()
        return None

    def insert(self, element):
        if element is None:
            return
        current = self.head
        while not current.is_nil():
            current = current.get_next()
        current.set_data(element)
        current.set_next(SingleLinkedListNode())

    def remove(self, element):
        if element is None or self.is_empty():
            return
        previous = self.head
        current = previous.get_next()
        if previous.get_data() == element:
            self.head = current
        else:
            while not current.is_nil():
                if current.get_data() == element:
                    previous.set_next(current.get_next())
                    break
                previous = current
                current = current.get_next()

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

class Test:

    def __init__(self):
        self.single_list = SingleLinkedList()

    def run_tests(self):

        # Test is_empty() on an empty list
        if self.single_list.is_empty():
            print("Test 1 Passed: The list is empty.")
        else:
            print("Test 1 Failed: The list is not empty.")

        # Test insert(), size(), and search() methods
        self.single_list.insert(10)
        if not self.single_list.is_empty():
            print("Test 2 Passed: The list is not empty after inserting an element.")
        else:
            print("Test 2 Failed: The list is still empty after inserting an element.")

        if self.single_list.size() == 1:
            print("Test 3 Passed: The list size is correct after one insertion.")
        else:
            print("Test 3 Failed: The list size is incorrect after one insertion.")

        if self.single_list.search(10) == 10:
            print("Test 4 Passed: The element 10 was found in the list.")
        else:
            print("Test 4 Failed: The element 10 was not found in the list.")

        # Test to_array() method
        if self.single_list.to_array() == [10, 20, 30]:
            print("Test 5 Passed: The array representation of the list is correct.")
        else:
            print("Test 5 Failed: The array representation of the list is incorrect.")

        # Test removing head element
        self.single_list.remove(10)
        if self.single_list.size() == 2:
            print("Test 6 Passed: The list size is correct after removing the head element.")
        else:
            print("Test 6 Failed: The list size is incorrect after removing the head element.")

        if self.single_list.search(10) is None:
            print("Test 7 Passed: The head element was correctly removed.")
        else:
            print("Test 7 Failed: The head element was not correctly removed.")

        if self.single_list.to_array() == [30]:
            print("Test 8 Passed: The array representation is correct after removing the head element.")
        else:
            print("Test 8 Failed: The array representation is incorrect after removing the head element.")

        print("All tests completed.")

test = Test()
test.run_tests()
