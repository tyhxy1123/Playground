class Node {
    constructor(id, value, parent, children, type){
        this.id = id
        this.value = value
        this.parent = parent
        this.children = children
        this.type = type
    }
}

class Lexical{
    constructor(id, value, parent, child, type){
        this.id = id
        this.value = value
        this.parent = parent
        this.child = child
        this.type = type
    }
}

class NonLexical{
    constructor(id, value, parent, children, type) {
        this.id = id
        this.value = value
        this.parent = parent
        this.children = children
        this.type = type
    }
}

class Atom{
    constructor(id, value, parent, children, type) {
        this.id = id
        this.value = value
        this.parent = parent
        this.children = children
        this.type = type
    }
}

module.exports = {Node, Lexical, NonLexical, Atom}