//
//  main.swift
//  NLP_Parser
//
//  Created by Xiangyu Hou on 01.06.20.
//  Copyright © 2020 Xianagyu Hou. All rights reserved.
//

import Foundation
import ArgumentParser

struct Main: ParsableCommand{
    static var configuration = CommandConfiguration(
    subcommands: [Parse.self])
}


Main.main()

