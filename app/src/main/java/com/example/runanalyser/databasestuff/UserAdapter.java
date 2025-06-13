package com.example.runanalyser.databasestuff;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.Globals;
import com.example.runanalyser.R;

import java.util.List;

public class UserAdapter extends ListAdapter<User, UserAdapter.UserViewHolder> {
    private List<User> users;
    private Context context;
    private UserAdapter.OnUserClickListener onUserClickListener;

    public UserAdapter(List<User> users, Context context, UserAdapter.OnUserClickListener ouscl) {
        super(new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.id == newItem.id && oldItem.username.equals(newItem.username);
            }
        });
        this.users = users;
        this.context = context;
        this.onUserClickListener = ouscl;
    }


    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        UserAdapter.UserViewHolder userViewHolder = new UserAdapter.UserViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPos = userViewHolder.getAdapterPosition();
                User tempuser = users.get(adapterPos);
                String Userstring = tempuser.username;
                onUserClickListener.onUserClick(tempuser);
            }
        });

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        UserDao userDao = AppDatabase.getDatabase(context).userDao();
        FollowerDao followerDao = AppDatabase.getDatabase(context).followerDao();

        User user = users.get(position);
        holder.nameView.setText(user.username);
        holder.phoneView.setText(user.phonenumber);
        holder.bioView.setText(user.description);
        new Thread(() -> {
            Double avgRating = userDao.getAvgReviewFromAUser(user.id);
            int gameCount = userDao.countConnectedGamesToUserById(user.id);

            holder.itemView.post(() -> {
                holder.ratingView.setText(String.valueOf(avgRating));
                holder.gamesView.setText(String.valueOf(gameCount));
            });
        }).start();
        if (user.pfpURI != null) holder.pfpView.setImageURI(Uri.parse(user.pfpURI));

        if (user.id != Globals.getCurUser().id) {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("--> Entered edit thread");
                    boolean isFollowing = followerDao.getFollowItemByIds(Globals.getCurUser().id, user.id) != null;
                    boolean isFollowed = followerDao.getFollowItemByIds(user.id, Globals.getCurUser().id) != null;
                    System.out.println("--> got follow info");
                    ((Activity) context).runOnUiThread(() -> {
                        System.out.println("--> entered UI thread");
                        updateButtonStates(user, holder, isFollowing, isFollowed);
                        System.out.println("--> Finished UI thread");
                    });
                }
            };

            AppDatabase.dtbWriteExecutor.execute(runnable);

            holder.followbtn.setOnClickListener(view -> AppDatabase.dtbWriteExecutor.execute(() -> {
                Follower follower = new Follower(Globals.getCurUser().id, user.id);
                followerDao.insertFollower(follower);
                System.out.println("--> added follow");
                AppDatabase.dtbWriteExecutor.execute(runnable);
            }));
            holder.unfollowbtn.setOnClickListener(view -> AppDatabase.dtbWriteExecutor.execute(() -> {
                Follower follower = followerDao.getFollowItemByIds(Globals.getCurUser().id, user.id);
                followerDao.delFollower(follower);
                System.out.println("--> added follow");
                AppDatabase.dtbWriteExecutor.execute(runnable);

            }));
        } else {
            holder.followbtn.setClickable(false);
            holder.followbtn.setVisibility(View.INVISIBLE);
            holder.followbtn.setActivated(false);
            holder.unfollowbtn.setClickable(false);
            holder.unfollowbtn.setVisibility(View.INVISIBLE);
            holder.unfollowbtn.setActivated(false);
        }
    }

    private void updateButtonStates(User user, UserAdapter.UserViewHolder holder, boolean isFollowing, boolean isFollowed) {
        holder.followbtn.setVisibility(isFollowing ? View.INVISIBLE : View.VISIBLE);
        holder.unfollowbtn.setVisibility(isFollowing ? View.VISIBLE : View.INVISIBLE);

        holder.followbtn.setClickable(!isFollowing);
        holder.unfollowbtn.setClickable(isFollowing);

        if (isFollowing && isFollowed) {
            holder.nameView.setText(user.username + " ᐧ Friend");
        } else if (isFollowing) {
            holder.nameView.setText(user.username + " ᐧ Following");
        } else {
            holder.nameView.setText(user.username);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        submitList(users);
    }

    public void setOnUserClickListener(UserAdapter.OnUserClickListener onUserClickListener) {
        this.onUserClickListener = onUserClickListener;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView ratingView;
        TextView gamesView;
        TextView phoneView;
        TextView bioView;
        ImageView pfpView;
        ImageView followbtn;
        ImageView unfollowbtn;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);


            nameView = itemView.findViewById(R.id.userrc_username);
            ratingView = itemView.findViewById(R.id.userrc_ratings);
            gamesView = itemView.findViewById(R.id.userrc_games);
            phoneView = itemView.findViewById(R.id.userrc_phone);
            bioView = itemView.findViewById(R.id.userrc_bio);
            pfpView = itemView.findViewById(R.id.user_rc_pfp);
            followbtn = itemView.findViewById(R.id.followBtn);
            unfollowbtn = itemView.findViewById(R.id.unfollowBtn);
        }
    }

    public interface OnUserClickListener {
        void onUserClick(User user);
    }
}
