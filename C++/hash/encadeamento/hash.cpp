#include <stdlib.h>
#include <iostream>
#include "hash.h"
#include "linkedList.h"

HashTable::HashTable(int capacity){
  this->capacity = capacity;
  this->table = (LinkedList **) malloc(capacity * sizeof(LinkedList));
  for(int i = 0; i<capacity; i++){
    this->table[i] = new LinkedList();
  }
}

HashTable::~HashTable(){
}

void HashTable::insert(int value){
  int position = hashFunction(value);
  this->table[position]->insert(value); 
}

int HashTable::hashFunction(int value){
  return value%this->capacity;
}

bool HashTable::hasValue(int value){
 int position = hashFunction(value);

 if(this->table[position]->head == NULL){
   return false;
 } else {
   if(table[position]->head->value == value){
     return true;
   } else {
     Node * aux = table[position]->head;
     while(aux->next != NULL){
      if(aux->value == value){
        return true;
      } else {
        aux = aux->next;
      }
      if(aux->value == value) return true;
     }
   }
 }
 return false;
}