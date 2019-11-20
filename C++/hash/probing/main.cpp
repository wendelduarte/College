/*
Exercício:
Utilizando o conceito de Probing Linear, implemente uma classe para tabelas hash. A classe deve criar uma
tabela de tamanho m e utilizar uma função hash baseada em divisão. Defina uma quantidade de dados a ser 
inserida na tabela e crie métodos para inserir e buscar os elementos na tabela. A função de busca deve retornar
VERDADE se o elemento estiver na tabela ou FALSO caso contrário. Crie um programa main que insere valores na
tabela e mostre quantas colisões ocorrem no processo de inserção.
*/
#include <iostream>
#include "hash.h"

int main() {

  HashTable*hash = new HashTable(11);

  std::cout << hash->insert(111);
  std::cout << hash->insert(123);
  std::cout << hash->insert(321);
  std::cout << hash->insert(132);
  std::cout << hash->insert(107);
  std::cout << hash->insert(106);
  std::cout << hash->insert(222);
  std::cout << hash->insert(3948);
  std::cout << hash->insert(3948);
  std::cout << hash->insert(222);
}
