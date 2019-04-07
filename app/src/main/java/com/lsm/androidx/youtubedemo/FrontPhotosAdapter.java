package com.lsm.androidx.youtubedemo;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.lsm.androidx.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/7 13:58
 */
public class FrontPhotosAdapter extends RecyclerView.Adapter<YouTubeDemoViewHolder> {
    @NonNull
    @Override
    public YouTubeDemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        View inflate = null;
        switch (viewType) {
            case 0:
                inflate = from.inflate(R.layout.motion_24_recyclerview_expanded_text_header,
                        parent, false);
                return new YouTubeDemoViewHolder.TextHeaderViewHolder(inflate);
            case 1:
                inflate = from.inflate(R.layout.motion_24_recyclerview_expanded_text_description,
                        parent, false);
                return new YouTubeDemoViewHolder.TextDescriptionViewHolder(inflate);
            case 2:
                inflate = from.inflate(R.layout.motion_24_recyclerview_expanded_row,
                        parent, false);
                return new YouTubeDemoViewHolder.CatRowViewHolder(inflate);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull YouTubeDemoViewHolder holder, int position) {
        if (holder instanceof YouTubeDemoViewHolder.TextHeaderViewHolder) {

        } else if (holder instanceof YouTubeDemoViewHolder.TextDescriptionViewHolder) {

        } else if (holder instanceof YouTubeDemoViewHolder.CatRowViewHolder) {
            String string =
                    ((YouTubeDemoViewHolder.CatRowViewHolder) holder).mTextView.getResources().getString(R.string.cat, position - 2);

            ((YouTubeDemoViewHolder.CatRowViewHolder) holder).mTextView.setText(string);
            Glide.with(((YouTubeDemoViewHolder.CatRowViewHolder) holder).mImageView)
                    .load(Cats.datas.get(position - 2))
                    .into(((YouTubeDemoViewHolder.CatRowViewHolder) holder).mImageView);

        }
    }

    @Override
    public int getItemCount() {
        return Cats.datas.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:

                return 0;

            case 1:

                return 1;
        }
        return 2;
    }
}
