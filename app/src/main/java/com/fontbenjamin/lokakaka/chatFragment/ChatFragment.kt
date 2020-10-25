package com.fontbenjamin.lokakaka.chatFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fontbenjamin.lokakaka.R
import com.google.firebase.firestore.FirebaseFirestore

class ChatFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_chat, container, false)

    companion object {
        fun newInstance(): ChatFragment = ChatFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print("***************************************")
        getNews()
        print("***************************************")

    }

    private fun getNews() {
        val db = FirebaseFirestore.getInstance()
        db.collection("news")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        
                    }
                } else {
                    // handle error
                    Log.w("ERROR", "Error getting documents.", task.getException());
                }
            }
    }

}