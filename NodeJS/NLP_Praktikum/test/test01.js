const {TreeService} = require('../service/treeService.js');
const {
    Node,
    Lexical,
    NonLexical,
    Atom
} = require('../model/GrammarNode');
const lineReader = require('line-reader')
const Readline = require('readline')
const fs = require('fs')
const lineByLine = require('n-readlines');

function strFirstLast(line) {
    const treeService = new TreeService()
    let arr = line.split(' ')
    const root = treeService.createAtom(arr.shift().substring(1), null, [])
    var stack = [root]
    arr.forEach(str => {
        if(str.contains("(")){
            const node = treeService.createNonLexical(str.substring(1), stack[stack.length - 1], [])
            node.parent.children.push(node)
            stack.push(node)
        }
        else{
            const node = treeService.createLexical(str.substring(1), stack[stack.length - 1], null)
            node.parent.child = node
            stack.push(node)
        }
    });
}

function shift(){
    arr = ["a", "b", "c"]
    console.log(arr.shift());
    console.log(arr);
}

function readFile(){
    const readStream = fs.createReadStream('./test/text.txt')
    readStream.on('error', function(err){
        console.log(err.message);
        console.log(err.stack);
    })
    const readInterface = Readline.createInterface({
        input: readStream,
        output: process.stdout,
        console: false
    });

    readInterface.on('line', function(line){
        console.log(line);
    })
}

function currentFolder(){
    console.log(process.cwd());
}

function stringDotChain(){
    const str = "abcdef"
    str.slice(1).split().forEach(ch => console.log(ch));
}

function readFileAndParseTree() {

    const treeService = new TreeService()

    const liner = new lineByLine('./test/training.mrg')
    var line;
    while(line = liner.next()){
        treeService.parseTree(line)
    }
    console.log(treeService.getAllTrees().length);
}

function readFileAndParseTreeAsync(){
    const treeService = new TreeService();
    const readInterface = Readline.createInterface({
        input: fs.createReadStream('./test/test.txt'),
        output: process.stdout,
        terminal: false
    })
    readInterface.on('line', function(line){
        treeService.parseTree(line);
    })
}
readFileAndParseTree()