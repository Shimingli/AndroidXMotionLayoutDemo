package com.lsm.androidx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/1 14:01
 */
public class DemosAdapter extends RecyclerView.Adapter<DemosAdapter.ViewHolder> {


    private final ArrayList<AdapterItemBean> mAdapterItemBeans;

    public DemosAdapter(ArrayList<AdapterItemBean> adapterItemBeans) {
        mAdapterItemBeans = adapterItemBeans;
    }

    @NonNull
    @Override
    public DemosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemosAdapter.ViewHolder holder, int position) {
        AdapterItemBean adapterItemBean = mAdapterItemBeans.get(position);
        holder.layoutFileId=adapterItemBean.getLayoutID();
        holder.mTitle.setText(adapterItemBean.getTitle());
        holder.mDescription.setText(adapterItemBean.getDes());
        holder.clazz=adapterItemBean.getClazz();
    }

    @Override
    public int getItemCount() {
        return mAdapterItemBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mTitle;
        private final TextView mDescription;
        int layoutFileId = 0;
        Class clazz;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     if (v.getContext() instanceof MainActivity){
                         ((MainActivity)v.getContext()).start(clazz,layoutFileId);
                     }
                }
            });
        }
    }

}
