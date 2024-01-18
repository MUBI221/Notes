import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.FirestoreRecyclerOptions;
import com.example.notes.Note;
import com.example.notes.R;
import com.example.notes.Utility;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note,NoteAdapter.NoteViewHolder> {
Context context;
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options, Context context) {
        super(options);
        this.context = context;
    }
    @SuppressLint("RestrictedApi")
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {
        holder.titleTextView.setText(note.title());
        holder.contentTextView.setText((CharSequence) note.content());
        holder.timestampTextView.setText(Utility.timeStampToString(note.timeStamp()));


    }
@NonNull
@Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);
        return new NoteViewHolder(view);
    }

    public class NoteViewHolder {
        public WindowDecorActionBar.TabImpl titleTextView;
        public WindowDecorActionBar.TabImpl contentTextView;
        public WindowDecorActionBar.TabImpl timestampTextView;

        public NoteViewHolder(View view) {

        }
    }
}
    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView,timestampTextView;
        public  NoteViewHolder(@NonNull View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.note_title_text_view);
            contentTextView = itemView.findViewById(R.id.note_content_text_view);
            timestampTextView = itemView.findViewById(R.id.note_timestamp_text_view);

        }
    }

