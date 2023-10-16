package com.example.test;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Scanner;

public class NetworkActivity {
    public Calendar calendar;
    public Calendar run() {
        try  {
            String out = null;
            out = new Scanner(new URL("https://www.google.com/calendar/ical/stthomas-svale.us_shcvjmelaoseoq3q4vsqtetdqs@group.calendar.google.com/public/basic.ics").openStream(), "UTF-8").useDelimiter("\\A").next();
            StringReader sin = new StringReader(out);
            CalendarBuilder builder = new CalendarBuilder();
            return builder.build(sin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

