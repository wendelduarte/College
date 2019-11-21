#include	<iostream>
#include "linkedList.h"
#include "node.h"

LinkedList::LinkedList(){
  head = NULL;
}

LinkedList::~LinkedList(){
  delete head;
}

void LinkedList::insert(int value){
  int collision = 0;
  Node * aux = new Node();
  if(this->head == NULL){
    head = aux;
    head->value = value;
    head->next = NULL;
    printf("\nColisões ao inserir o valor %d: %d", value, collision);
  } else {
    collision+=1;
    aux = this->head;
    Node * last = new Node();
    while(aux->next != NULL){
      aux = aux->next;
      collision++;
    }
    last->value = value;
    last->next = NULL;
    aux->next = last;
    printf("\nColisões ao inserir o valor %d: %d", value, collision);
  }



}
