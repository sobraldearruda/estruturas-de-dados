"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def elementos_duplicados(array):
  
  """ Verifica se uma sequência de inteiros possui elementos duplicados. """
  
  duplicate = False
  for i in range(0, len(array) - 1):
     if (array[i] == array[i + 1]):
        duplicate = True
  print(duplicate)

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().replace(" ", "")
    lista = []
    for e in entrada:
        lista.append(int(e))
    elementos_duplicados(lista)

main()
