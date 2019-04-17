package com.sakuqi.fragmentcommunication.core

abstract class ImpFragmentWithParamWithResult<Param,Result>(name:String):AbsFunction(name) {
    abstract fun function(param: Param):Result
}