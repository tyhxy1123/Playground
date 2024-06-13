import Cocoa

var str = "Hello, playground"

let drive = { (car :String) -> Bool in
    if car == "Auto"{
        print("driving a car")
        return true
    }
    else{
        print("not driving a car")
        return false
    }
}

func carDrive(action : (String) -> Bool){
    action("Auto")
}

carDrive(action: drive)

func option(action :() -> Void){
    print("action begin...")
    action()
    print("action finished...")
}

//option(action: {print("gogo")})
option{
    print("gogo")
}

