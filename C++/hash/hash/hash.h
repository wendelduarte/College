#ifndef HASH_H
#define HASH_H

class HashTable {
  
  private:
    int *table;
    int capacity;

  public:
    HashTable(int capacity);
    ~HashTable();
    int probing(int position);
    void insert(int value);
    int hashFunction(int value);
    bool hasValue(int value);
};

#endif