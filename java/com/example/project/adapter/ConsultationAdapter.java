package com.example.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.model.Consultation;

import java.util.List;

public class ConsultationAdapter  extends RecyclerView.Adapter<ConsultationAdapter.ViewHolder> {

    /**
     * Create ViewHolder class to bind list item view
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

        public TextView tvId;
        public TextView tvTime;
        public TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);

            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            currentPos = getAdapterPosition(); //key point, record the position here
            return false;
        }
    }

    private List<Consultation> mListData;   // list of book objects
    private Context mContext;       // activity context
    private int currentPos; //current selected position.

    public ConsultationAdapter(Context context, List<Consultation> listData){
        mListData = listData;
        mContext = context;
    }

    private Context getmContext(){return mContext;}


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the single item layout
        View view = inflater.inflate(R.layout.consultation_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // bind data to the view holder
        Consultation m = mListData.get(position);
        holder.tvId.setText(m.getConID());
        holder.tvTime.setText(m.getConTime());
        holder.tvDescription.setText(m.getConDesc());
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public Consultation getSelectedItem() {
        if(currentPos>=0 && mListData!=null && currentPos<mListData.size()) {
            return mListData.get(currentPos);
        }
        return null;
    }
}
