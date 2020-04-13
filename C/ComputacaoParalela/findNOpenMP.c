#include <stdio.h>
#include <omp.h>

#define ARRAY_LENGTH 65536
#define N 262140

/*
Compilar: gcc-8 findNOpenMP.c -o findNOpenMP -fopenmp
Rodar: ./findNOpenMP
*/

int main() {

	int max, tnum;
	int vetor[ARRAY_LENGTH];

	max = omp_get_max_threads();

	for(int index = 0; index<ARRAY_LENGTH; index++){
		vetor[index] = max*index;
	}

	#pragma omp parallel private(tnum) 
	{

		tnum = omp_get_thread_num();
		int inicio = omp_get_thread_num()*ARRAY_LENGTH/max;
		int fim = inicio + ARRAY_LENGTH/max;

		for(int i = inicio; i < fim; i++){
			if(vetor[i] == N){
				printf("Achei o número %d na posição %d do vetor\n", N, i);
				printf("O número foi encontrado na thread %d\n", tnum);
			}
		}

	}
	return 0;
}