package com.student.basic_ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.student.basic_ui.databinding.FragmentSecondBinding
import splitties.toast.longToast
import splitties.toast.toast

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Log.i(SecondFragment::class.simpleName, "onCreateView")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(binding.root, savedInstanceState)

        Log.i(SecondFragment::class.simpleName, "onViewCreated")

        //binding.fab.setOnClickListener { toast(R.string.text_island) }

        binding.fab.setOnClickListener { longToast(R.string.text_island) }

        //binding.btnAlert.setOnClickListener { showAlertDialog() }

        //binding.btnAlert.setOnClickListener { share(R.string.text_share, R.string.title_share) }

        binding.buttonSecond.setOnClickListener { findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment) }

        binding.btnSnackBar.setOnClickListener { view ->
            Snackbar.make(view, R.string.text_label, Snackbar.LENGTH_SHORT)
                .setAction("Action") {
                    toast(R.string.text_island)
            }.show()
        }

        binding.btnEmptyActivity.setOnClickListener { sendMessage(view) }
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        Log.i(FirstFragment::class.simpleName, "SendMessage")
        val message = "Heyyy"
        val intent = Intent(getActivity(), EmptyActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /*private fun showAlertDialog() {
        alertDialog {
            messageResource = R.string.text_alert
            okButton { showAlertDialog() }
            cancelButton()
        }.onShow {
            positiveButton.setText(R.string.action_like)
        }.show()
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}