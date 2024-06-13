//
//  RuleRepo.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class RuleRepo: NSObject {
    
    var biToSet:Dictionary<[String], Set<RuleBi>> = Dictionary()
    var unToSet:Dictionary<String, Set<RuleUn>> = Dictionary()
    var lexToSet:Dictionary<String, Set<Lexical>> = Dictionary()
    
    func add(bi:RuleBi){
        if biToSet.keys.contains(bi.rhs) {
            biToSet[bi.rhs]!.insert(bi)
        }
        else{
            biToSet[bi.rhs] = []
        }
    }
    
    func add(un:RuleUn){
        if unToSet.keys.contains(un.rhs){
            unToSet[un.rhs]!.insert(un)
        }
        else{
            unToSet[un.rhs] = []
        }
    }
    
    func add(lx:Lexical){
        if lexToSet.keys.contains(lx.rhs){
            lexToSet[lx.rhs]!.insert(lx)
        }
        else{
            lexToSet[lx.rhs] = Set()
        }
    }
    
    func getRules(bi:[String]) -> Set<RuleBi>{
        if biToSet.keys.contains(bi) {
            return biToSet[bi]!
        }
        else{
            return Set()
        }
    }
    
    func getRules(un:String) -> Set<RuleUn>{
        if unToSet.keys.contains(un){
            return unToSet[un]!
        }
        else{
            return Set()
        }
    }
    
    func getLexicon(word:String) -> Set<Lexical>{
        if lexToSet.keys.contains(word){
            return lexToSet[word]!
        }
        else{
            return Set()
        }
    }
}
