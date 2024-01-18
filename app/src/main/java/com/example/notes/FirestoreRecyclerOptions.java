package com.example.notes;

import androidx.core.app.NotificationChannelCompat;

import com.google.firebase.database.Query;

public class FirestoreRecyclerOptions<T> {
    public static class Builder<T> {
        public NotificationChannelCompat.Builder setQuery(Query query, Class<Note> noteClass) {

            return null;
        }
    }
}
