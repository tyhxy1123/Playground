import Cocoa

func readLinesFromFile(file:String) -> [String]{
    var arr:[String] = []
    freopen(file, "r", stdin)
    while let line = readLine(){
        arr.append(line)
    }
    
    return arr
}

let path:String = "material/testsentences"
let arr = readLinesFromFile(file: path)
print(arr.count)
