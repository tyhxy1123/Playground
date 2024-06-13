#include<stdio.h> 
#include<fcntl.h> 
#include<errno.h>
void main(){
    int fd1, fd2, pid1, pid2;
    create("foo.txt");
    pid1 = fork();
    if(pid1 == 0){
        fd2 = create("bar.txt");
        write(fd1, "Lorem", 5);
        pid2 = fork();
        if(pid2 == 0){
            write(fd2, "Ipsum", 5);
            wait();
        }
        exit(0);
    }

    printf("X");
    wait();
    exit(0);
}
