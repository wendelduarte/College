/*
Programa retirado de: http://www.csl.mtu.edu/cs4411.ck/www/NOTES/process/shm/example-1.html
Exercício:
Modifique o código-fonte para garantir que:
	1. O processo pai e o processo filho compartilhem uma variável simples (por exemplo, inteiro - valor 1)
	2. O processo pai imprime o valor inicial dessa variável; em seguida, cria o processo filho e espera-o
	3. O processo filho acessa esta variável, realiza uma operação (por exemplo, adição - valor 2, totalizando 3), modificando o valor; em seguida, o processo filho termina
	4. O processo pai realiza uma outra operação (por exemplo, multiplicação - valor 4, totalizando 12), modificando novamente o valor, e imprime novamente a variável.
*/
#include  <stdio.h>
#include  <stdlib.h>
#include  <stdint.h>
#include  <unistd.h>
#include  <sys/types.h>
#include  <sys/ipc.h>
#include  <sys/shm.h>
#include  <sys/wait.h>

void  ClientProcess(int []);

void  main(int  argc, char *argv[])
{
     int    ShmID;
     int    *ShmPTR;
     pid_t  pid;
     int    status;

     if (argc != 5) {
          printf("Use: %s #1 #2 #3 #4\n", argv[0]);
          exit(1);
     }

     ShmID = shmget(IPC_PRIVATE, 4*sizeof(int), IPC_CREAT | 0666);
     if (ShmID < 0) {
          printf("*** shmget error (server) ***\n");
          exit(1);
     }

     ShmPTR = (int *) shmat(ShmID, NULL, 0);
     if ((int) ShmPTR == -1) {
          printf("*** shmat error (server) ***\n");
          exit(1);
     }

     ShmPTR[0] = atoi(argv[1]);
     ShmPTR[1] = atoi(argv[2]);
     ShmPTR[2] = atoi(argv[3]);
     ShmPTR[3] = atoi(argv[4]);
     printf("Values in parent before calc: %d %d %d %d \n",
            ShmPTR[0], ShmPTR[1], ShmPTR[2], ShmPTR[3]);

     pid = fork();
     if (pid < 0) {
          printf("*** fork error (server) ***\n");
          exit(1);
     }
     else if (pid == 0) {
          ClientProcess(ShmPTR);
          exit(0);
     }

     wait(&status);

     ShmPTR[0] = ShmPTR[0]*4;
     ShmPTR[1] = ShmPTR[1]*4;
     ShmPTR[2] = ShmPTR[2]*4;
     ShmPTR[3] = ShmPTR[3]*4;

     printf("Values in parent after calc: %d %d %d %d \n",
            ShmPTR[0], ShmPTR[1], ShmPTR[2], ShmPTR[3]);

     shmdt((void *) ShmPTR);
     shmctl(ShmID, IPC_RMID, NULL);
     exit(0);
}

void  ClientProcess(int  SharedMem[])
{
     printf("   Values in child before calc: %d %d %d %d \n",
                SharedMem[0], SharedMem[1], SharedMem[2], SharedMem[3]);
     
     SharedMem[0]++;
     SharedMem[1]++;
     SharedMem[2]++;
     SharedMem[3]++;

     printf("   Values in child after calc: %d %d %d %d \n",
           SharedMem[0], SharedMem[1], SharedMem[2], SharedMem[3]);
}
