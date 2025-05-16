package com.example.morningspark;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<TodoItem> todoList;

    public TodoAdapter(List<TodoItem> todoList) {
        this.todoList = todoList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, dateTime;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.todoTitle);
            dateTime = view.findViewById(R.id.todoDateTime);
        }
    }

    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoItem item = todoList.get(position);
        holder.title.setText(item.title);
        holder.dateTime.setText(item.dateTime);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
