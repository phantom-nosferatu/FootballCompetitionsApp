import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.footballcompetitions.R

class AllCompetitionsAdapter : RecyclerView.Adapter<AllCompetitionsAdapter.AllCompetitionsViewHolder>() {


    class AllCompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCompetitionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.competition_row_item, parent, false)
        return AllCompetitionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllCompetitionsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}