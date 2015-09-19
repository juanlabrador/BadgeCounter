package com.github.juanlabrador.badgecounter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by juanlabrador on 19/09/15.
 */
public class BadgeCounter {

    public enum BadgeColor {
        GREY(Color.parseColor("#9E9E9E")),
        BLUE_GREY(Color.parseColor("#607D8B")),
        RED(Color.parseColor("#f44336")),
        BLUE(Color.parseColor("#2196F3")),
        CYAN(Color.parseColor("#00BCD4")),
        TEAL(Color.parseColor("#009688")),
        GREEN(Color.parseColor("#4CAF50")),
        YELLOW(Color.parseColor("#FFEB3B")),
        ORANGE(Color.parseColor("#FF9800")),
        DEEP_ORANGE(Color.parseColor("#FF5722")),
        PURPLE(Color.parseColor("#9C27B0")),
        LIGHT_BLUE(Color.parseColor("#03A9F4")),
        LIGHT_GREEN(Color.parseColor("#8BC34A")),
        BLACK(Color.parseColor("#000000"));

        private int color;

        BadgeColor(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }
    }

    public static void update(final Activity activity, final MenuItem menu, int icon, int count) {
        if (count == Integer.MIN_VALUE) {
            update(activity, menu, activity.getResources().getDrawable(icon), BadgeColor.RED, null);
        } else {
            update(activity, menu, activity.getResources().getDrawable(icon), BadgeColor.RED, String.valueOf(count));
        }
    }

    public static void update(final Activity activity, final MenuItem menu, Drawable icon, int count) {
        if (count == Integer.MIN_VALUE) {
            update(activity, menu, icon, BadgeColor.RED, null);
        } else {
            update(activity, menu, icon, BadgeColor.RED, String.valueOf(count));
        }
    }

    public static void update(final Activity activity, final MenuItem menu, int icon, String count) {
        update(activity, menu, activity.getResources().getDrawable(icon), BadgeColor.RED, count);
    }

    public static void update(final Activity activity, final MenuItem menu, int icon, BadgeColor color, int counter) {
        update(activity, menu, activity.getResources().getDrawable(icon), color, String.valueOf(counter));
    }

    public static void update(final Activity activity, final MenuItem menu, int icon, BadgeColor color, String counter) {
        update(activity, menu, activity.getResources().getDrawable(icon), color, counter);
    }


    public static void update(final Activity act, final MenuItem menu, Drawable icon, BadgeColor color, int counter) {
        if (counter == Integer.MIN_VALUE) {
            update(act, menu, icon, color, null);
        } else {
            update(act, menu, icon, color, String.valueOf(counter));
        }
    }

    public static void update(final MenuItem menu, int counter) {
        update(menu, null, counter);
    }

    public static void update(final MenuItem menu, String counter) {
        update(menu, null, counter);
    }

    public static void update(final MenuItem menu, Drawable icon, int counter) {
        if (counter == Integer.MIN_VALUE) {
            update(null, menu, icon, null, null);
        } else {
            update(null, menu, icon, null, String.valueOf(counter));
        }
    }

    public static void update(final MenuItem menu, Drawable icon, String counter) {
        if (counter == null) {
            update(null, menu, icon, null, null);
        } else {
            update(null, menu, icon, null, String.valueOf(counter));
        }
    }

    /**
     * update the given menu item with icon, badgeCount and style
     *
     * @param activity use to bind onOptionsItemSelected
     * @param menu    class menuItem
     * @param icon    icon action menu
     * @param color   background badge
     * @param counter counter
     */
    public static void update(final Activity activity, final MenuItem menu, Drawable icon, BadgeColor color, String counter) {
        if (menu == null) return;

        GradientDrawable mDrawable = new GradientDrawable();

        RelativeLayout mContainer;
        TextView mBadgeCount;
        ImageView mIconBadge;

        if (color == null) {
            mContainer = (RelativeLayout) menu.getActionView();
        } else {
            mContainer = (RelativeLayout) menu.setActionView(R.layout.badge_counter).getActionView();
        }

        mBadgeCount = (TextView) mContainer.findViewById(R.id.count_badge);
        mIconBadge = (ImageView) mContainer.findViewById(R.id.icon_badge);

        //Display icon in ImageView
        if (icon != null) {
            mIconBadge.setImageDrawable(icon);
        }

        if (color != null) {
            // Set Color
            mDrawable.setCornerRadius(5);
            mDrawable.setColor(color.getColor());
            mBadgeCount.setPadding(2, 0, 2, 1);
            mBadgeCount.setBackground(mDrawable);
        }

        //Bind onOptionsItemSelected to the activity
        if (activity != null) {
            mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onOptionsItemSelected(menu);
                }
            });
        }

        //Manage min value
        if (counter == null) {
            mBadgeCount.setVisibility(View.GONE);
        } else {
            mBadgeCount.setVisibility(View.VISIBLE);
            mBadgeCount.setText(counter);
        }

        menu.setVisible(true);
    }


    /**
     * hide the given menu item
     * @param menu
     */
    public static void hide(MenuItem menu) {
        menu.setVisible(false);
    }
}