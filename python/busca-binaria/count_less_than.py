"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def count_less(array, num, left, right):

    """
    Dado um array A ordenado de inteiros de tamanho N e um valor x, 
    usar busca binária para encontrar o número de elementos do array que 
    são menores do que x. O tempo de seu algoritmo deve ser O(log n).
    
    Exemplo:
    
    A = [5, 7, 7, 8, 8, 10]
    x = 6
    Saída: 1 (apenas o 5 é menor que 6)
    
    A = [5, 17, 100, 111]
    x = 3
    Saída: 0 (não tem nenhum elemento do array menor que 3)
    """

    result = 0
    mid = (left + right) // 2
    if (left >= 0) and (left <= right) and (right >= 0) and (right < len(array)):
        if (num == array[mid]):
            result = mid - left
            if ((mid - 1 >= left) and (num == array[mid - 1])):
                result = (mid - 1) - left
        elif (num > array[mid]):
            result = (mid - left + 1) + count_less(array, num, mid + 1, right)
        elif (num < array[mid]):
            result = count_less(array, num, left, mid - 1)
    return result

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    num = int(input())
    print(count_less(lista, num, 0, len(lista) - 1))

main()
