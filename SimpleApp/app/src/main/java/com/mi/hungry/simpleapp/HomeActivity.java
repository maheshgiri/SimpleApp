package com.mi.hungry.simpleapp;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.appevents.AppEventsLogger;
/**
 * Created by Hungry on 11/9/2015.
 * Home activity viewpager declared
 */
public class HomeActivity extends AppCompatActivity {
ViewPager pagesToShow;
PagerTitleStrip pagerTitleStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         pagerTitleStrip=(PagerTitleStrip)findViewById(R.id.titlePageTab);
        pagesToShow=(ViewPager)findViewById(R.id.pages);
        pagesToShow.setAdapter(new PagesSlideAdapor(getSupportFragmentManager()));

    }


    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

//viewpager adaptor for setting pages
    private class PagesSlideAdapor extends FragmentStatePagerAdapter {

        String [] titleNamePages={"Profile","Location"};

        public PagesSlideAdapor(android.support.v4.app.FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                  ProfileFragment profileFragment=  new ProfileFragment();
                    return profileFragment;
                case 1:
                  return new LocationFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
          return titleNamePages[position];
        }
    }
}
