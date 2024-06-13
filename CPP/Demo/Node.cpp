#include <iostream>
#include "Node.h"


Node::Node(int &ch) {
    Node::a = ch;
    std::cout << Node::a << std::endl;
}

Node::~Node(){

}
