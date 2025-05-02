package com.example.roffjfl;




import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private List<GalleryItem> galleryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.galleryRecyclerView);

        // 수평 방향 레이아웃 매니저 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        galleryItems = new ArrayList<>();
        galleryItems.add(new GalleryItem("", R.drawable.i));
        galleryItems.add(new GalleryItem("", R.drawable.images));
        galleryItems.add(new GalleryItem("", R.drawable.a));
        galleryItems.add(new GalleryItem("", R.drawable.s));

        adapter = new GalleryAdapter(this, galleryItems);
        recyclerView.setAdapter(adapter);
    }
}
