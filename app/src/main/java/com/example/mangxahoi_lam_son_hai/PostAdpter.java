package com.example.mangxahoi_lam_son_hai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangxahoi_lam_son_hai.Model.Post;

import java.util.ArrayList;

public class PostAdpter extends RecyclerView.Adapter<PostAdpter.PostViewHolder> {

    private Context context;
    private ArrayList<Post> postList;

    public PostAdpter(Context context, ArrayList<Post> postList){
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.post, parent,false);

        return new PostViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.postAuthor.setText(postList.get(position).getPostAuthor().toString());
        holder.postContent.setText(postList.get(position).getPostContent());

        holder.btnLike.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Animation boundAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
                holder.btnLike.startAnimation(boundAnim);
                ImageView iconLike = (ImageView)holder.iconLike;
                iconLike.setImageResource(R.drawable.ic_like_fill);
                return true;
            }
        });
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "liked", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }


    public static class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView postAuthor;
        public TextView postContent;
        public LinearLayout btnLike;
        public ImageView iconLike;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postAuthor = (TextView) itemView.findViewById(R.id.tv_post_author_name);
            postContent = (TextView) itemView.findViewById(R.id.post_content);

            btnLike = (LinearLayout) itemView.findViewById(R.id.post_like_btn);
            iconLike = (ImageView) itemView.findViewById(R.id.post_icon_like);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
