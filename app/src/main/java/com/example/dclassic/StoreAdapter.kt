package com.example.dclassic
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
class StoreAdapter(
    private val images: List<Int>
) : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    class ViewHolder(val image: ImageView)
        : RecyclerView.ViewHolder(image)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val image = ImageView(parent.context)

        image.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        image.scaleType = ImageView.ScaleType.CENTER_CROP

        return ViewHolder(image)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount() = images.size
}