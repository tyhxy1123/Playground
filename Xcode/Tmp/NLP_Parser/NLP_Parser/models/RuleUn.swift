//
//  RuleUn.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class RuleUn:Hashable {
    internal init(lhs: String, rhs: String, weight: Double) {
        self.lhs = lhs
        self.rhs = rhs
        self.weight = weight
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(lhs)
        hasher.combine(rhs)
    }
    
    static func == (lhs: RuleUn, rhs: RuleUn) -> Bool {
        return lhs.lhs == rhs.lhs && lhs.rhs == rhs.rhs
    }
    
    let lhs:String
    let rhs:String
    let weight:Double
}
