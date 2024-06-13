#include <stdio.h>
#include <stdlib.h>

int main() {
    int i, pid = fork();
    if (pid < 0) {
        printf("Error during fork\n");
        exit(1);
    }

    if (pid) {
        for (i = 0; i < 4; i++) {
            puts("parent");
        }
    } else {
        for (i = 0; i < 4; i++) {
            puts("child");
        }
    }
    return 0;
}
