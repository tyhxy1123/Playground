//
//  Pair.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

struct Pair<T:Hashable, S:Hashable>: Hashable{
    func hash(into hasher: inout Hasher) {
        hasher.combine(first)
        hasher.combine(second)
    }

    static func == (lhs: Pair<T,S>, rhs: Pair<T,S>) -> Bool {
        return lhs.first == rhs.first && lhs.second == rhs.second
    }
    
    internal init(first: T, second: S) {
        self.first = first
        self.second = second
    }
    
    let first:T
    let second:S
    
}
