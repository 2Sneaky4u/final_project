package com.example.runanalyser.databasestuff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.R;

import java.util.List;

public class GameAdapter extends ListAdapter<Game, GameAdapter.GameViewHolder> {

    private List<Game> games;
    private Context context;
    private OnGameClickListener onGameClickListener;

    public GameAdapter(List<Game> games, Context context, OnGameClickListener ouscl) {
        super(new DiffUtil.ItemCallback<Game>() {
            @Override
            public boolean areItemsTheSame(@NonNull Game oldItem, @NonNull Game newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Game oldItem, @NonNull Game newItem) {
                return oldItem.id == newItem.id && oldItem.name.equals(newItem.name);
            }
        });
        this.games = games;
        this.context = context;
        this.onGameClickListener = ouscl;
    }


    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        GameViewHolder gameViewHolder = new GameViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPos = gameViewHolder.getAdapterPosition();
                Game tempgame = games.get(adapterPos);
                String Gamestring = tempgame.name;
                onGameClickListener.onGameClick(tempgame);
            }
        });

        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.nameView.setText(games.get(position).name);
        holder.reviewView.setText(String.valueOf(games.get(position).review));
        holder.ratingView.setText(games.get(position).rating +"/10");
        holder.genreView.setText(String.valueOf(games.get(position).genre));
        holder.statusView.setText(games.get(position).completion+"%");
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setGames(List<Game> games) {
        this.games = games;
        submitList(games);
    }

    public void setOnGameClickListener(OnGameClickListener onGameClickListener) {
        this.onGameClickListener = onGameClickListener;
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView ratingView;
        TextView statusView;
        TextView genreView;
        TextView reviewView;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);


            nameView = itemView.findViewById(R.id.gameName);
            ratingView = itemView.findViewById(R.id.gameRating);
            statusView = itemView.findViewById(R.id.gameCompletion);
            genreView = itemView.findViewById(R.id.gameGenre);
            reviewView = itemView.findViewById(R.id.gameReview);
        }
    }

    public interface OnGameClickListener {
        void onGameClick(Game game);
    }
}
