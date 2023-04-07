package com.example.mytoolbox.ui.home

import android.content.Context.CAMERA_SERVICE
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytoolbox.R
import com.example.mytoolbox.databinding.FragmentHomeBinding
import com.example.mytoolbox.ui.HeadsOrTailsActivity
import com.example.mytoolbox.ui.NameGeneratorActivity
import com.example.mytoolbox.ui.QRscannerActivity
import com.example.mytoolbox.ui.RandomNumberActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    lateinit var cameraManager: CameraManager
    lateinit var cameraID: String

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
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        cameraManager = activity?.getSystemService(CAMERA_SERVICE) as CameraManager
        try {
            // O means back camera unit,
            // 1 means front camera unit
            // on below line we are getting camera id
            // for back camera as we will be using
            // torch for back camera
            cameraID = cameraManager.cameraIdList[0]
        } catch (e: Exception) {
            // on below line we are handling exception.
            e.printStackTrace()
        }


        val flashLightButton = root.findViewById<ToggleButton>(R.id.flashLightButton)
        flashLightButton.setOnClickListener{
            if (flashLightButton.isChecked) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        cameraManager.setTorchMode(cameraID, true)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        cameraManager.setTorchMode(cameraID, false)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


        }

        val headsOrTails = root.findViewById(R.id.HeadsOrTails) as Button
        headsOrTails.setOnClickListener{
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

        val nameGenerator = root.findViewById<Button>(R.id.nameGenerator)
        nameGenerator.setOnClickListener{
            val intent = Intent (activity, NameGeneratorActivity::class.java)
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
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraID, false)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}