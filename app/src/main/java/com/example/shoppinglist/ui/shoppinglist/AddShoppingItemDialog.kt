package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.androiddevs.grocerylist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tv_Add.setOnClickListener {
            val name = et_Name.text.toString()
            val amount = et_Amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "please enter all the information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            var item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tv_Cancel.setOnClickListener {
            cancel()
        }
    }

}