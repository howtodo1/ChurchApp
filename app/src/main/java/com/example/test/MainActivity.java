package com.example.test;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;

import com.example.test.databinding.ActivityMainBinding;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;

import org.apache.commons.lang3.time.DateUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    // Add a method to switch to another fragment


    @Override
    @Deprecated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Loading...");
        NetworkActivity na = new NetworkActivity();
        na.execute();
       // Calendar calendar = na.run();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Events";
            String description = "Notifies user for events";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("events", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this.
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "events")
                    .setContentTitle("My notification")
                    .setContentText("Much longer text that cannot fit one line...")
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Much longer text that cannot fit one line..."))
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.notify(0, builder.build());

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public class NetworkActivity extends AsyncTask<Void, Void, Void> {
        public List<Event> parseICalData(InputStream icalData, Date startDate) {
            List<Event> events = new ArrayList<>();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(icalData));
            Event currentEvent = null;
            boolean inEvent = false;

            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.startsWith("BEGIN:VEVENT")) {
                        currentEvent = new Event();
                        inEvent = true;
                    } else if (line.startsWith("END:VEVENT")) {
                        if (currentEvent != null) {
                            //System.out.println(currentEvent);
                            Date eventStartDate = currentEvent.getStartDate();
                            if (eventStartDate != null && eventStartDate.after(startDate)) {
                                events.add(currentEvent);
                            }
                            currentEvent = null;
                        }
                        inEvent = false;
                    } else if (inEvent && line.startsWith("SUMMARY:")) {
                        currentEvent.setSummary(line.substring(8));
                    } else if (inEvent && line.startsWith("DESCRIPTION:")) {
                        System.out.println(line.substring(12));
                        currentEvent.setDescription(line.substring(12));
                    } else if (inEvent && line.startsWith("DTSTART:")) {
                        String dateString = line.substring(8);
                        currentEvent.setStartDate(parseICalDate(dateString));
                    } else if (inEvent && line.startsWith("DTEND:")) {
                        String dateString = line.substring(6);
                        currentEvent.setEndDate(parseICalDate(dateString));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return events;
        }

        public Date parseICalDate(String dateString) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            return dateFormat.parse(dateString);
        }

        public class Event {
            private String summary;
            private String description;
            private Date startDate;
            private Date endDate;

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Date getStartDate() {
                return startDate;
            }

            public void setStartDate(Date startDate) {
                this.startDate = startDate;
            }

            public Date getEndDate() {
                return endDate;
            }

            public void setEndDate(Date endDate) {
                this.endDate = endDate;
            }

            @Override
            public String toString() {
                return "Event{" +
                        "summary='" + summary + '\'' +
                        ", description='" + description + '\'' +
                        ", startDate=" + startDate +
                        ", endDate=" + endDate +
                        '}';
            }
        }
        @Override
        protected Void doInBackground(Void... params) {
            try  {
                // Get the Ical file from the URL
                System.out.println("running");
                URL url = new URL("https://www.google.com/calendar/ical/stthomas-svale.us_shcvjmelaoseoq3q4vsqtetdqs@group.calendar.google.com/public/basic.ics");
                Date startDate = new Date(); // Example start date (replace with your desired start date)
                List<Event> events = parseICalData(url.openStream(), startDate);

                for (Event event : events) {
                    System.out.println(event);
                }
                System.out.println(startDate);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


    }
}