package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess
 // to suppress the name shadowing
@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
  // Decalartion of the array list
    private val SongTitle = mutableListOf<String>()
    private val ArtistsName = mutableListOf<String>()
    private val Rating = mutableListOf<Int>()
    private val Comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


     // Initialising of the elements in the UI
        val AddBtn = findViewById<Button>(R.id.AddBtn)
        val playlistBtn = findViewById<Button>(R.id.PlaylistBtn)
        val exitBtn = findViewById<Button>(R.id.ExitBtn)
        val clearBtn= findViewById<Button>(R.id.ClearBtn)

        AddBtn.setOnClickListener {
            //Modules for the function of adding the data into the array
            showList()
        }
        playlistBtn.setOnClickListener {
            /// this is used to push the data entered in the array
            intent = Intent(this, detailedView::class.java)
            intent.putStringArrayListExtra("SongTitle", ArrayList(SongTitle))
            intent.putStringArrayListExtra("ArtistsName", ArrayList(ArtistsName))
            intent.putIntegerArrayListExtra("Rating", ArrayList(Rating))
            intent.putStringArrayListExtra("Comments", ArrayList(Comments))
            startActivity(intent)
        }
        clearBtn.setOnClickListener {
         // this is set to clear the editTexts
            }


        exitBtn.setOnClickListener {

            // to exit the appliction| to finish all activivty of the application to end appliction process
            finishAffinity()
            exitProcess(0)
        }

    }
// funtion to show all data input
    private fun showList() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Enter Details")

        val dialogView = layoutInflater.inflate(R.layout.activity_main, null)
        val dataOne = findViewById<EditText>(R.id.SongTitleEditText)
        val dataTwo = findViewById<EditText>(R.id.ArtistNameEditText)
        val dataThree = findViewById<EditText>(R.id.RatingEditText)
        val dataFour = findViewById<EditText>(R.id.CommentsEditText)

        dialogBuilder.setView(dialogView)
     // to verify all the data inputs

        dialogBuilder.setPositiveButton("Add") { _, _ ->
            val SongTitle = dataOne.text.toString().trim()
            val ArtistsName = dataTwo.text.toString().trim()
            val Rating = dataThree.text.toString().trim()
            val Comments = dataFour.text.toString().trim()


            if (SongTitle.isEmpty() || ArtistsName.isEmpty() || Rating.isEmpty() || Comments.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content),
                    "All required fields must be filled in.",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setPositiveButton
            }

            val dataThree = Rating.toIntOrNull()
            for (i in SongTitle.indices){
            if (dataThree == null || dataThree <= 0) {
                Toast.makeText(getApplicationContext(),"Enter number greater 0",Toast.LENGTH_SHORT).show();
             return@setPositiveButton
            }
                SongTitle.add(dataOne )
                ArtistsName.add(ArtistsName)
                Rating.add(Rating)
                Comments.add(Comments)
            }
            Snackbar.make(findViewById(android.R.id.content), "$SongTitle added to Playlist", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()


         builder.setNegativeButton("Cancel", { dialog, _ ->
             dialog.cancel()
         })

         builder.show()
 }
    }
}




