package com.example.mytoolbox.ui.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytoolbox.R
import com.example.mytoolbox.databinding.FragmentHomeBinding
import com.example.mytoolbox.ui.HeadsOrTailsActivity
import com.example.mytoolbox.ui.QRscannerActivity
import com.example.mytoolbox.ui.RandomNumberActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val flashLightButton = root.findViewById<Button>(R.id.flashLightButton)
        flashLightButton.setOnClickListener{
            Toast.makeText(context, "flashlight", Toast.LENGTH_SHORT).show()
        }

        val headsorTails = root.findViewById(R.id.HeadsOrTails) as Button
        headsorTails.setOnClickListener{
            val intent = Intent (activity, HeadsOrTailsActivity::class.java)
            activity?.startActivity(intent)
        }

        val randomNumberGenerator = root.findViewById<Button>(R.id.RandomNumberGenerator)
        randomNumberGenerator.setOnClickListener{
            val intent = Intent (activity, RandomNumberActivity::class.java)
            activity?.startActivity(intent)
        }

        val qrScanner = root.findViewById<Button>(R.id.QrScanner)
        qrScanner.setOnClickListener{
            val intent = Intent (activity, QRscannerActivity::class.java)
            activity?.startActivity(intent)
        }

        val currentDate = LocalDate.now()
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        var formattedDate = currentDate.format(formatter)

        val textview = root.findViewById<TextView>(R.id.textView)
        val helloText = "Hello Wouter, today is "
        textview.text = helloText + formattedDate





        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}