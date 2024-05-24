"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def quick_sort(array, left, right):
  
  """
  The QuickSort algorithm chooses a pivot element and rearranges the elements 
  of the interval in such a way that all elements lesser than the pivot go to 
  the left part of the array, and all elements greater than the pivot go to 
  the right one. Then, it recursively sorts the left and the right parts.
  """
  
  if (left < right):
    pivot = partition(array, left, right)
    quick_sort(array, left, pivot - 1)
    quick_sort(array, pivot + 1, right)

def partition(array, left, right):
   
   """ Partition the array according to a pivot element. """

   pivot = array[left]
   i = left
   for j in range(left + 1, right + 1):
      if (array[j] <= pivot):
         i += 1
         swap(array, i, j)
   swap(array, left, i)
   return i

def swap(array, i, j):
   
   """ Swaps the elements. """

   aux = array[i]
   array[i] = array[j]
   array[j] = aux

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    quick_sort(lista, 0, len(lista) - 1)
    print(lista)

main()
