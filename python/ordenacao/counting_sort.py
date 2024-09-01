"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def counting_sort(array):
  
  """
  The CountingSort algorithm records the frequency of elements and sorts them 
  according to the index. It demands a O(n + k) complexity, even though using extra memory.
  """
  
  greater = array[0]
  for i in range(1, len(array)):
     if (array[i] > greater):
        greater = array[i]
  count = [0] * (greater + 1)
  for i in range(0, len(array)):
     count[array[i]] += 1
  for i in range(1, len(count)):
     count[i] += count[i - 1]
  aux = [0] * (len(array))
  for i in range(len(array) - 1, -1, -1):
     aux[count[array[i]] - 1] = array[i]
     count[array[i]] -= 1
  for i in range(0, len(array)):
     array[i] = aux[i]

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    counting_sort(lista)
    print(lista)

main()
