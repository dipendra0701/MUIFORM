package com.example.userform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.userform.R
import com.example.userform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    val list: ArrayList<String> = ArrayList()
    var gender: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This peace of code for Submit Button
        binding.btnSubmit.setOnClickListener(this)

        // This peace of code for Radio Button
        binding.radioButton.setOnCheckedChangeListener(this)

        // This peace of code for Check Box
        binding.programming.setOnCheckedChangeListener(this)
        binding.txtReadingNobels.setOnCheckedChangeListener(this)
        binding.txtWatchmovies.setOnCheckedChangeListener(this)
        binding.txtPlaying.setOnCheckedChangeListener(this)
        binding.txtTravelling.setOnCheckedChangeListener(this)
    }

    override fun onClick(view: View) {


        when (view?.id) {

            R.id.btn_submit -> {

                if (binding.tilFname.text!!.isEmpty() && binding.tilLname.text!!.isEmpty() && binding.tilMobno.editableText.isEmpty() && binding.tilAlmobno.editableText.isEmpty() && binding.tilEmail.text!!.isEmpty()) {
                    binding.tilFname.requestFocus()
                    Toast.makeText(this, "fill required information ", Toast.LENGTH_SHORT).show()
                } else if (binding.tilFname.text!!.isEmpty()) {
                    binding.tilFname.requestFocus()
                    Toast.makeText(this, "Please fill your First name", Toast.LENGTH_SHORT).show()

                } else if (binding.tilLname.text!!.isEmpty()) {
                    binding.tilLname.requestFocus()
                    Toast.makeText(this, "Please fill your Last name", Toast.LENGTH_SHORT).show()

                } else if (binding.tilMobno.editableText.isEmpty()) {
                    binding.tilMobno.requestFocus()
                    Toast.makeText(this, "Please fill your Phone Number name", Toast.LENGTH_SHORT)
                        .show()
                } else if (binding.tilAlmobno.editableText.isEmpty()) {
                    binding.tilAlmobno.requestFocus()
                    Toast.makeText(
                        this,
                        "Please fill your Alternate Number name",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (binding.tilEmail.text!!.isEmpty()) {
                    binding.tilEmail.requestFocus()
                    Toast.makeText(this, "Please fill your Email name", Toast.LENGTH_SHORT).show()

                } else if (binding.tilFname.text!!.isNotEmpty() && binding.tilLname.text!!.isNotEmpty() && binding.tilMobno.editableText.isNotEmpty() && binding.tilAlmobno.editableText.isNotEmpty() && binding.tilEmail.text!!.isNotEmpty()) {

                    val intent = Intent(this, UserInformation::class.java)
                    val fname = binding.tilFname.editableText.toString()
                    val lname = binding.tilLname.editableText.toString()
                    val mobno = binding.tilMobno.editableText.toString()
                    val almobno = binding.tilAlmobno.editableText.toString()
                    val emailid = binding.tilEmail.editableText.toString()
                    val gender = binding.tilGender.editableText.toString()
                    val  hobbies = list.toString().replace("["," ").replace("]"," ")



                    intent.putExtra("First Name", fname)
                    intent.putExtra("last Name", lname)
                    intent.putExtra("Mobile Number", mobno)
                    intent.putExtra("Alternative Mobile Number", almobno)
                    intent.putExtra("Email-id", emailid)
                    intent.putExtra("Gender", gender)
                    intent.putExtra("Hobbies",hobbies)

                    startActivity(intent)


                }


            }
        }

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (group?.checkedRadioButtonId) {
            R.id.txt_male -> {
                val rbMale = findViewById<RadioButton>(checkedId)
                gender = rbMale.text.toString()
            }
            R.id.txt_female -> {
                val rbFemale = findViewById<RadioButton>(checkedId)
                gender = rbFemale.text.toString()
            }
            R.id.txt_other -> {
                val rbothers = findViewById<RadioButton>(checkedId)
                gender = rbothers.text.toString()
            }

        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.programming -> {
                if (binding.programming.isChecked) {
                    list.add(binding.programming.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.programming.text.toString())
                }

            }
            R.id.txt_readingNobels -> {
                if (binding.txtReadingNobels.isChecked) {
                    list.add(binding.txtReadingNobels.text.toString())

                } else {
                    list.remove(binding.txtReadingNobels.text.toString())
                }

            }
            R.id.txt_watchmovies -> {
                if (binding.txtWatchmovies.isChecked) {
                    list.add(binding.txtWatchmovies.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.txtWatchmovies.text.toString())
                }

            }
            R.id.txt_playing -> {
                if (binding.txtPlaying.isChecked) {
                    list.add(binding.txtPlaying.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.txtPlaying.text.toString())
                }

            }
            R.id.txt_travelling -> {
                if (binding.txtTravelling.isChecked) {
                    list.add(binding.txtTravelling.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                } else {
                    list.remove(binding.txtTravelling.text.toString())
                }

            }
        }
    }
}
