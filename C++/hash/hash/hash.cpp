#include "hash.h"
#include <stdlib.h>
#include <iostream>

HashTable::HashTable(int capacity){
  this->capacity = capacity;
  this->table = (int *) malloc(capacity * sizeof(int));
  for(int i = 0; i<capacity; i++){
    this->table[i] = -1;
  }
}

HashTable::~HashTable(){
}

int HashTable::probing(int value){
  int collision = 0;
  if(!hasValue(value)){
    int position = hashFunction(value);
    if(this->table[position] == -1){
      return position;
    } else {
      while(this->table[position] != -1 && position<this->capacity){
        position++;
        collision++;
      }
      if(this->table[position] == -1){
        printf("Colisões: %d\n", collision); 
        return position;
      }
      return -1;
    }
  }
  std::cout << "Valor já inserido\n";
  return -1;
}

void HashTable::insert(int value){
  int position = probing(value);

  if (position != -1){
    std::cout << "Valor inserido\n";
    this->table[position] = value;
  }
}

int HashTable::hashFunction(int value){
  return value%this->capacity;
}

bool HashTable::hasValue(int value){
  for(int i = 0; i<this->capacity; i++){
    if(this->table[i] == value)
      return true;
  }
  return false;
}