/*
 * Brian Jackson
 * bj1412@att.com
 * 11/15/2017
 * Android Developer Nanodegree
 * Project 5: Make Your App Material
 *
 * Filename: ScrollAwareFABBehavior.java
 * -Support class used to hide FAB when scrolling downward and showing FAB when scrolling back up.
 * -Behavior is attached to FloatingActionButton in fragment_article_detail.xml.
 * -My code requires the Design Support Library to be > 25.0.1, thus I had to override onHidden as outlined in the link below.
 * Credit:
 * https://github.com/newfivefour/BlogPosts/blob/master/android-coordinatorlayout-scrolling-hide-fab-behavior.md
 * (Fix)  https://stackoverflow.com/questions/41153619/floating-action-button-not-visible-on-scrolling-after-updating-google-support/41386278#41386278
 *
 *
 */

package com.example.xyzreader.support;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;


public class ScrollAwareFABBehavior extends CoordinatorLayout.Behavior<FloatingActionButton>  {
    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final FloatingActionButton child,
                                       final View directTargetChild, final View target, final int nestedScrollAxes) {
        // Ensure we react to vertical scrolling
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(final CoordinatorLayout coordinatorLayout,
                               final FloatingActionButton child,
                               final View target, final int dxConsumed, final int dyConsumed,
                               final int dxUnconsumed, final int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                /**
                 * Called when a FloatingActionButton has been hidden
                 *
                 * @param fab the FloatingActionButton that was hidden.
                 */
                @Override
                public void onHidden(FloatingActionButton fab) {
                    super.onShown(fab);
                    fab.setVisibility(View.INVISIBLE);
                }
            });
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            child.show();
        }
    }
}
