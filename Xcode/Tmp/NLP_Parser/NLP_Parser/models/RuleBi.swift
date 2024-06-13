//
//  Rule.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class RuleBi: Hashable {
    func hash(into hasher: inout Hasher) {
        hasher.combine(lhs)
        hasher.combine(rhs)
    }
    
    static func == (lhs: RuleBi, rhs: RuleBi) -> Bool {
        return lhs.lhs == rhs.lhs && lhs.rhs == rhs.rhs
    }
    
    internal init(lhs: String, rhs: [String], weight: Double) {
        self.lhs = lhs
        self.rhs = rhs
        self.weight = weight
    }
    
    let lhs:String
    let rhs:[String]
    let weight:Double
    
}
