#include <stdio.h>
#include<stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
int main(void){
  const char* path = "/Users/xiangyu/Projects/Playground/CPP/test.txt";
  const char* path2 = "/Users/xiangyu/Projects/Playground/CPP/test2.txt";
  const int initReadCount = 1000;
  int file = open(path, O_RDONLY);
  printf("file is opened: %d\n", file);
  void *buf = malloc(100*sizeof(char));
  int readCount = read(file, buf, initReadCount);
  printf("readCount is: %d\n", readCount);
  int fileToWrite = open(path2,O_RDWR);
  write(fileToWrite, buf, readCount);
  printf("buf: %s\n",buf);
  close(file);
  close(fileToWrite);
}
