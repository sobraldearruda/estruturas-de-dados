"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

class StackOverflowException(Exception):
  def __init__(self):
    super().__init__("A pilha está cheia")

class StackUnderflowException(Exception):
  def __init__(self):
    super().__init__("A pilha está vazia")

class Stack:

  def __init__(self, size):
    self.array = [None] * size
    self.top = -1

  def top_element(self):
    if not self.isEmpty():
      return self.array[self.top]
    return None

  def isEmpty(self):
    return self.top == -1

  def isFull(self):
    return self.top == len(self.array) - 1

  def push(self, element):
    if self.isFull():
      raise StackOverflowException()
    if element is not None:
      self.top += 1
      self.array[self.top] = element

  def pop(self):
    if self.isEmpty():
      raise StackUnderflowException()
    element = self.array[self.top]
    self.top -= 1
    return element

class Test:

  stack = Stack(3)

  stack.push(1) # Inserção: 1
  stack.push(2) # Inserção: 2
  stack.push(3) # Inserção: 3

  try: # Tentativa de empilhar na pilha cheia
    stack.push(4)
  except StackOverflowException as e:
    print(e)

  print(stack.pop()) # Remoção: 3
  print(stack.top_element()) # Topo da pilha: 2

  stack.pop() # Remoção: 2
  stack.pop() # Remoção: 1

  try: # Tentativa de desempilhar da pilha vazia
    stack.pop()
  except StackUnderflowException as e:
    print(e)

  print(stack.isEmpty()) # True
  print(stack.isFull())  # False
