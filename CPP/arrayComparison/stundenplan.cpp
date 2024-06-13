#include <iostream>
#include <cmath>
#include <list>

using namespace std;

string dict[] = {"ECG", "Prog", "IW", "TIL", "IKT", "RA", "DB", "RN"};
int dictLength = (int) (sizeof(dict) / sizeof(dict[0]));

string& referenceTest(const string& str){
    string test = str;
    string* p = &test;
    return *p;
}

void checkList(string *l1, int length) {
    printf("%d\n", dictLength);
    printf("%d\n", length);
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < dictLength; j++) {
            if (dict[j] == l1[i]) {
                dict[j] = "/0";
            }
            cout << "dict: " << dict[j] << endl;
        }
        printf("\n");
    }
}

int main() {
    string toCheck[] = {"ECG", "Prog", "IW", "TIL", "RA"};
    checkList(&toCheck[0], (int) (sizeof(toCheck) / sizeof(toCheck[0])));
    for (int i = 0; i < dictLength; i++) {
        cout << dict[i] << endl;
    }
}

