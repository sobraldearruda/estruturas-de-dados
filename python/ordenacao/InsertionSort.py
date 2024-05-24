"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def insertion_sort(array):
  
  """
  The InsertionSort algorithm iterates over the array and assumes that the visited 
  positions are already sorted in ascending order, meaning it only needs to find the 
  right position for the current element and insert it there.
  """
  
  for i in range(0, len(array)):
       key = array[i]
       aux = i - 1
       while (aux >= 0 and array[aux] > key):
          array[aux + 1] = array[aux]
          aux -= 1
       array[aux + 1] = key

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    insertion_sort(lista)
    print(lista)

main()
