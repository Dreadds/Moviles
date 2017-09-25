package com.dreads.testcatchup.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.dreads.testcatchup.R;
import com.dreads.testcatchup.activities.AboutSourceActivity;
import com.dreads.testcatchup.activities.SourceNewsActivity;
import com.dreads.testcatchup.models.Source;

import java.util.List;

/**
 * Created by Dreads on 25/09/2017.
 */

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.ViewHolder>{
    private List<Source> sources;
    public SourcesAdapter() {
    }

    public SourcesAdapter(List<Source> sources) {
        this.setSources(sources);
    }

    @Override
    public SourcesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_source, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(SourcesAdapter.ViewHolder holder, int position) {
        // TODO: Assign Logo to Widget
        final Source source = sources.get(position);
        holder.nameTextView.setText(source.getName());
        holder.logoANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setImageUrl(source.getUrlToLogo());
        holder.aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Start About Source Activity
                Context context = view.getContext();
                Intent intent = new Intent(context, AboutSourceActivity.class);
                intent.putExtras(source.toBundle());
                context.startActivity(intent);
            }
        });
        holder.newsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Start News Source Activity
                Context context = view.getContext();
                Intent intent = new Intent(context, SourceNewsActivity.class);
                intent.putExtras(source.toBundle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return sources.size();
    }

    public List<Source> getSources() {
        return sources;
    }

    public SourcesAdapter setSources(List<Source> sources) {
        this.sources = sources;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView logoANImageView;
        TextView nameTextView;
        TextView aboutTextView;
        TextView newsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            logoANImageView = (ANImageView) itemView.findViewById(R.id.logoANImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            aboutTextView = (TextView) itemView.findViewById(R.id.aboutTextView);
            newsTextView = (TextView)itemView.findViewById(R.id.newsTextView);
        }
    }
}
