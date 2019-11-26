package fr.purplegiraffe.recyclerdemob2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cell_player.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = PlayerListAdapter()
    }

    inner class PlayerListAdapter : RecyclerView.Adapter<PlayerListAdapter.PlayerCellHolder>() {
        val playerList = listOf(
            Player("Bob", 868),
            Player("John", 468),
            Player("Doe", 43),
            Player("Bob", 868),
            Player("Bob", 868),
            Player("Bob", 868),
            Player("Bob", 868),
            Player("Bob", 868),
            Player("Bob", 868)
        )

        inner class PlayerCellHolder(view:View) : RecyclerView.ViewHolder(view) {
            val scoreLabel = view.lbl_playerScore
            val nameLabel = view.lbl_playerName

            fun displayerPlayer(player: Player) {
                nameLabel.text = player.name
                scoreLabel.text = "Score ${player.score}"
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerCellHolder {
            Log.i("BRITTO", "onCreateViewHolder")
            // 1 creer la vue avec mise en page
            val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_player, parent, false)

            // 2 créer un holder associé à la vue
            val holder = PlayerCellHolder(view)

            // 3 retourner le holder
            return holder
        }

        override fun getItemCount(): Int {
            return 9
        }

        override fun onBindViewHolder(holder: PlayerCellHolder, position: Int) {
            Log.i("BRITTO", "onBindViewHolder $position")
            // 1 charger le player 'position'
            val myPlayer = Player(playerList[position].name, playerList[position].score)

            // 2 envoyer le player dans le holder
            holder.displayerPlayer(myPlayer)
        }
    }
}
