package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        }
    private fun showListOnDialog(){
        val dialogbuilder = AlertDialog.Builder(this)
        dialogbuilder.setTitle("Add New Song")

       val dialogView = layoutInflater.inflate(R.layout.activity_main, null)

        val SongTitleEditText = dialogView.findViewById<EditText>(R.id.SongTitleEditText)
        val ArtistNameEditText = dialogView.findViewById<EditText>(R.id.ArtistNameEditText)
        val RatingEditText = dialogView.findViewById<EditText>(R.id.RatingEditText)
        val CommentsEditText = dialogView.findViewById<EditText>(R.id.CommentsEditText)

        dialogBuilder.setView(dialogView)

        dialogBuilder.setPositiveButton("Add") { dialog, _ ->
            val Songtitle = SongTitleEditText.text.toString().trim()
            val Artist = ArtistNameEditText.text.toString().trim()
            val Rating = RatingEditText.text.trim()
            val Comments = CommentsEditText.text.toString().trim()
            if (SongTitle.isEmpty() || ArtistsName.isEmpty() || Rating.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "All required fields must be filled in.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            val Rating= Rating.toIntOrNull()
            if (rating == null || Rating <= 0)
                Snackbar.make(findViewById(android.R.id.content), "Enter a valid number greater than zero")}
    }
