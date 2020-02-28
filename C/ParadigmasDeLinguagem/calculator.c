#include <stdio.h>

typedef struct fraction {
  int num;
  int den;
} fraction;

fraction transform(double num, double den);
fraction sum(fraction a, fraction b);
fraction mult(fraction a, fraction b);
fraction div(fraction a, fraction b);
fraction div(fraction a, fraction b);
void equals(fraction a, fraction b);
void printFraction(fraction fra);

int main(void) {

  fraction fractionOne;
  fraction fractionToo;

  printf("Digite o numerador da fração 1: ");
  scanf("%d", &fractionOne.num);
  printf("Digite o numerador da fração 1: ");
  scanf("%d", &fractionOne.den);

  printf("Digite o numerador da fração 2: ");
  scanf("%d", &fractionToo.num);
  printf("Digite o numerador da fração 2: ");
  scanf("%d", &fractionToo.den);
  
  printf("Soma: ");
  printFraction(sum(fractionOne, fractionToo));
  printf("Multiplicação: ");
  printFraction(mult(fractionOne, fractionToo));
  printf("Divisão: ");
  printFraction(div(fractionOne, fractionToo));
  printf("Igualdade: ");
  equals(fractionOne, fractionToo);

  return 0;
}

fraction transform(double num, double den){
  fraction fra;
  fra.num = num;
  fra.den = den;
  return fra;
}

fraction sum(fraction a, fraction b){
  double num = (a.num*b.den)+(b.num*a.den);
  double den = (a.den*b.den);
  return transform(num, den);
}

fraction mult(fraction a, fraction b){
  double num = a.num*b.num;
  double den = b.den*b.den;
  return transform(num, den);
}

fraction div(fraction a, fraction b){
  double num = a.num*b.den;
  double den = a.den*b.num;
  return transform(num, den);
}

void equals(fraction a, fraction b){
  if((a.num*b.den == a.den*b.num) == 1){
    printf("É igual.");
  }else{
    printf("É diferente.");
  }

}

void printFraction(fraction fra){
  printf("%d/%d\n", fra.num, fra.den);
}