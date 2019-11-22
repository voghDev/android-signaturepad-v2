package dk.gomore.signaturepadrebuild

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dk.gomore.signaturepadrebuild.views.SignaturePad
import kotlinx.android.synthetic.main.activity_examples_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_EXTERNAL_STORAGE = 1
    val PERMISSIONS_STORAGE = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples_main)

        signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {
            }

            override fun onSigned() {
                saveButton.isEnabled = true
                clearButton.isEnabled = true
            }

            override fun onClear() {
                saveButton.isEnabled = false
                clearButton.isEnabled = false
            }
        })

        clearButton.setOnClickListener {
            signaturePad.clear()
        }

        saveButton.setOnClickListener {

        }
    }
}
