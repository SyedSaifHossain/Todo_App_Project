package com.example.todolist_crud_project

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_crud_project.databinding.TodoListItemBinding
import com.example.todolist_crud_project.entities.TodoModel
import com.example.todolist_crud_project.utils.priority_low
import com.example.todolist_crud_project.utils.priority_normal
import com.example.todolist_crud_project.utils.todo_delete
import com.example.todolist_crud_project.utils.todo_edit
import getFormattedDateTime

class TodoAdaptar(val actionCallback:(TodoModel,String) -> Unit): ListAdapter<TodoModel, TodoAdaptar.TodoViewHolder>(TodoDiffCallback()){

    class TodoViewHolder(private val binding: TodoListItemBinding, val actionCallback:(TodoModel,String)->Unit): RecyclerView.ViewHolder(binding.root){
        fun bind(todoModel : TodoModel){
            binding.todo =todoModel
//            binding.todoText.text = todoModel.name
//            binding.dateText.text = "${getFormattedDateTime(todoModel.date, "dd/MM/yyyy")}"
//            binding.timeText.text = "${getFormattedDateTime(todoModel.time, "hh:mm a")}"
//            binding.checkBox.isChecked = todoModel.isCompleted
//
//            var iconId = when(todoModel.priority){
//                priority_low-> R.drawable.bluestar
//                priority_normal-> R.drawable.greenstar
//                else-> R.drawable.redstar
//            }
//            binding.imageView.setImageResource(iconId)
            binding.checkBox.setOnClickListener{
                actionCallback(todoModel, todo_edit)
            }
            binding.delete.setOnClickListener {

             val popupMenu = PopupMenu(it.context,it)
                val inflater = popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
                popupMenu.show()
                popupMenu.setOnMenuItemClickListener {item->
                    when(item.itemId){

                        R.id.menuItem -> {

                            actionCallback(todoModel, todo_delete)
                            true
                        }
                        else -> false
                    }
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding,actionCallback)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todoModel = getItem(position)
        holder.bind(todoModel)
    }
}

class TodoDiffCallback : DiffUtil.ItemCallback<TodoModel>() {
    override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem == newItem
    }
}