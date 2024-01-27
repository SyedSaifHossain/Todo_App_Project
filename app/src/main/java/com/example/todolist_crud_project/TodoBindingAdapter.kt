package com.example.todolist_crud_project

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todolist_crud_project.utils.priority_low
import com.example.todolist_crud_project.utils.priority_normal
import getFormattedDateTime
@BindingAdapter("app:setPriorityIcon")
fun setPriorityIcon(imageView : ImageView, priority: String){

    var iconResource = when(priority){
        priority_low -> R.drawable.bluestar
        priority_normal -> R.drawable.greenstar
        else-> R.drawable.redstar
    }
    imageView.setImageResource(iconResource)
}

@BindingAdapter("app:setFormattedDate")
    fun setFormattedDate(textView: TextView, date : Long){
    textView.text = getFormattedDateTime(date,"dd/MM/yyyy")
    }

@BindingAdapter("app:setFormattedTime")
fun setFormattedTime(textView: TextView, time : Long){
    textView.text = getFormattedDateTime(time,"hh:mm a")
}