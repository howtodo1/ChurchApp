package com.example.test;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.test.ui.dashboard.DashboardFragment;
import com.example.test.ui.give.GiveFragment;
import com.example.test.ui.home.HomeFragment;
import com.example.test.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.Button;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.test.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static MainActivity instance;

    private FragmentManager fragmentManager = getSupportFragmentManager();

    // Add a method to switch to another fragment


    @Override
    @Deprecated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Insideeeeeeeeeeeee on Create");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navView.setOnItemSelectedListener(item -> {
            /*
            Fragment fragment;
            FragmentManager fm;
            WebView webView;
            WebSettings webSettings;
            FragmentTransaction transaction;

             */
            WebView webView = (WebView) findViewById(R.id.prayer);
            WebSettings webSettings;
            switch ( item.getItemId()) {
                case R.id.navigation_dashboard:
                    webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://stthomas-svale.org/sermons/");

                    break;
                case R.id.navigation_notifications:
                    /*
                    fragment = new NotificationsFragment();
                    fm = getSupportFragmentManager();
                    transaction = fm.beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, fragment);
                    transaction.commit();

                     */
                    webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://stthomas-svale.org/calendar/");

                    break;
                case R.id.navigation_home:
                    /*
                    fragment = new HomeFragment();
                    fm = getSupportFragmentManager();
                    transaction = fm.beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, fragment);
                    transaction.commit();

                    webView = (WebView) findViewById(R.id.prayer);
                    webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://stthomas-svale.org/worship-schedule/");

                     */
                    webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://stthomas-svale.org/worship-schedule/");
                    break;
                case R.id.navigation_give:
                    /*
                    fragment = new GiveFragment();
                    fm = getSupportFragmentManager();
                    transaction = fm.beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, fragment);
                    transaction.commit();

                    webView = (WebView) findViewById(R.id.give);
                    while (webView == null){
                        Thread.sleep(1000);
                        webView = (WebView) findViewById(R.id.give);
                    }
                    webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://stthomas-svale.org/give/");
                    break;

                     */
                    webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.loadUrl("https://stthomas-svale.org/give/");
            }
            return true;

        });
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
        getSupportActionBar().hide();
        reLoadUrl();
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        //navView.setOnItemSelectedListener(MainActivity::onNavigationItemSelected);
        //navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_give)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/
        //reLoadUrl();
    }
    public void reLoadUrl() {
        WebView webView1 = (WebView) findViewById(R.id.prayer);
        WebView webView2 = (WebView) findViewById(R.id.sermons);
        WebView webView3 = (WebView) findViewById(R.id.events);
        WebView webView4 = (WebView) findViewById(R.id.give);
        if (webView1 != null) { // Check if WebView1 is not null
            WebSettings webSettings1 = webView1.getSettings();
            webSettings1.setJavaScriptEnabled(true);
            webView1.loadUrl("https://stthomas-svale.org/worship-schedule/");
        }

// Initialize and load WebView2
        if (webView2 != null) { // Check if WebView2 is not null
            WebSettings webSettings2 = webView2.getSettings();
            webSettings2.setJavaScriptEnabled(true);
            webView2.loadUrl("https://stthomas-svale.org/sermons/");
        }

// Initialize and load WebView3
        if (webView3 != null) { // Check if WebView3 is not null
            WebSettings webSettings3 = webView3.getSettings();
            webSettings3.setJavaScriptEnabled(true);
            webView3.loadUrl("https://stthomas-svale.org/calendar/");
        }

// Initialize and load WebView4
        if (webView4 != null) { // Check if WebView4 is not null
            WebSettings webSettings4 = webView4.getSettings();
            webSettings4.setJavaScriptEnabled(true);
            webView4.loadUrl("https://stthomas-svale.org/give/");
        }
    }
        public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            System.out.println("vol down");
            reLoadUrl();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            System.out.println("vol up");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}