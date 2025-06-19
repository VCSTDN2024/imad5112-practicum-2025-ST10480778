package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.ci.playlistmanagerapp.R.id.MainScreenButton

class detailedView : AppCompatActivity() {

    private lateinit var SongTitle: ArrayList<String>
    private lateinit var ArtistName: ArrayList<String>
    private lateinit var Rating: ArrayList<Int>
    private lateinit var Comments: ArrayList<String>
    private lateinit var PlaylistViewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        intent.getStringArrayListExtra("SongTitle") ?: arrayListOf()
        intent.getStringArrayListExtra("ArtistName") ?: arrayListOf()
        intent.getIntegerArrayListExtra("Rating") ?: arrayListOf()
        intent.getStringArrayListExtra("Comments") ?: arrayListOf()


        val DisplayButton = findViewById<Button>(R.id.DisplayButton)
        val AverageRatingButton = findViewById<Button>(R.id.AverageRatingButton)
        val MainScreenButton = findViewById<Button>(MainScreenButton)


        DisplayButton.setOnClickListener {
            displayPlayList()


        }

        AverageRatingButton.setOnClickListener {
            calcAverage()
        }

        MainScreenButton.setOnClickListener {

            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun displayPlayList() {
        val output = StringBuilder()
        if (SongTitle.isNotEmpty()) {

            for (i in SongTitle.indices) {

                output.append("SongTitle: ${SongTitle[i]}\n")
                output.append("ArtistName: ${ArtistName[i]}\n")
                output.append("Rating: ${Rating[i]}\n")
                output.append("Comments: ${Comments[i]}\n\n")
            }
            PlaylistViewTextView.text =
                output.toString()  // Show all the data that has been entered in the text view
        } else {
            PlaylistViewTextView.text =
                "No data available to display."  // Error handling for the when there is no data to display


        }

    }

    private fun calcAverage() { val output = StringBuilder()
        var foundData= false
        for (i in Rating.indices) {
            if (Rating[i] >= 3) {
                output.append("Rating:${Rating[i]}\n")
                    foundData = true
                
            }
                    if (foundData) {
                        PlaylistViewTextView .text = output.toString()
                    } else {
                        PlaylistViewTextView .text = "No Rating Average found"



                    }
        }
    }

}