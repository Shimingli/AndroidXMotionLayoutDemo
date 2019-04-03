package com.lsm.androidx.viewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

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
public class Page extends Fragment {

    private int mLayout;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        //获取布局的id
        if (args!=null){
            mLayout = args.getInt("layout");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(mLayout,container,false);

    }
}
