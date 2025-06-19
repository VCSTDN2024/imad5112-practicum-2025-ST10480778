package vcmsa.ci.playlistmanagerapp

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

    private lateinit var SongTitle:ArrayList<String>
    private lateinit var ArtistName: ArrayList<String>
    private lateinit var Rating: ArrayList<Int>
    private lateinit var Comments:ArrayList<String>
    private lateinit var PlaylistViewTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)


        val DisplayButton = findViewById<Button>(R.id.DisplayButton)
        val AverageRatingButton = findViewById<Button>(R.id.AverageRatingButton)
        val MainScreenButton =findViewById<Button>(MainScreenButton)


        DisplayButton.setOnClickListener {
            displayPlayList()
            intent.getStringArrayListExtra("SongTitle") ?: arrayListOf()
            intent.getStringArrayListExtra("ArtistName") ?: arrayListOf()
            intent.getIntegerArrayListExtra("Rating")?: arrayListOf()
            intent.getStringArrayListExtra("Comments")?: arrayListOf()
            startActivity(intent)

        }

       AverageRatingButton.setOnClickListener {
                calcAverage()
       }

        MainScreenButton.setOnClickListener {
            val intent = intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
    private fun displayPlayList(){
        val output = StringBuilder()
        if (SongTitle.isNotEmpty()) {

            for (i in .indices){

                output.append("SongTitle: ${SongTitle[i]}\n")
                output.append("ArtistName: ${ArtistName[i]}\n")
                output.append("Rating: ${Rating[i]}\n")
                output.append("Comments: ${Comments[i]}\n\n")
            }
            PlaylistViewTextView.text = output.toString()
        } else {
            PlaylistViewTextView.text = "No data available to display."
        }

    }
    private fun calcAverage(){
        

    }
}