package com.sakuqi.fragmentcommunication

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.gms.plus.PlusOneButton
import com.sakuqi.fragmentcommunication.core.FunctionManager

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [TwoFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TwoFragment : Fragment() {
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
        mPlusOneButton = view.findViewById(R.id.button)
        mPlusOneButton?.setOnClickListener {
            FunctionManager.getInstance().invokeFun(TAG,"我是参数")
        }

        return view
    }

    companion object {
        val TAG = TwoFragment::class.java.name
        fun newInstance(param1: String, param2: String): TwoFragment {
            val fragment = TwoFragment()
            return fragment
        }
    }

}
