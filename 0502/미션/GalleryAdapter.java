package com.example.roffjfl;



import android.content.Context;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private List<GalleryItem> itemList;
    private Context context;

    public GalleryAdapter(Context context, List<GalleryItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.galleryImage);
            titleView = view.findViewById(R.id.galleryTitle);
        }
    }

    @NonNull
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.ViewHolder holder, int position) {
        GalleryItem item = itemList.get(position);
        holder.imageView.setImageResource(item.imageResId);
        holder.titleView.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
