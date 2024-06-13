//
//  main.cpp
//  learnCpp
//
//  Created by Xiangyu Hou on 11.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

#include <iostream>
#include <cmath>
#include <climits>
#include <string>

int fibonacci(unsigned long long n){
    if(n == 0){
        return 0;
    }
    else if(n == 1){
        return 1;
    }
    else{
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

int main2() {
    using namespace std;
//    unsigned long long n = 46;
//    cout << "fibonacci " << n << " is " << fibonacci(n) << endl;
    char str[] = "Hello " "World!";
    string str1 = "Go go";
    cout << (sizeof str)/sizeof (char) - 1 << endl;
    cout << str << endl;
    cout << strlen(str) << endl;
    cout << str1 << endl;
    return 0;
}


