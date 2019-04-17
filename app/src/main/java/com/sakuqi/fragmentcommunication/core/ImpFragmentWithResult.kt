package com.sakuqi.fragmentcommunication.core

abstract class ImpFragmentWithResult<Result>(name:String):AbsFunction(name) {
    abstract fun function():Result
}