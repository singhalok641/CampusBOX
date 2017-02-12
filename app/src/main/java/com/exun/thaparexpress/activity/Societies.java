package com.exun.thaparexpress.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.exun.thaparexpress.R;
import com.exun.thaparexpress.adapter.SlidingTabLayout;
import com.exun.thaparexpress.adapter.ViewPagerAdapterSocieties;

public class Societies extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener
 {

    // Declaring Your View and Variables

    Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    ViewPager pager;
    ViewPagerAdapterSocieties adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"Cultural", "Student Chapters", "Technical"};
    int Numboftabs = 3;
    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_societies);

        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);


        // Creating The ViewPagerAdapterSocieties and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapterSocieties(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Intent i = new Intent(Societies.this,MainActivity.class);
        switch (position) {
            case 0:
                i.putExtra("selectionId", 0);
                startActivity(i);
                finish();
                break;
            case 1:
                break;
            case 3:
                i.putExtra("selectionId", 3);
                startActivity(i);
                finish();
                break;
            case 4:
                i.putExtra("selectionId", 4);
                startActivity(i);
                finish();
                break;
            case 5:
                i.putExtra("selectionId", 5);
                startActivity(i);
                finish();
                break;
            case 6:
                i.putExtra("selectionId", 6);
                startActivity(i);
                finish();
                break;
            case 7:
                Toast.makeText(getApplicationContext(), "Coming soon :D", Toast.LENGTH_SHORT).show();
                break;
            case 8:
                i.putExtra("selectionId", 8);
                startActivity(i);
                finish();
                break;
            case 9:
                i.putExtra("selectionId", 9);
                startActivity(i);
                finish();
                break;
            case 10:
                i.putExtra("selectionId", 10);
                startActivity(i);
                finish();
                break;
            default:
                i.putExtra("selectionId", 0);
                startActivity(i);
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Societies.this,MainActivity.class);
        i.putExtra("selectionId",0);
        startActivity(i);
        finish();

    }

    }


