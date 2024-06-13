#include <iostream>

int multiply(int& a, int& b){
  return a*b; 
}



int main(){
  int a = 10;
  int b = 20;
  std::cout << multiply(a, b) << std::endl;

}
