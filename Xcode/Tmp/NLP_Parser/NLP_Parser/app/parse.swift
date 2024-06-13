//
//  parse.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import ArgumentParser

extension Main{
    
    struct Parse:ParsableCommand{
        @Argument()
        var rules:String
        
        @Argument()
        var lexicon:String
        
        func run(){
            let pipeline = ParsePipeline()
            pipeline.process1(initial: "", rules: "", lexicon: "")
        }
    }
}

