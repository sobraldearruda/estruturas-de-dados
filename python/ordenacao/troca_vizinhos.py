"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def troca_vizinhos(array):
  
  """
  Troca os elementos vizinhos.
  Se o tamanho da sequência for ímpar, troca os vizinhos e mantém o último elemento 
  em sua posição. O algoritmo deve ser in-place.
  """

  aux = array[0]
  for i in range(0, len(array)):
     if ((i % 2 == 0) and (i + 1 < len(array))):
        aux = array[i]
        array[i] = array[i + 1]
     elif (i % 2 != 0):
        array[i] = aux
     else:
        break

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    troca_vizinhos(lista)
    print(lista)

main()
