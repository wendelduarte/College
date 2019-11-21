/*
Exercicio 10:
Utilizando o conceito de Encadeamento, implemente uma classe para tabelas hash. A classe deve criar uma tabela de tamanho m e utilizar uma função hash baseada em divisão. Defina uma quantidade de dados a ser inserida na tabela e crie métodos para inserir e buscar os elementos na tabela. A função de busca deve retornar VERDADE se o elemento estiver na tabela ou FALSO caso contrário. Crie um programa main que insere valores na tabela e mostre quantas colisões ocorrem no processo de inserção.
*/

#include <iostream>
#include "hash.h"
#include "linkedList.h"

int main() {

  HashTable*hash = new HashTable(11);
  hash->insert(111);
  hash->insert(1);
  hash->insert(23);
  hash->insert(34);
  hash->insert(45);
  hash->insert(6);
  hash->insert(8);
  hash->insert(4);
  hash->insert(100);


}