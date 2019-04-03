package com.lsm.androidx.viewPager;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/3 11:23
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

     ArrayList  mFragments=  new ArrayList<Fragment>();
     ArrayList  mStrings=  new ArrayList<String>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    public void addFragment(Fragment fragment,String string){
        mFragments.add(fragment);
        mStrings.add(string);
    }
    public void addPage(String title,int layout){
        Page page = new Page();
        Bundle bundle = new Bundle();
        bundle.putInt("layout",layout);
        page.setArguments(bundle);
        addFragment(page,title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return (Fragment) mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings.get(position).toString();
    }
}
