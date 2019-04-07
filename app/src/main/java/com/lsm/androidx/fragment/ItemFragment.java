package com.lsm.androidx.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lsm.androidx.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/7 12:02
 */
public class ItemFragment extends Fragment {

    private static ItemFragment itemFragment;
    private CustomAdapter.ViewHolder mHolder;
    private View mView;
    private View mContainer;

    public static ItemFragment getInstance() {
        if (itemFragment==null){
            itemFragment  = new ItemFragment();
        }
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView = view;
        System.out.println("shiming onViewCreated"+mView);
        mContainer = mView.findViewById(R.id.container);
    }

    /**
     * getView 永远为null,是由于那边的没有使用正确
     * @param holder
     */
    public void update(CustomAdapter.ViewHolder holder) {
        mHolder = holder;
        TextView title = mView.findViewById(R.id.txtTitle);
        title.setText(holder.mTxtTitle.getText());
        title.setTextColor(getActivity().getResources().getColor(R.color.clr_FF6600));
        mContainer.setBackgroundColor(getActivity().getResources().getColor(R.color.clr_FBFF00));
        System.out.println("shiming update="+holder.mTxtTitle.getText());
        TextView txtName = mView.findViewById(R.id.txtName);
        txtName.setText(holder.mTxtName.getText());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mHolder!=null){
            update(mHolder);
        }

    }
}
