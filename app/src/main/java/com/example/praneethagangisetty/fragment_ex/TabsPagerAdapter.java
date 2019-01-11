package com.example.praneethagangisetty.fragment_ex;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    Context c;
    public TabsPagerAdapter(FragmentManager fm,Context c) {
        super(fm);
        this.c=c;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Log.v(c.getClass().getSimpleName(),"comments");
                return new CommentsFragment();
            case 1:
                Log.v(c.getClass().getSimpleName(),"tab");
                return new TabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
