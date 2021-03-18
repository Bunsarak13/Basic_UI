package com.student.basic_ui


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.student.basic_ui.databinding.ActivityMainBinding
import splitties.activities.start
import splitties.toast.toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        binding.fab.setOnClickListener{
            sendEmail("bunsarak.pen@ynov.com", "Hello BasicUI", "Message send to Kotlin App Basic UI")
        }

        binding.buttonSecondActivity.setOnClickListener {
            start<SecondaryActivity>()
        }


    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun sendEmail(to: String, subject: String, msg: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)

        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, msg)

        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.title_send_email)))
        } catch (ex: ActivityNotFoundException) {
            toast(R.string.text_no_email_client)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}