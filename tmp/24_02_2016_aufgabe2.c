#include <stdio.h>
#include <fcntl.h>

int main()
{

    int pid;
    pid = fork();
    // int fd2 = open("file2", O_RDWR | O_CREAT);
    int fd2 = creat("file2", S_IWUSR);
    write(fd2, "B", 1);
    printf("fd2: %d, pid: %d\n", fd2, pid);
    close(fd2);
    return 0;
}