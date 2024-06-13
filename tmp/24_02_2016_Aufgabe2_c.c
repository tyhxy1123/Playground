#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>

int fd1, fd2 = 23;
int main(){
    int pid;

    fd1 = creat("file1", O_RDWR);
    pid = fork();
    fd2 = creat("file2", O_RDWR);
    write(fd1, "A", 1);
    write(fd2, "B", 1);
    printf("fd1: %d, fd2: %d, pid: %d\n", fd1, fd2, pid);
    close(fd1);
    close(fd2);
}