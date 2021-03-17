package com.student.basic_ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.student.basic_ui.databinding.FragmentMainBinding
import splitties.alertdialog.appcompat.*
import splitties.alertdialog.material.materialAlertDialog
import splitties.toast.toast


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    val websites = arrayOf("Le Monde","National Geographic")

    lateinit var websiteSelect:String

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun browse(url: String) {
        var browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://$url"))
        startActivity(browser)
    }

    private fun showAlertDialog() {
        context?.materialAlertDialog {
            setTitle("Sites Internet")
            setItems(websites) {
                dialog, which ->
                when(websites[which]) {
                    "Le Monde" -> websiteSelect = getString(R.string.le_monde_website)
                    "National Geographic" -> websiteSelect = getString(R.string.national_geographic_website)
                }
                browse(websiteSelect)
            }
            okButton { showAlertDialog() }
            cancelButton()
        }?.onShow {
            positiveButton.setText(R.string.show)
        }?.show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainText.text = getString(R.string.main_fragment_welcome)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Button to link to website
        binding.websiteYnov.setOnClickListener {
            browse("www.ynov.com/campus/aix-en-provence/")
        }

        binding.alertDialog.setOnClickListener {
            showAlertDialog()
        }

        binding.toast.setOnClickListener{
            toast(getString(R.string.toast_text))
        }

    }
}