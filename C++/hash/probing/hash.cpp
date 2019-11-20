#include "hash.h"
#include <stdlib.h>

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
  int position = hashFunction(value);

  if(this->table[position] == -1){
    return position;
  } else {
    while(this->table[position] != -1 && position<this->capacity){
      position++;
    }
    if(this->table[position] == -1){
      return position;
    }
    return -1;
  }
}

bool HashTable::insert(int value){
  int position = probing(value);

  if (position == -1)
    return false;
  
  this->table[position] = value;
  return true;
}

int HashTable::hashFunction(int value){
  return value%this->capacity;
}