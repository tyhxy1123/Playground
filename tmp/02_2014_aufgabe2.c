#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
int main(){
    int fd1 = open("datei1.txt", O_RDWR | O_APPEND);
    int fd2 = open("datei2.txt", O_RDWR | O_APPEND);

    int pid1 = fork();

    if(pid1 == 0)
    {
        write(fd1, "\nabc", 4);
        exit(0);
    }
    else
    {
        int pid2 = fork();
        if(pid2 == 0)
        {
            write(fd2, "\nabc", 4);
            exit(0);
        }

        waitpid(pid1, NULL, 0);
        write(fd1, "\ndef", 4);
        write(fd2, "def", 3);
    }








    return 0;
}