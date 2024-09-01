"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def order_first(array, left, right):
  
  """
  Posiciona o primeiro elemento de uma sequência de forma a ordená-la. 
  A sequência de entrada está sempre ordenada de forma crescente, 
  exceto pelo primeiro número.
  """
  
  i = left
  while (i < right and array[i + 1] < array[i]):
    aux = array[i]
    array[i] = array[i + 1]
    array[i + 1] = aux
    i += 1

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    order_first(lista, 0, len(lista) - 1)
    print(lista)

main()
