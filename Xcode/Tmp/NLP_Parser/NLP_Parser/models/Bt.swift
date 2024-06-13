//
//  Bt.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class Bt: Hashable {
    
    let nt:String
    let score:Double
    let children:[Bt]
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(nt)
    }
    
    static func == (lhs: Bt, rhs: Bt) -> Bool {
        return lhs.nt == rhs.nt
    }
    
    internal init(nt: String, score: Double, bts:Bt...) {
        self.nt = nt
        self.score = score
        self.children = bts
    }
}
