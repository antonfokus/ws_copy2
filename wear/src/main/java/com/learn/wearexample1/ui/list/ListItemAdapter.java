package com.learn.wearexample1.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.wearexample1.R;
import com.learn.wearexample1.model.ListItemModel;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {
    private ArrayList<ListItemModel> items;

    public ListItemAdapter(ArrayList<ListItemModel> items) {
        this.items = items;
    }

    public ListItemAdapter() {
        this(new ArrayList<>());
    }

    public void setItems(ArrayList<ListItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItemModel item = items.get(position);
        holder.mTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.title);
            mImage = itemView.findViewById(R.id.image);
        }
    }
}
