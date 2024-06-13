//
//  FileService.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class FileService: NSObject {
    func readLinesFromFile(file:String) -> [String]{
        var arr:[String] = []
        freopen(file, "r", stdin)
        while let line = readLine(){
            arr.append(line)
        }
        return arr
    }
}
