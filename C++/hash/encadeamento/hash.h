#ifndef HASH_H
#define HASH_H
#include "node.h"
#include "linkedList.h"

class HashTable {
  
  private:
    

  public:
    LinkedList **table;
    int capacity;
    HashTable(int capacity);
    ~HashTable();
    int probing(int position);
    void insert(int value);
    int hashFunction(int value);
    bool hasValue(int value);
};

#endif