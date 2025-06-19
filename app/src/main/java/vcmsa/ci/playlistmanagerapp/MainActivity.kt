package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {

    private val SongTitle = mutableListOf<String>()
    private val ArtistsName = mutableListOf<String>()
    private val Rating = mutableListOf<Int>()
    private val Comments = mutableListOf<String>()

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
            val  intent = Intent(this, detailedView::class.java)
            intent.putStringArrayListExtra("SongTitle", ArrayList(SongTitle))
            intent.putStringArrayListExtra("ArtistsName", ArrayList(ArtistsName))
            intent.putIntegerArrayListExtra("Rating", ArrayList(Rating))
            intent.putStringArrayListExtra("Comments", ArrayList(Comments))
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }

    private fun showListOnDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Enter Details")

        val dialogView = layoutInflater.inflate(R.layout.activity_main, null)
        val dataOne = dialogView.findViewById<EditText>(R.id.SongTitleEditText)
        val dataTwo = dialogView.findViewById<EditText>(R.id.ArtistNameEditText)
        val dataThree = dialogView.findViewById<EditText>(R.id.RatingEditText)
        val dataFour = dialogView.findViewById<EditText>(R.id.CommentsEditText)

        dialogBuilder.setView(dialogView)

        dialogBuilder.setPositiveButton("Add") { _, _ ->
            val Song = dataOne.text.toString().trim()
            val Artist = dataTwo.text.toString().trim()
            val Rate = dataThree.text.toString().trim()
            val Comment = dataFour.text.toString().trim()


            if (Song.isEmpty() || Artist.isEmpty() || Rate.isEmpty() || Comment.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "All required fields must be filled in.",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setPositiveButton
            }

            val dataThree = Rate.toIntOrNull()
            if (dataThree == null || dataThree <= 0) {
                Toast.makeText(getApplicationContext(),"Enter number greater 0",Toast.LENGTH_SHORT).show();

            }
        }

    }
}


