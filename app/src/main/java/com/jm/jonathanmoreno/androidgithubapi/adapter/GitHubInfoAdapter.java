package com.jm.jonathanmoreno.androidgithubapi.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jm.jonathanmoreno.androidgithubapi.R;
import com.jm.jonathanmoreno.androidgithubapi.activities.DetailsActivity;
import com.jm.jonathanmoreno.androidgithubapi.model.GitHubInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GitHubInfoAdapter extends RecyclerView.Adapter<GitHubInfoAdapter.GitHubInfoViewHolder>{


    private final static int FADE_DURATION = 1000;
    private Context context;
    private List<GitHubInfo> gitHubData;

    public GitHubInfoAdapter(Context context, List<GitHubInfo> list){
        this.context = context;
        this.gitHubData = list;
    }

    @Override
    public GitHubInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View view;
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        view = layoutInflater.inflate(R.layout.item_row ,parent, false);
//        return new GitHubInfoViewHolder(view);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item_row ,parent, false);
        final GitHubInfoViewHolder viewHolder = new GitHubInfoViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, DetailsActivity.class);

                i.putExtra("github_name", gitHubData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("github_description",gitHubData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("github_language",gitHubData.get(viewHolder.getAdapterPosition()).getLanguage());
                i.putExtra("github_update",gitHubData.get(viewHolder.getAdapterPosition()).getUpdated());


                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, (View) view, "author_image");


                context.startActivity(i, options.toBundle());

            }
        });

        return viewHolder;





    }

    @Override
    public  void onBindViewHolder(GitHubInfoViewHolder holder, final int position){
        GitHubInfo gitHubInfoQuotes = gitHubData.get(position);
        holder.nameTextView.setText(gitHubInfoQuotes.getName());
        holder.descriptionTextView.setText(gitHubInfoQuotes.getDescription());


       setScaleAnimation(holder.itemView);


    }

    @Override
    public int getItemCount(){
        return gitHubData.size();
    }

    public static class GitHubInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nametext)
        TextView nameTextView;
        @BindView(R.id.descriptiontext)
        TextView descriptionTextView;

        RelativeLayout view_container;



        public GitHubInfoViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            view_container = itemView.findViewById(R.id.container);
        }



    }


    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }


}

