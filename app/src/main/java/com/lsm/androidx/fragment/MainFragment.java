package com.lsm.androidx.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * @since 2019/4/3 11:32
 */
public class MainFragment extends Fragment {


    private static MainFragment sFragment;

    public static MainFragment newInstance() {
       if (sFragment==null) {
           Bundle args = new Bundle();
           sFragment = new MainFragment();
           sFragment.setArguments(args);
       }

        return sFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.motion_21_main_fragment,container,false);

    }
}
