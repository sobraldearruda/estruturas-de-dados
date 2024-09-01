"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

class QueueOverflowException(Exception):
  def __init__(self):
    super().__init__("A fila está cheia")

class QueueUnderflowException(Exception):
  def __init__(self):
    super().__init__("A fila está vazia")

class Queue:
  
  def __init__(self, size):
    self.array = [None] * size
    self.tail = -1

  def head(self):
    if not self.isEmpty():
      return self.array[0]
    return None

  def isEmpty(self):
    return self.tail == -1

  def isFull(self):
    return self.tail == len(self.array) - 1

  def shiftLeft(self):
    for i in range(self.tail):
      self.array[i] = self.array[i + 1]
    self.tail -= 1

  def enqueue(self, element):
    if self.isFull():
      raise QueueOverflowException()
    if element is not None:
      self.tail += 1
      self.array[self.tail] = element

  def dequeue(self):
    if self.isEmpty():
      raise QueueUnderflowException()
    element = self.array[0]
    self.shiftLeft()
    return element

class Test:
  
  queue = Queue(3)

  queue.enqueue(1) # Inserção: 1
  queue.enqueue(2) # Inserção: 2
  queue.enqueue(3) # Inserção: 3

  try: # Tentativa de inserção na fila cheia
      queue.enqueue(4)
  except QueueOverflowException as e:
      print(e)
  
  print(queue.dequeue()) # Remoção: 1
  print(queue.head())    # Head da fila: 2
  
  queue.dequeue() # Remoção: 2
  queue.dequeue() # Remoção: 3

  try: # Tentativa de remoção na fila vazia
      queue.dequeue()
  except QueueUnderflowException as e:
      print(e)
  
  print(queue.isEmpty()) # True
  print(queue.isFull())  # False
