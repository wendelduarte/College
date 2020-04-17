#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

/*
Alterar número de threads: export OMP_NUM_THREADS={numero_threads}
Compilar: gcc-8 sumArrayValuesOption3.c -o sumArrayValuesOption3 -fopenmp
Rodar: time -p ./sumArrayValuesOption3
*/

#define ARRAY_LENGTH 1073741824
#define N 5


int main() {

    int *array = malloc(sizeof(int)*ARRAY_LENGTH);

    int max, tnum = 0;
    long result = 0;
    
    max = omp_get_max_threads();
    printf("Num threads: %d\n", max);
     
    for(int i = 0; i<ARRAY_LENGTH; i++){
        array[i] = N;
    }

    #pragma omp parallel for reduction(+:result)
    
        for(int i = 0; i<ARRAY_LENGTH; i++) {
                result += (long) array[i];
        }
    
    printf("A soma dos valores do vetor é: %ld\n", result);
    free(array);
    return 0;
}