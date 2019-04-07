package com.lsm.androidx.youtubedemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsm.androidx.R;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/7 13:59
 */
public class YouTubeDemoViewHolder extends RecyclerView.ViewHolder {
    public YouTubeDemoViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static class TextHeaderViewHolder extends YouTubeDemoViewHolder{

        public TextHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class TextDescriptionViewHolder extends YouTubeDemoViewHolder {
        public TextDescriptionViewHolder(View inflate) {
            super(inflate);
        }
    }

    public static class CatRowViewHolder extends YouTubeDemoViewHolder {

        public final ImageView mImageView;
        public final TextView mTextView;

        public CatRowViewHolder(View inflate) {
            super(inflate);
            mImageView = inflate.findViewById(R.id.image_row);
            mTextView = inflate.findViewById(R.id.text_row);

        }
    }
}
