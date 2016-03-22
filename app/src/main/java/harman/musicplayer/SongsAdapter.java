package harman.musicplayer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;


public class SongsAdapter extends RecyclerView
        .Adapter<SongsAdapter
        .DataObjectHolder> {

//    private static String TAG = "SongsAdapter";
    private ArrayList<Song> mDataset;
    private static MyClickListener myClickListener;
    private Activity mActivity;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView songTitle;
        TextView songArtist;
        TextView songDuration;

        public DataObjectHolder(View itemView) {
            super(itemView);
            songTitle = (TextView) itemView.findViewById(R.id.song_title);
            songArtist = (TextView) itemView.findViewById(R.id.song_artist);
            songDuration = (TextView) itemView.findViewById(R.id.song_duration);
//            Log.i(TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public SongsAdapter(ArrayList<Song> myDataset, Activity activity) {
        mDataset = myDataset;
        this.mActivity = activity;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
//        Log.v("wtf", "setting category style in adapter");
        holder.songTitle.setText(mDataset.get(position).getTitle());
        holder.songArtist.setText(mDataset.get(position).getArtist());
        holder.songDuration.setText(mDataset.get(position).getDuration());
//        loadImage(mDataset.get(position).getStyleImageUrl(),holder);

    }

    public void addItem(Song dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}