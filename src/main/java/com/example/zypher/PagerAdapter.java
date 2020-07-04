package com.example.zypher;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Fragment> fragmentList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
