package com.example.sharedlogin

import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onPause() {
       val shared = this.getSharedPreferences(getString( R.string.app_name), Context.MODE_PRIVATE)
            shared.edit().putString( "user", editLogin.text.toString() )
            .putString( "senha", editSenha.text.toString() )
            .apply()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        val shared = this.getSharedPreferences(getString( R.string.app_name), Context.MODE_PRIVATE)
        if ( shared.contains("user")){
            editLogin.setText( shared.getString("user", ""))
        }
        if ( shared.contains("senha")){
            editSenha.setText( shared.getString("senha", ""))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
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
