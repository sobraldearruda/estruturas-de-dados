"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def floor(array, num, left, right):

    """
    Floor é o elemento do array igual a x, ou menor e mais próximo possível 
    de x (caso x não pertença ao array). O algoritmo deve ter tempo O(n.log n) 
    e deve ser in-place, usando recursão. Você pode assumir que o array não 
    tem elementos repetidos.
    """

    result = -1
    mid = (left + right) // 2
    if (left <= right):
        if (num == array[mid]):
            result = array[mid]
        elif (num < array[mid]):
            result = floor(array, num, left, mid - 1)
        elif (num > array[mid]):
            result = array[mid]
            if ((mid + 1 <= right) and (num >= array[mid + 1])):
                result = floor(array, num, mid + 1, right)
    return result

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    num = int(input())
    print(floor(lista, num, 0, len(lista) - 1))

main()
