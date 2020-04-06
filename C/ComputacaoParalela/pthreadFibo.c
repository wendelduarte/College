#include<stdio.h>
#include<string.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>

/*
Result: 832040 

real	0m0,004s
user	0m0,001s
sys	0m0,003s
*/

//Função dinâmica retirado de: https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
void *fib(void *n) { 
  int *e = (int*)n;
  int f[*e+2]; 
  int i; 
  
  f[0] = 0; 
  f[1] = 1; 
  
  for (i = 2; i <= *e; i++) { 
      f[i] = f[i-1] + f[i-2]; 
  } 
  
  *e = f[*e];
}

int main(void) {

	int value = 30;
	int value1 = value;

	int *ptr1 = &value;
	*ptr1 = *ptr1-1;
	int *ptr2 = &value1;
	*ptr2 = *ptr2-2;

	pthread_t t1;
	pthread_create(&t1, NULL, fib, (void *)ptr1);

	pthread_t t2;
	pthread_create(&t2, NULL, fib, (void *)ptr2);	

	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	printf("Result: %d \n", *ptr1 + *ptr2);


	return 0;
}