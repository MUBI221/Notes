package com.example.notes;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationChannelCompat;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter {
    public NoteAdapter(NotificationChannelCompat options, MainActivity mainActivity) {

    }

    public void startListening() {
    }

    public void stopListening() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
