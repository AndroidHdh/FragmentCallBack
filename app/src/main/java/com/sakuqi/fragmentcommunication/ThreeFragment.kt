package com.sakuqi.fragmentcommunication

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.plus.PlusOneButton
import com.sakuqi.fragmentcommunication.core.FunctionManager

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [ThreeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ThreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThreeFragment : Fragment() {
    private var mPlusOneButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        //Find the +1 button
        mPlusOneButton = view.findViewById<Button>(R.id.button)
        mPlusOneButton?.setOnClickListener {
            val string = FunctionManager.getInstance().invokeFun(TAG,"Three",String::class.java)
            Toast.makeText(context,"two == 有参数有返回 返回值= $string", Toast.LENGTH_LONG).show()
        }
        return view
    }

    companion object {
        val TAG = ThreeFragment::class.java.name
        fun newInstance(param1: String, param2: String): ThreeFragment {
            val fragment = ThreeFragment()
            return fragment
        }
    }

}
