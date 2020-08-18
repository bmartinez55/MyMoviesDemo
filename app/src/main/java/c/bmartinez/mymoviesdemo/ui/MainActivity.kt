package c.bmartinez.mymoviesdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.ui.list.ListAdapter
import c.bmartinez.mymoviesdemo.ui.list.ListFragment
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       supportFragmentManager.beginTransaction()
           .replace(R.id.fragment_container, ListFragment()).commit()
    }
}