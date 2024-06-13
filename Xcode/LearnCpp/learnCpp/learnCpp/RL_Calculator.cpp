//
//  RL_Calculator.cpp
//  learnCpp
//
//  Created by Xiangyu Hou on 13.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

#include <iostream>
#include <array>

void fun1(){
    using namespace std;
    // Ra = (Ue - Ua)/Ua * RL
    float ue = 10;
    float *rl = new float[7]{100, 200, 300, 400, 600, 800, 1000};
    float *ua = new float[7]{2.36, 4.72, 7.079, 9.439, 10, 10, 10};
    float *ra= new float[7];
    int size = 7;
    for(int i = 0; i < size; i++) {
        float uaa = ua[i];
        ra[i] = ((ue - uaa)/uaa) * rl[i];
    }
    for(int i = 0; i < size; i++) {
        cout << "ra[" << i << "]: " << ra[i] << endl;
    }
    
    delete [] ra;
    delete [] ua;
    delete [] rl;
}

void fun2(){
    using namespace std;
    float r1 = 100;
    float r2 = 100;
    float r3 = 10;
    float r41 = 10;
    float r42 = 100;
    float r4 = r41;
    float ergebnis = (r2*(r3+r4))/(r3*(r1+r2));
    cout << ergebnis << endl;
}

int main(){
    
    
    fun2();
    
    return 0;
}
