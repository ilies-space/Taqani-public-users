package com.android.taqani.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.android.taqani.R;
import com.android.taqani.tabscontent.current;
import com.android.taqani.tabscontent.denied;
import com.android.taqani.tabscontent.past;
import com.android.taqani.ui.dashboard.DashboardFragment;
import com.android.taqani.ui.liked.liked;
import com.android.taqani.ui.notifications.NotificationsFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("الملغية"));
        tabLayout.addTab(tabLayout.newTab().setText("السابقة"));
        tabLayout.addTab(tabLayout.newTab().setText("الحالية"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager =(ViewPager) root.findViewById(R.id.view_pager);

        TabsAdapter tabsAdapter = new TabsAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.setCurrentItem(2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }





    public class TabsAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;
        public TabsAdapter(FragmentManager fm, int NoofTabs){
            super(fm);
            this.mNumOfTabs = NoofTabs;
        }
        @Override
        public int getCount() {
            return mNumOfTabs;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    denied denied = new denied();
                    return denied;
                case 1:
                    past past = new past();
                    return past;
                case 2:
                    current current = new current();
                    return current;
                default:
                    return null;
            }
        }
    }

}