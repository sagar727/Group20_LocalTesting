package jlin2.examples.localtesting

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity(), View.OnClickListener {
    // The TextView used to display the message inside the Activity.
    private var mTextView: TextView? = null

    // The EditText where the user types the message.
    private var mEditText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the listeners for the buttons.
        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener(this)
        mTextView = findViewById<View>(R.id.textToBeChanged) as TextView
        mEditText = findViewById<View>(R.id.editTextUserInput) as EditText
    }

    override fun onClick(view: View) {
        // Get the text from the EditText view.
        val text = mEditText!!.text.toString()
        val changeTextBtId = R.id.changeTextBt
        val activityChangeTextBtnId = R.id.activityChangeTextBtn
        if (view.id == changeTextBtId) {
            // First button's interaction: set a text in a text view.
            mTextView!!.text = text
        } else if (view.id == activityChangeTextBtnId) {
            // Second button's interaction: start an activity and send a message to it.
            val intent = ShowTextActivity
                .newStartIntent(this, text)
            startActivity(intent)
        }
    }
}