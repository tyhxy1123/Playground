const chalk = require('chalk');
const clear = require('clear');
const figlet = require('figlet');
const files = require('./lib/files')
const Readline = require('readline')
const {TreeService} = require('./service/treeService')

clear();

console.log(
    chalk.yellow(
        figlet.textSync('NLP', {horizontalLayout: 'full'})
    )
)

process.stdin.setEncoding('utf8')
const rl = Readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
})

rl.on('line', function(line){
    console.log(line);
})

const treeService = new TreeService()
treeService.createLexical("N", null, [])

treeService.getAllNodes().forEach(element => {
    console.log(element);
});



process.exit()