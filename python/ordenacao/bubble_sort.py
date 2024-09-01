"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def bubble_sort(array):
  
  """
  The BubbleSort algorithm iterates over the array multiple times, pushing big 
  elements to the right by swapping adjacent elements until the array is sorted.
  """
  
  swapped = True
  while (swapped):
    swapped = False
    for i in range(0, len(array) - 1):
       if (array[i] > array[i + 1]):
         aux = array[i]
         array[i] = array[i + 1]
         array[i + 1] = aux
         swapped = True

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    bubble_sort(lista)
    print(lista)

main()
