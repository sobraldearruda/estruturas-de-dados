"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def quick_sort(array, left, right):
  
  """
  A classe QuickSortMedianOfThree representa uma variação do QuickSort que 
  funciona de forma ligeiramente diferente. Relembre que quando o pivot 
  escolhido divide o array aproximadamente na metade, o QuickSort tem um 
  desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas 
  abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o 
  pivot. Essa técnica consiste no seguinte:

  1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
  2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
  3. Adotar o A[center] como pivot.
  4. Colocar o pivot na penúltima posição A[right-1].
  5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
  6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivot.
  """
  
  if (left < right):
    pivot = partition(array, left, right)
    quick_sort(array, left, pivot - 1)
    quick_sort(array, pivot + 1, right)

def partition(array, left, right):
   
   """ Partition the array according to a pivot element. """

   pivot = pivot_median_of_three(array, left, right)
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

def pivot_median_of_three(array, left, right):
   
   """ Applies the median of three approach for choosing a pivot element. """
   
   mid = (left + right) // 2
   if (array[left] > array[right]):
      swap(array, right, left)
   if (array[left] > array[mid]):
      swap(array, mid, left)
   if (array[mid] > array[right]):
      swap(array, right, mid)
   return mid

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    quick_sort(lista, 0, len(lista) - 1)
    print(lista)

main()
