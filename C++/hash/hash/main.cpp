/*
Exercicio:
Implemente uma classe para tabelas hash. A classe deve criar uma tabela de tamanho m e utilizar uma função hash baseada em divisão. Defina uma quantidade de dados a ser inserida na tabela e crie métodos para inserir e buscar os elementos na tabela. A função de busca deve retornar VERDADE se o elemento estiver na tabela ou FALSO caso contrário. Crie um programa main que insere valores na tabela e mostre quantas colisões ocorrem no processo de inserção.
*/

#include <iostream>
#include "hash.h"

int main() {

  HashTable*hash = new HashTable(11);

  hash->insert(111);
  hash->insert(111);
  hash->insert(111);
  hash->insert(123);
  hash->insert(321);
  hash->insert(132);
  hash->insert(107);
  hash->insert(106);
  hash->insert(222);
  hash->insert(3948);
  hash->insert(3948);
  hash->insert(222);
  hash->hasValue(111);
  std::cout <<  "\n";
  std::cout << hash->hasValue(112);

}
