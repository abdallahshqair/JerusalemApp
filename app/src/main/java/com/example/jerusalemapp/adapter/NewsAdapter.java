package com.example.jerusalemapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jerusalemapp.R;
import com.example.jerusalemapp.model.News;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    Context context;
    List<News.Data> dataList;

    public NewsAdapter(Context context, List<News.Data>dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News.Data data=dataList.get(position);
        holder.author.setText(data.getAuthor());
        holder.description.setText(data.getDescription());
        Picasso.get().load(data.getUrlToImage()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView author,description;
        ImageView imageView;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            description=itemView.findViewById(R.id.description);
            author=itemView.findViewById(R.id.author);
            imageView=itemView.findViewById(R.id.image12);

        }
    }
}
