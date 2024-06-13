//
//  ParsePipeline.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class ParsePipeline: NSObject {
    func process1(initial:String, rules:String, lexicon:String){
        let path = "/Users/xiangyu/Projects/Playground/Xcode/Tmp/NLP_Parser/material/grammar.rules"
        let lines = FileService().readLinesFromFile(file: path)
        for line in lines{
            print(line)
        }
    }
}
