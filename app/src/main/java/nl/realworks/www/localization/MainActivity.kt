package nl.realworks.www.localization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateSpinners()
        button_share.setOnClickListener { shareAvatar() }
    }

    private fun populateSpinners() {
        ArrayAdapter.createFromResource(this, R.array.hair_array, android.R.layout.simple_spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner_hair.adapter = adapter
                }

        ArrayAdapter.createFromResource(this, R.array.top_array, android.R.layout.simple_spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner_top.adapter = adapter
                }

        ArrayAdapter.createFromResource(this, R.array.bottom_array, android.R.layout.simple_spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner_bottom.adapter = adapter
                }

        ArrayAdapter.createFromResource(this, R.array.shoes_array, android.R.layout.simple_spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner_shoes.adapter = adapter
                }
    }

    private fun shareAvatar() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, createShareText())
            type = "text/plain"
        }
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share)))
    }

    private fun createShareText() = getString(R.string.share_text,
            spinner_hair.selectedItem, spinner_top.selectedItem, spinner_bottom.selectedItem, spinner_shoes.selectedItem)

}
