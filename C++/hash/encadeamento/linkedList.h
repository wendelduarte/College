#ifndef LINKEDLIST_H
#define LINKEDLIST_H
#include "node.h"

class LinkedList{
  public:
    Node *head;
    LinkedList();
    ~LinkedList();
    void insert(int value);

};

#endif