package com.lsm.androidx.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.L;
import com.lsm.androidx.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/7 11:43
 */
public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;


    private static ListFragment sFragment;

    public static ListFragment newInstance() {
        if (sFragment==null) {
            Bundle args = new Bundle();
            sFragment = new ListFragment();
            sFragment.setArguments(args);
        }

        return sFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.motion_22_list_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("shiming","好好学习"));
        users.add(new User("tongxue","好好学习"));
        users.add(new User("Jane","好好学习"));
        users.add(new User("John","好好学习"));
        users.add(new User("Amy","好好学习"));
        users.add(new User("Paul","好好学习"));
        users.add(new User("Jane","好好学习"));
        users.add(new User("John","好好学习"));
        users.add(new User("Amy","好好学习"));
        users.add(new User("John","好好学习"));
        users.add(new User("tongxue","好好学习"));
        users.add(new User("Amy","好好学习"));
        users.add(new User("tongxue","好好学习"));
        CustomAdapter customAdapter = new CustomAdapter(users);

        mRecyclerView.setAdapter(customAdapter);
    }
}
