package com.gl4.pizza_app

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.gl4.pizzaapp.R
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {

    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var adress: EditText
    lateinit var type: RadioGroup
    lateinit var typeId: RadioButton
    lateinit var fromage: CheckBox
    lateinit var champignon: CheckBox
    lateinit var roquette: CheckBox
    lateinit var jambon: CheckBox
    lateinit var olives: CheckBox
    lateinit var nextButton: Button
    lateinit var ingredients: String

    lateinit var nom: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.shr_login_fragment)

        firstName = findViewById(R.id.first_name_text_edit)
        lastName = findViewById(R.id.last_name_text_edit)
        adress = findViewById(R.id.adress_text_edit)
        type = findViewById(R.id.type)
        fromage = findViewById(R.id.fromageButton)
        champignon = findViewById(R.id.champignonButton)
        roquette = findViewById(R.id.roquetteButton)
        jambon = findViewById(R.id.jambonButton)
        olives = findViewById(R.id.olivesButton)
        nextButton = findViewById(R.id.next_button)


        nextButton.setOnClickListener {
            typeId = findViewById(type.checkedRadioButtonId)

            ingredients = ""

            if (fromage.isChecked) {
                ingredients += "Fromage "
            }
            if (champignon.isChecked) {
                ingredients += "Champignon "
            }
            if (roquette.isChecked) {
                ingredients += "Roquette "
            }
            if (jambon.isChecked) {
                ingredients += "Jambon "
            }
            if (olives.isChecked) {
                ingredients += "Olives "
            }

            val message = "Bonjour cher client, \n" +
                    "First Name : ${firstName.text.toString()} \n" +
                    "Last Name : ${lastName.text.toString()} \n" +
                    "Your pizza will be delivred to your adress : ${adress.text.toString()} \n \n" +
                    "Pizza type : ${typeId.text.toString()} \n" +
                    "Pizza ingredients : $ingredients \n \n" +
                    "Enjoy your food !"

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, "smaouiyoussef1603@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Commande de pizza")
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }
    }

    fun main(args: Array<String>) {
        // Execution starting point
        println("Hello world!!")
        // Delay of 5 sec
        Timer().schedule(5000) {
        //calling a function newMethod()
        }
    }

    fun newMethod() {
        println("Delayed method call!")
    }


        /*   nextButton.setOnClickListener {
                   val intent = Intent(Intent.ACTION_SEND)
                   intent.putExtra(Intent.EXTRA_EMAIL, "smaouiyoussef1603@gmail.com")
                   intent.putExtra(Intent.EXTRA_SUBJECT, "Commande de pizza")
                   intent.putExtra(Intent.EXTRA_TEXT, message)
                   intent.type = "text/plain"
                   startActivity(Intent.createChooser(intent, "Select email"))
               }*/


/*
    fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            startActivity(Intent.createChooser(mIntent, "Choisir l'Email.."))
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
*/
}
