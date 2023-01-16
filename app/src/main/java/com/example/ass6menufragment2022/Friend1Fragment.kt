package com.example.ass6menufragment2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ass6menufragment2022.databinding.ActivityMainBinding
import com.example.ass6menufragment2022.databinding.FragmentFriend1Binding


class Friend1Fragment : Fragment() {
    private lateinit var bindingFrag: FragmentFriend1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFrag = FragmentFriend1Binding.inflate(layoutInflater)
        bindingFrag.btnBack.setOnClickListener(){
            var fragment : Fragment? = null
            fragment = MyFragment()
            replaceFragment(fragment)
        }
        return bindingFrag.root
    }
    fun replaceFragment(someFragment:Fragment){
        var binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.frameLayout, someFragment)
        transaction.replace(binding.frameLayout.id, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}