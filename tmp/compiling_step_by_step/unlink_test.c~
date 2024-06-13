#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>

int main() {
    int fd = creat("/tmp/test", S_IRWXU);
    unlink("/tmp/test");
    int byte_cnt = write(fd, "Hello world\n", 12);
    close(fd);
    printf("Wrote %i bytes\n", byte_cnt);
    return 0;
}

