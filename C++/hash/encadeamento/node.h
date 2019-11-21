#ifndef NODE_H
#define NODE_H

class Node{
  public:
    int value;
    Node *next;
  
  friend class LinkedList;
};

#endif