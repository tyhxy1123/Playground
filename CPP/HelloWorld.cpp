#include <iostream> 
using namespace std; 
int fibonacci(int a){ 
  if(a == 0){ return a; } 
  if(a == 1){ return a; } 
  return fibonacci(a-1) + fibonacci(a-2); } 
  int main(){

    int a = 4;
    cout << fibonacci(a) << endl;

    return 0;
}
