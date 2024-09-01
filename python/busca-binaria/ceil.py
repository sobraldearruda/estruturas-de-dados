"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def ceil(array, num, left, right):

    """
    Ceil é o elemento do array igual a x, ou maior e mais próximo possível 
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
            result = array[mid]
            if ((mid - 1 >= left) and (num <= array[mid - 1])):
                result = ceil(array, num, left, mid - 1)
        elif (num > array[mid]):
            result = ceil(array, num, mid + 1, right)
    return result

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    num = int(input())
    print(ceil(lista, num, 0, len(lista) - 1))

main()
