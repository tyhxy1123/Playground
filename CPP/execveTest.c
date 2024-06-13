#include<stdio.h>
int main(int argc, char* argv[]){
    printf("Begin the original process...\n");
    int pFlag = fork();
    if(pFlag > 0){
        printf("Waiting for child to execute\n");
        waitpid(pFlag);
    }
    if(pFlag == 0){
        char *argv[] = {"toRead", NULL};
        char *envp[] = {NULL};
        printf("Child Process excecuting...\n");
        int exeFlag = execve("/Users/xiangyu/Projects/Playground/CPP/toRead", argv, envp);
        if(exeFlag < 0){
            printf("execve() failed to run...\n");
        }
    }
}
