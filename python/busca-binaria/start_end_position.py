"""
Estruturas de Dados e Algoritmos
__author__ Rafael de Arruda Sobral
"""

def start_end_position(array, num, left, right):

    """
    Dado um array A ordenado de inteiros de tamanho N e um valor x, 
    possivelmente com mais de uma ocorrência, usar busca binária para encontrar 
    as posições da primeira e última ocorrências de x em A.
    
    Restrições:
    - Seu algoritmo NÃO pode usar memória extra
      (a não ser variáveis simples locais e não de coleção/estrutura)
    - O tempo de seu algoritmo deve ser O(log n)
    - Retornar um array com dois elementos [primeiraPosicao, ultimaPosicao], 
      onde primeiraPosicao tem o valor do índice da primeira ocorrência de x em A, 
      e ultimaPosicao tem o valor do indice da última ocorrência de x em A
    - Note que se x não está em A então o retorno deve ser [-1, -1]
    """
    
    start = start_position(array, num, left, right)
    end = end_position(array, num, left, right)
    return [start, end]

def start_position(array, num, left, right):

    """ Encontra o primeiro índice de um número. """
    
    result = -1
    mid = (left + right) // 2
    if (left <= right):
        if ((num == array[mid]) and (mid == 0 or num > array[mid - 1])):
            result = mid
        elif (num <= array[mid]):
            result = start_position(array, num, left, mid - 1)
        else:
            result = start_position(array, num, mid + 1, right)
    return result

def end_position(array, num, left, right):

    """ Encontra o último índice de um número. """
    
    result = -1
    mid = (left + right) // 2
    if (left <= right):
        if ((num == array[mid]) and (mid == right or num < array[mid + 1])):
            result = mid
        elif (num < array[mid]):
            result = end_position(array, num, left, mid - 1)
        else:
            result = end_position(array, num, mid + 1, right)
    return result

def main():

    """ Simula a entrada e a saída de dados. """

    entrada = input().split()
    lista = [int(e) for e in entrada]
    num = int(input())
    print(start_end_position(lista, num, 0, len(lista) - 1))

main()
