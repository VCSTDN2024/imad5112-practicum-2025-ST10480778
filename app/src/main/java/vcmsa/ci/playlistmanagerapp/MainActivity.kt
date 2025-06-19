package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private val SongTitle = mutableListOf<String>()
    private val ArtistsName= mutableListOf<String>()
    private val  Rating= mutableListOf<Int>()
    private val  Comments= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val SongTitleEditText = findViewById<EditText>(R.id.SongTitleEditText)
        val ArtistNameEditText = findViewById<EditText>(R.id.ArtistNameEditText)
        val RatingEditText = findViewById<EditText>(R.id.RatingEditText)
        val CommentsEditText = findViewById<EditText>(R.id.CommentsEditText)
        val AddBtn = findViewById<Button>(R.id.AddBtn)
        val playlistBtn = findViewById<Button>(R.id.PlaylistBtn)
        val exitBtn = findViewById<Button>(R.id.ExitBtn)


        AddBtn.setOnClickListener {
            showListOnDialog()
        }
        playlistBtn.setOnClickListener {
            val intent = Intent(this, detailedView::class.java)
            intent.putStringArrayListExtra("SongTitle", ArrayList(SongTitle))
            intent.putStringArrayListExtra("ArtistsName", ArrayList(ArtistsName))
            intent.putIntegerArrayListExtra("Rating", ArrayList(Rating))
            intent.putStringArrayListExtra("Comments", ArrayList(Comments))
            startActivity(intent)}
        else{
            

        }
        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }


        }
    private fun showListOnDialog(){

    }
    }
