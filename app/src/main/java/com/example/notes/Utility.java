package com.example.notes;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.SimpleDateFormat;

public class Utility {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static CollectionReference getcollectionReferenceForNotes() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("Notes").document(currentUser.getUid()).collection("My Collection");
    }

    public static String timeStampToString(Timestamp timestamp) {
      return   new SimpleDateFormat("dd/MM/yyyy").format(timestamp.toDate());
    }

    public static Query getCollectionReferenceForNotes() {
        return null;
    }

};


