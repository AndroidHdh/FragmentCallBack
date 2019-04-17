package com.sakuqi.fragmentcommunication

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sakuqi.fragmentcommunication.core.FunctionManager
import com.sakuqi.fragmentcommunication.core.ImpFragmentOnlyName
import com.sakuqi.fragmentcommunication.core.ImpFragmentWithParam
import com.sakuqi.fragmentcommunication.core.ImpFragmentWithParamWithResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var oneFragment:OneFragment?=null
    private var twoFragment:TwoFragment?=null
    private var threeFragment:ThreeFragment?=null
    private var currentFragment:Fragment?=null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
               replaceFragment(oneFragment!!)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replaceFragment(twoFragment!!)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                replaceFragment(threeFragment!!)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        oneFragment = OneFragment()
        twoFragment = TwoFragment()
        threeFragment = ThreeFragment()
        replaceFragment(oneFragment!!)
        addListener()
    }

    private fun replaceFragment(oneFragment: Fragment){
        var fragmentManager =  supportFragmentManager
        var transaction = fragmentManager.beginTransaction()
        if(currentFragment == null){
            transaction.add(R.id.fragment,oneFragment)
        }else{
            transaction.replace(R.id.fragment,oneFragment)
        }
        transaction.commit()
        currentFragment = oneFragment
    }

    private fun addListener(){
        FunctionManager.getInstance().addFunction(object :ImpFragmentOnlyName(OneFragment.TAG){

            override fun function() {
                Toast.makeText(this@MainActivity,"One == 无参数无返回值",Toast.LENGTH_LONG).show()
            }
        }).addFunction(object:ImpFragmentWithParam<String>(TwoFragment.TAG){
            override fun function(param: String) {
                Toast.makeText(this@MainActivity,"two == 有参数 = $param",Toast.LENGTH_LONG).show()
            }
        }).addFunction(object :ImpFragmentWithParamWithResult<String,String>(ThreeFragment.TAG){
            override fun function(param: String): String {
                Toast.makeText(this@MainActivity,"two == 有参数有返回 参数= $param",Toast.LENGTH_LONG).show()
                return "我是返回值"
            }
        })
    }
}
