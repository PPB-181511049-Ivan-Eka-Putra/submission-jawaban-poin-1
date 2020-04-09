package com.example.aplikasiuntukuts.data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiuntukuts.R;

public class CheeseListAdapter extends RecyclerView.Adapter<CheeseListAdapter.CheeseViewHolder> {

    @NonNull
    @Override
    public CheeseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CheeseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CheeseViewHolder holder, int position) {
        if (mCheeses != null) {
            String cheeseItemName = mCheeses.getString(mCheeses.getColumnIndex(String.valueOf(position)));
            holder.cheeseItemView.setText(cheeseItemName);
        } else {
            // Covers the case of data not being ready yet.
            holder.cheeseItemView.setText("No Cheese");
        }
    }

    @Override
    public int getItemCount() {
        if (mCheeses != null)
            return mCheeses.getCount();
        else return 0;
    }

    class CheeseViewHolder extends RecyclerView.ViewHolder{
        private final TextView cheeseItemView;

        private CheeseViewHolder(View itemView) {
            super(itemView);
            cheeseItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private Cursor mCheeses; // Cached copy of words

    CheeseListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    void setCheeses(Cursor cheeses){
        mCheeses = cheeses;
        notifyDataSetChanged();
    }
}
