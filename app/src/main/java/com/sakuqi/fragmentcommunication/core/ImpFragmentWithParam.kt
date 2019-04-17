package com.sakuqi.fragmentcommunication.core

abstract class ImpFragmentWithParam<Param>(name:String):AbsFunction(name) {
    abstract fun function(param: Param)
}