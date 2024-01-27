package com.example.todolist_crud_project.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.todolist_crud_project.R

class TodoDeleteFragment(val callback: () ->Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
            builder.setTitle("Delete")
            builder.setMessage("Are you sure to delete this item")
            builder.setIcon(R.drawable.baseline_delete_forever_24)
        builder.setPositiveButton("Yes") { dialog, which ->
            callback()
        }
        builder.setNegativeButton("Cancle", null)
        return builder.create()
    }
}