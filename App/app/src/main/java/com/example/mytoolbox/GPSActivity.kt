package com.example.mytoolbox

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationRequest
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationServices


class GPSActivity : AppCompatActivity() {

    private val locationPermissionCode = 2
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var locationRequest: LocationRequest? = null
    private val locationCallback: LocationCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps_page)

        val backButton = findViewById<Button>(R.id.gpsbackButton)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val gpstoggleButton = findViewById<ToggleButton>(R.id.toggleButton)


        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        updateTextViews()

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }

        updateButton.setOnClickListener {
            updateTextViews()
        }

        gpstoggleButton.setOnClickListener {
            if (gpstoggleButton.isChecked) {
                //auto update gps every couple seconds
                //while (gpstoggleButton.isChecked) {
                    updateTextViews()


                //}
            }

        }
    }

    private fun updateTextViews() {
        val longitudeView = findViewById<TextView>(R.id.longitudeTextView)
        val latituteView = findViewById<TextView>(R.id.latitudeTextView)
        val speedView = findViewById<TextView>(R.id.speedTextView)
        val altituteView = findViewById<TextView>(R.id.altitudeTextView)
        val bearingView = findViewById<TextView>(R.id.bearingTextView)


        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }

        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                longitudeView.text = "" + location.longitude
                latituteView.text = "" + location.latitude
                speedView.text = "" + location.speed
                altituteView.text = "" + location.altitude
                bearingView.text = "" +location.bearing
                Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }

    }
}