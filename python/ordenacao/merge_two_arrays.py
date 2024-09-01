"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def merge(array1, array2):
   
   """ Merge two sorted lists. """

   aux = [0] * (len(array1) + len(array2))
   i = j = k = 0
   while (i < len(array1) and j < len(array2)):
      if (array1[i] <= array2[j]):
         aux[k] = array1[i]
         i += 1
      else:
         aux[k] = array2[j]
         j += 1
      k += 1
   while (i < len(array1)):
      aux[k] = array1[i]
      i += 1
      k += 1
   while (j < len(array2)):
      aux[k] = array2[j]
      j += 1
      k += 1
   print(aux)

def main():

    """ Simula a entrada e a saída de dados. """

    entrada1 = input().split()
    lista1 = [int(e) for e in entrada1]
    entrada2 = input().split()
    lista2 = [int(e) for e in entrada2]
    merge(lista1, lista2)

main()
