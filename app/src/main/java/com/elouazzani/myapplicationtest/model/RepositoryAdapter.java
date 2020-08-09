package com.elouazzani.myapplicationtest.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.elouazzani.myapplicationtest.R;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
    Context context;
    private List<Repository> repList;

    public RepositoryAdapter(Context context, List<Repository> repList) {
        this.context=context;
        this.repList=repList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView repNameText, repDescriptionText, usernameText, nbrStarsText;
        ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            repNameText=itemView.findViewById(R.id.repNameText);
            repDescriptionText=itemView.findViewById(R.id.repDescriptionText);
            usernameText=itemView.findViewById(R.id.usernameText);
            nbrStarsText=itemView.findViewById(R.id.numberOfStarsText);
            avatar=itemView.findViewById(R.id.avatar);

        }
    }

    @NonNull
    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_trending_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryAdapter.ViewHolder holder, int position) {
        final Repository repository= repList.get(position);

        if (repository!=null) {
            holder.repNameText.setText(repository.getRepName());
            holder.repDescriptionText.setText(repository.getRepDescription());
            holder.usernameText.setText(repository.getUsername());
            holder.nbrStarsText.setText(String.format("%.1f",repository.getNumbersOfStars()));
            Glide.with(context).load(repository.getAvatarUrl()).into(holder.avatar);


        }

    }

    @Override
    public int getItemCount() {
        return repList.size();
    }


}
