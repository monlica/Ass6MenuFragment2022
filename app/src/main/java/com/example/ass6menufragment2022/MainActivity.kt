package com.example.ass6menufragment2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.ass6menufragment2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show FirstFragment
        if(savedInstanceState==null){
            replaceFragment(MyFragment())
        }

        // Click on Bottom Navigation Bar
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.menu1 -> replaceFragment(MyFragment())
                R.id.menu2 -> replaceFragment(Friend1Fragment())
                R.id.menu3 -> replaceFragment(Friend2Fragment())
            }
            true
        }
    }
    //// Options Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //// Click on Options Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> replaceFragment(Friend1Fragment())
            R.id.menu2 -> replaceFragment(Friend2Fragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(someFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, someFragment)
        fragmentTransaction.commit()
    }
}