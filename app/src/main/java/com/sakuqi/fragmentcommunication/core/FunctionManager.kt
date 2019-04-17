package com.sakuqi.fragmentcommunication.core

class FunctionManager {
    companion object {
        private var functionManager:FunctionManager? = null
        fun getInstance():FunctionManager{
            if (functionManager == null) {
                functionManager = FunctionManager()
            }
            return functionManager!!
        }
    }

    private var mFunctionMap:MutableMap<String,AbsFunction>?=null

    init {
        mFunctionMap = HashMap()
    }

    fun addFunction(function:AbsFunction):FunctionManager{
        if (mFunctionMap.isNullOrEmpty()) {
            mFunctionMap = HashMap()
        }
        mFunctionMap?.put(function.name,function)
        return this
    }

    fun invokeFunc(functionName:String){
        if (functionName.isNullOrEmpty()) {
            return
        }
        mFunctionMap?.let {
            val function = it[functionName]
            if(function is ImpFragmentOnlyName){
                function.function()
            }else{
                throw FunctionException("No found this function $functionName")
            }
        }
    }

    fun <Param> invokeFun(functionName: String,param:Param){
        if (functionName.isNullOrEmpty()) {
            return
        }
        mFunctionMap?.let {
            val function = it[functionName]
            if(function is ImpFragmentWithParam<*>) {
                function as ImpFragmentWithParam<Param>
                function.function(param)
            } else{
                throw FunctionException("No found this function $functionName")
            }
        }
    }

    fun <Result> invokeFun(functionName: String,clz:Class<Result>):Result?{
        if (functionName.isNullOrEmpty()) {
            return null
        }
        mFunctionMap?.let {
            val function = it[functionName]
            if(function is ImpFragmentWithResult<*>) {
                function as ImpFragmentWithResult<Result>
                return clz.cast(function.function())
            } else{
                throw FunctionException("No found this function $functionName")
            }
        }
        return null
    }

    fun <Param,Result> invokeFun(functionName: String,param: Param,clz:Class<Result>):Result?{
        if (functionName.isNullOrEmpty()) {
            return null
        }
        mFunctionMap?.let {
            val function = it[functionName]
            if(function is ImpFragmentWithParamWithResult<*,*>) {
                function as ImpFragmentWithParamWithResult<Param,Result>
                return clz.cast(function.function(param))
            } else{
                throw FunctionException("No found this function $functionName")
            }
        }
        return null
    }
}