package com.example.alkyeservices
import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeservices.databinding.HorizontalCardBinding
import com.example.alkyeservices.databinding.RandomItemsBinding
import com.example.alkyeservices.databinding.VerticalCardBinding



class RandomAdapter(private val cardDataList: List<CardData>, private val viewType: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HORIZONTAL = 1
        const val VIEW_TYPE_VERTICAL = 2
        const val VIEW_TYPE_THIRD = 3
    }

    inner class HorizontalCardViewHolder(private val binding: RandomItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardData: CardData) {
            binding.imageView5.setImageResource(R.drawable.youtube)
            binding.imageView6.setImageResource(R.drawable.star)
            binding.popularImg.setImageResource(R.drawable.firefly_option_a)


            val topicText = cardData.text2
            val spannableTopic = SpannableString(topicText)

            // Find the index of "Step Into Tomorrow:" in the topic text
            val startIndex = topicText.indexOf("Step Into Tomorrow:")
            val endIndex = startIndex + "Step Into Tomorrow:".length

            // Apply bold style to the substring "Step Into Tomorrow:"
            spannableTopic.setSpan(StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            binding.topic.text = cardData.text1
            binding.longTxt.text = spannableTopic
            binding.dateYear.text = cardData.text3
        }
    }

    inner class VerticalCardViewHolder(private val binding: VerticalCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardData: CardData) {
            binding.image60.setImageResource(R.drawable.firefly_crop)
            binding.imageView61.setImageResource(R.drawable.youtube)

            val categoryText = cardData.text2
            val spannableCategory = SpannableString(categoryText)

            // Find the index of "Step Into Tomorrow:" in the category text
            val startIndex = categoryText.indexOf("Step Into Tomorrow:")
            val endIndex = startIndex + "Step Into Tomorrow:".length

            // Apply bold style to the substring "Step Into Tomorrow:"
            spannableCategory.setSpan(StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            binding.category.text = cardData.text1
            binding.title.text = spannableCategory
            binding.date.text = cardData.text3
        }
    }

    inner class ThirdCardViewHolder(private val binding: HorizontalCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardData: CardData) {
            binding.imageView5.setImageResource(R.drawable.insta)
            binding.imgCrop.setImageResource(R.drawable.firefly_crop2)
            binding.caption.text = cardData.text1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_VERTICAL -> {
                val binding = VerticalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                VerticalCardViewHolder(binding)
            }
            VIEW_TYPE_THIRD -> {
                val binding = HorizontalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ThirdCardViewHolder(binding)
            }
            else -> {
                val binding = RandomItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HorizontalCardViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cardData = cardDataList[position]
        when (holder) {
            is HorizontalCardViewHolder -> holder.bind(cardData)
            is VerticalCardViewHolder -> holder.bind(cardData)
            is ThirdCardViewHolder -> holder.bind(cardData)
        }
    }

    override fun getItemCount(): Int {
        return cardDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }
}

