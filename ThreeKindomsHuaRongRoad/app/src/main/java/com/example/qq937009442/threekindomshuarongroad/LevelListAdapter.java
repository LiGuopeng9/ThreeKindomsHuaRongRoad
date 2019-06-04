package com.example.qq937009442.threekindomshuarongroad;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class LevelListAdapter extends
        RecyclerView.Adapter<LevelListAdapter.LevelViewHolder>  {
    private ArrayList<Level> mLevelData;
    private Context mContext;
    public interface OnItemClickListener{
        void onItemClick(View view, final int position);
    }
    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public LevelListAdapter(ArrayList<Level> mLevelData, Context mContext) {
        this.mLevelData = mLevelData;
        this.mContext = mContext;
    }
    @Override
    public LevelListAdapter.LevelViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int i) {
        Log.d("onCreateViewHolder","onCreateViewHolder");
        return new LevelViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.levellist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(LevelListAdapter.LevelViewHolder holder,
                                 final int position) {
        final Level currentLevel = mLevelData.get(position);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,position);
            }
        });
        holder.bindTo(currentLevel);
    }
    @Override
    public int getItemCount() {
        return mLevelData.size();
    }
    class LevelViewHolder extends RecyclerView.ViewHolder {
        private TextView mLevelName;
        private ImageView mlevelImage;
        private CardView mCardView;

        private LevelViewHolder(View itemView) {
            super(itemView);
            mLevelName = itemView.findViewById(R.id.levelName);
            mlevelImage = itemView.findViewById(R.id.levelImage);
            mCardView = itemView.findViewById(R.id.cardview);
        }

        void bindTo(Level currentLevel) {
            mLevelName.setText(currentLevel.getLevelName());
            Glide.with(mContext).load(currentLevel.getImage()).into(mlevelImage);
        }
    }


}
