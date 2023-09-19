package com.example.test;

import android.app.ActionBar;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.View;
import android.widget.Button;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_give)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        reLoadUrl();
    }
    public void reLoadUrl() {
        WebView webView1 = (WebView) findViewById(R.id.prayer);
        if (webView1 != null) { // Check if WebView1 is not null
            WebSettings webSettings1 = webView1.getSettings();
            webSettings1.setJavaScriptEnabled(true);
            webView1.loadUrl("https://stthomas-svale.org/worship-schedule/");
        }

// Initialize and load WebView2
        WebView webView2 = (WebView) findViewById(R.id.sermons);
        if (webView2 != null) { // Check if WebView2 is not null
            WebSettings webSettings2 = webView2.getSettings();
            webSettings2.setJavaScriptEnabled(true);
            webView2.loadUrl("https://stthomas-svale.org/sermons/");
        }

// Initialize and load WebView3
        WebView webView3 = (WebView) findViewById(R.id.events);
        if (webView3 != null) { // Check if WebView3 is not null
            WebSettings webSettings3 = webView3.getSettings();
            webSettings3.setJavaScriptEnabled(true);
            webView3.loadUrl("https://stthomas-svale.org/calendar/");
        }

// Initialize and load WebView4
        WebView webView4 = (WebView) findViewById(R.id.give);
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