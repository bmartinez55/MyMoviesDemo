package c.bmartinez.mymoviesdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.ui.list.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ListFragment()).commit()
        }
    }
}