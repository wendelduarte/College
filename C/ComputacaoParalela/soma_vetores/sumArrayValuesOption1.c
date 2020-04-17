#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

/*
Alterar número de threads: export OMP_NUM_THREADS={numero_threads}
Compilar: gcc-8 sumArrayValuesOption1.c -o sumArrayValuesOption1 -fopenmp
Rodar: time -p ./sumArrayValuesOption1
*/

#define ARRAY_LENGTH 1073741824   
#define N 5

int main() {

    int *array = malloc(sizeof(int)*ARRAY_LENGTH);
    int max, tnum = 0;
    long result = 0;

    max = omp_get_max_threads();
    printf("Num threads: %d\n", max);
    
    int sumArray[max];

 /*Para duas threads:   
    long int *sumArray = malloc(sizeof(int)*max);
*/
    for(int i = 0; i<ARRAY_LENGTH; i++){
        array[i] = N;
    }
    for(int i = 0; i<max; i++){
        sumArray[i] = 0;
    }

    #pragma omp parallel private(tnum)
    {
        tnum = omp_get_thread_num();
        #pragma omp for
            for(int i = 0; i<ARRAY_LENGTH; i++) {
                /*Para duas threads:
                sumArray[tnum] += (long) array[i];
                */
                sumArray[tnum] += array[i];
            }
    }

    for(int i = 0; i<max; i++){
        result += (long) sumArray[i];
    } 

    printf("A soma dos valores do vetor é: %ld\n", result);
    free(array);
    return 0;
}