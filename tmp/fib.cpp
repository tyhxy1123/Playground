#include<iostream>
#include<string>
using namespace std;

long fib(long n){
    if(n==0){
        return 0;
    }
    return n == 1 ? n : fib(n-1) + fib(n-2);
}

int main(int argc, char* argv[])
{
    string n = argv[0];
    std::cout << fib(stol(argv[1])) << std::endl;
    return 0;
}
