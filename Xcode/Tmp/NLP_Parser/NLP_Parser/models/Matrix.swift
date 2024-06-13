//
//  Matrix.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Cocoa

class Matrix: NSObject {
    var matrix = Dictionary<Int, Dictionary<Int, Dictionary<String, Bt>>>()
    func get(x:Int, y:Int) -> [String:Bt]{
        if matrix.keys.contains(x){
            if matrix[x]!.keys.contains(y){
                return matrix[x]![y]!
            }
            else{
                matrix[x]![y] = Dictionary()
                return matrix[x]![y]!
            }
        }
        else{
            matrix[x] = Dictionary()
            matrix[x]![y] = Dictionary()
            return matrix[x]![y]!
        }
    }
    func add(x:Int, y:Int, bt:Bt){
        if matrix.keys.contains(x) && matrix[x]!.keys.contains(y){
            matrix[x]![y]![bt.nt] = bt
        }
        else if matrix.keys.contains(x){
            matrix[x]![y] = Dictionary()
            matrix[x]![y]![bt.nt] = bt
        }
        else{
            matrix[x] = Dictionary()
            matrix[x]![y] = Dictionary()
            matrix[x]![y]![bt.nt] = bt
        }
    }
}
