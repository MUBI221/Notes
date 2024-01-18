package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addNoteBtn;
    RecyclerView recyclerView;
    ImageButton menuBtn;

//    NoteAdepter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNoteBtn = findViewById(R.id.add_note_btn);
        recyclerView = findViewById(R.id.recyler_view);
        menuBtn = findViewById(R.id.menu_Btn);
        addNoteBtn.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, NoteDetailsActivity.class);
            startActivity(intent);
        });
        menuBtn.setOnClickListener(v ->showMenu());
        setupRecyclerView();
    }
    public void showMenu(){

    }

    public void setupRecyclerView(){
//
//        Query query = Utility.getcollectionReferenceForNotes().orderBy("timeStamp", Query.Direction.DESCENDING); //Query
//        NotificationChannelCompat options = new FirestoreRecyclerOptions.Builder<Note>().setQuery(query, Note.class).build();
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        noteAdapter noteAdepter = new NoteAdepter(options, this);
//        recyclerView.setAdapter(noteAdepter);

    }

}