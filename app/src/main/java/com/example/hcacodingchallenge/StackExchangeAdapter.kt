package com.example.hcacodingchallenge
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hcacodingchallenge.api.ApiInterface
import com.example.hcacodingchallenge.models.Item
import com.example.hcacodingchallenge.models.StackExchangeQuestion
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StackExchangeAdapter(val context: Context, val items: List<Item> ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    //private var items: List<StackExchangeQuestion> = ArrayList()

    /**
     * This method tells how many view holder are in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StackExchangeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_stackexchange_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StackExchangeViewHolder ->{
                holder.title_of_stack_question.text = items[position].title.toString()
                holder.author_of_stack_question.text = items[position].owner.display_name.toString()
                holder.answer_to_stack_question.text = items[position].answer_count.toString()
                holder.accepted_answer_to_stack_question.text = items[position].is_answered.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StackExchangeViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        var title_of_stack_question: TextView
        var author_of_stack_question: TextView
        var answer_to_stack_question: TextView
        var accepted_answer_to_stack_question: TextView

        init {
            title_of_stack_question = itemView.findViewById(R.id.stack_exchange_question_view)
            author_of_stack_question = itemView.findViewById(R.id.createdby_view)
            answer_to_stack_question = itemView.findViewById(R.id.answer_view)
            accepted_answer_to_stack_question = itemView.findViewById(R.id.accepted_answer_view)
        }

    }
}