//
//  ParseService.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class ParseService: NSObject {
    let repository:RuleRepo
    
    init(repo:RuleRepo){
        repository = repo
    }
    
    func cyk(line:String){
        let c:Matrix = Matrix()
        let l:[Substring] = line.split(separator: " ")
        let list = l.filter{
            str -> Bool in str != "" && str != "->"
        }
        var w:[String] = ["0"]
        for word in list{
            w.append(String(word))
        }
        let n = list.count
        for i in 1...n{
            let tmp = repository.getLexicon(word: w[i])
            for lexical in tmp{
                c.add(x:i-1, y:i, bt:Bt(nt: lexical.lhs, score: lexical.weight))
            }
        }
    }
}
