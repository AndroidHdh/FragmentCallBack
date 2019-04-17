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
 * [OneFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OneFragment : Fragment() {

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
            FunctionManager.getInstance().invokeFunc(TAG)
        }
        return view
    }

    companion object {
        val TAG = OneFragment::class.java.name
        fun newInstance(param1: String, param2: String): OneFragment {
            val fragment = OneFragment()
            return fragment
        }
    }

}
