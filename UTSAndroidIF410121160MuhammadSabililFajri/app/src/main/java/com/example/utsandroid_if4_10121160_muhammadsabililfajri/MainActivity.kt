package com.example.utsandroid_if4_10121160_muhammadsabililfajri

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupTestType: RadioGroup
    private lateinit var confirmedDate: EditText
    private lateinit var nik: EditText
    private lateinit var name: EditText
    private lateinit var birthDate: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioGroupRelationship: RadioGroup
    private lateinit var checkBoxAgreement: CheckBox
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        radioGroupTestType = findViewById(R.id.radioGroupTestType)
        confirmedDate = findViewById(R.id.confirm_date)
        nik = findViewById(R.id.nik)
        name = findViewById(R.id.name)
        birthDate = findViewById(R.id.birthDate)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        radioGroupRelationship = findViewById(R.id.radioGroupRelationship)
        checkBoxAgreement = findViewById(R.id.checkBoxAgreement)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            if (validateForm()) {
                // Form is valid, process the data
                val selectedTestType = findViewById<RadioButton>(radioGroupTestType.checkedRadioButtonId).text
                val selectedGender = findViewById<RadioButton>(radioGroupGender.checkedRadioButtonId).text
                val selectedRelationship = findViewById<RadioButton>(radioGroupRelationship.checkedRadioButtonId).text

                val formData = "Jenis Tes: $selectedTestType\n" +
                        "Tanggal Terkonfirmasi: ${confirmedDate.text}\n" +
                        "NIK: ${nik.text}\n" +
                        "Nama: ${name.text}\n" +
                        "Tanggal Lahir: ${birthDate.text}\n" +
                        "Jenis Kelamin: $selectedGender\n" +
                        "Hubungan: $selectedRelationship"

                // Display the form data or send it to the server
                Toast.makeText(this, formData, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateForm(): Boolean {
        if (confirmedDate.text.isEmpty() || nik.text.isEmpty() || name.text.isEmpty() || birthDate.text.isEmpty()) {
            Toast.makeText(this, "Harap isi semua field yang wajib", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!checkBoxAgreement.isChecked) {
            Toast.makeText(this, "Anda harus menyetujui bahwa data yang diisi benar", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}