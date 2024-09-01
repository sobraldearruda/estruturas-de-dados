"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def floor_first_index(array, num, left, right):

    """
    Usa a busca binária para encontrar o primeiro índice de um número.
    A sequência está ordenada e contém números possivelmente repetidos.
    """
    
    result = -1
    mid = (left + right) // 2
    if (left <= right):
        if ((num == array[mid]) and (mid == 0 or num > array[mid - 1])):
            result = mid
        elif (num <= array[mid]):
            result = floor_first_index(array, num, left, mid - 1)
        else:
            result = floor_first_index(array, num, mid + 1, right)
    return result

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    num = int(input())
    print(floor_first_index(lista, num, 0, len(lista) - 1))

main()
