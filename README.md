# BadgeCounter  [ ![Download](https://api.bintray.com/packages/juanlabrador/maven/BadgeCounter/images/download.svg) ](https://bintray.com/juanlabrador/maven/BadgeCounter/_latestVersion)
A simple library for show a badge counter in action menu.

![BadgeCounter](screen/red.png)
![BadgeCounter](screen/blue.png)
![BadgeCounter](screen/gray.png)
How to use
----------
```groovy
compile 'com.github.juanlabrador:badgecounter:1.0@aar'
```
menu.xml
--------
Add in your menu.xml, app:actionLayout="@layout/badge_counter" param.

```xml
  <menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools" tools:context=".DemoActivity">

    <item android:id="@+id/action_settings"
        android:title="@string/action_settings"
        android:orderInCategory="100"
        app:showAsAction="never" />

    <item
        android:id="@+id/notification"
        android:title="Notification"
        app:actionLayout="@layout/badge_counter"
        app:showAsAction="always"/>
</menu>
```
Activity
--------
```java
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demo, menu);

        // Create a condition (hide it if the count == 0)
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.notification) {
            // If you want to update
            mNotificationCounter--;
            BadgeCounter.update(item, mNotificationCounter);
        }

        return super.onOptionsItemSelected(item);
    }
```

You can set an icon drawable or icon res, textColor just in white (for now), and you change color to badge (Defaul is RED).

Log
----
v1.0
- TextColor in badge is just white
- Change background badge color
- setIcon with drawable or resourse

Developed by
------------

- Juan Labrador - <juanjavierlabrador@gmail.com>
- Twitter: <a href="https://twitter.com/juanlabrador">@JuanLabrador</a>

Inspiration in
--------------

<a href="https://github.com/mikepenz/Android-ActionItemBadge">Android-ActionItemBadge</a>
