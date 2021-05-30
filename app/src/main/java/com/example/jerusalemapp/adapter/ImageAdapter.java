package com.example.jerusalemapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jerusalemapp.R;
import com.example.jerusalemapp.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHodlerImage> {
    Context context;
    List<Image> ImageList;

    public ImageAdapter(Context context, List<Image> ImageList) {
        this.context = context;
        this.ImageList = ImageList;
    }

    @NonNull
    @Override
    public ViewHodlerImage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHodlerImage(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodlerImage holder, int position) {
        Image image= ImageList.get(position);

        Picasso.get().load(image.getUrl_image()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return ImageList.size();
    }

    public class ViewHodlerImage extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHodlerImage(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_image);

        }
    }
}
