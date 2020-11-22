package com.example.projectproto_1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int noOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NoOfTabs) {
        super(fm);
        this.noOfTabs = NoOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new fragment_Student_signUp();
        } else if (position == 1) {
            fragment = new fragment_Staff_Signup();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}


