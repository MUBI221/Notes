import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.notes.FirestoreRecyclerOptions;
import com.example.notes.Note;

public abstract class FirestoreRecyclerAdapter<T, T1> {
    public FirestoreRecyclerAdapter(FirestoreRecyclerOptions<Note> options) {
    }

    @NonNull
    public abstract NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
}
