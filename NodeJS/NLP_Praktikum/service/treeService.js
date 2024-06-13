const {Lexical, Node, NonLexical, Atom} = require("../model/GrammarNode")

class TreeService{
    constructor(){
        this._nodeRepository = []
        this._lexicalRepository = []
        this._nonLexicalRepository = []
        this._atomRepository = []
        this.id = 0
    }
    getAllNodes = () => {
        return this._nodeRepository
    }

    getAllLexicon = () => {
        return this._lexicalRepository
    }

    getAllNonLexicon = () => {
        return this._nonLexicalRepository
    }

    getAllTrees = (callback) => {
        return this._atomRepository
    }

    createLexical = (value, parent, children) => {
        const node = new Lexical(++this.id, value, parent, children, "lexical")
        this._nodeRepository.push(node)
        this._lexicalRepository.push(node)
        return node
    }

    createNonLexical = (value, parent, children) => {
        const node = new NonLexical(++this.id, value, parent, children, "nonLexical")
        this._nodeRepository.push(node)
        this._nonLexicalRepository.push(node)
        return node
    }

    createAtom = (value, parent, children) => {
        const atom = new Atom(++this.id, value, parent, children, "atom")
        this._atomRepository.push(atom)
        this._nodeRepository.push(atom)
        return atom
    }

    parseTree (line) {
        let arr = line.toString().split(' ');
        const root = this.createAtom(arr.shift().substring(1), null, [])
        var stack = [root]
        arr.forEach(str => {
            if (str.includes("(")) {
                const node = this.createNonLexical(str.substring(1), stack[stack.length - 1], [])
                node.parent.children.push(node)
                stack.push(node)
            } else {
                const node = this.createLexical(str.substring(1), stack[stack.length - 1], null)
                node.parent.child = node
                str.slice(str.indexOf(')')).split().forEach(() => stack.pop())
            }
        });
        return this._atomRepository
    }
}

module.exports = {TreeService}