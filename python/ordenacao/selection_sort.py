"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def selection_sort(array):
  
  """
  The SelectionSort algorithm chooses the smallest element from the array and 
  puts it in the first position. Then, it chooses the second smallest element and 
  stores it in the second position, and so on until the array is sorted.
  """

  for i in range(0, len(array)):
    menor = i
    for j in range(i + 1, len(array)):
      if array[j] < array[menor]:
        menor = j
    aux = array[i]
    array[i] = array[menor]
    array[menor] = aux

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    selection_sort(lista)
    print(lista)

main()
