package com.github.juanlabrador.badgenotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.juanlabrador.badgecounter.BadgeCounter;

public class DemoActivity extends AppCompatActivity {

    private int mNotificationCounter = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demo, menu);

        //you can add some logic (hide it if the count == 0)
        if (mNotificationCounter > 0) {
            BadgeCounter.update(this,
                    menu.findItem(R.id.notification),
                    R.mipmap.ic_notification,
                    BadgeCounter.BadgeColor.BLUE,
                    mNotificationCounter);
        } else {
            BadgeCounter.hide(menu.findItem(R.id.notification));
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.notification) {
            mNotificationCounter--;
            BadgeCounter.update(item, mNotificationCounter);
        }

        return super.onOptionsItemSelected(item);
    }
}
