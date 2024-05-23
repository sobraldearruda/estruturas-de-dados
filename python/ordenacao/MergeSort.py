"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def merge_sort(array, left, right):
  
  """
  The MergeSort algorithm consists of recursively dividing the unsorted list 
  in the middle, sorting each sublist, and then merging them into one single sorted list.
  """
  
  if (left < right):
    mid = (left + right) // 2
    merge_sort(array, left, mid)
    merge_sort(array, mid + 1, right)
    merge(array, left, mid, right)

def merge(array, left, mid, right):
   
   """ Merge two sorted lists. """

   aux = [0] * len(array)
   for n in range(0, len(array)):
      aux[n] = array[n]
   i = left
   j = mid + 1
   k = left
   while (i <= mid and j <= right):
      if (array[i] <= array[j]):
         array[k] = aux[i]
         i += 1
      else:
         array[k] = aux[j]
         j += 1
      k += 1
   while (i <= mid):
      array[k] = aux[i]
      i += 1
      k += 1

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().replace(" ", "")
    lista = []
    for e in entrada:
        lista.append(int(e))
    merge_sort(lista, 0, len(lista) - 1)
    print(lista)

main()
