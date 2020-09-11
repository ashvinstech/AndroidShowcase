package com.ashvinstech.androidshowcase;

import android.graphics.Point;
import android.view.View;


public interface IAnimationFactory {

    void animateInView(View target, Point point, long duration, AnimationStartListener listener);

    void animateOutView(View target, Point point, long duration, AnimationEndListener listener);

    void animateTargetToPoint(AndroidShowcaseView showcaseView, Point point);

    public interface AnimationStartListener {
        void onAnimationStart();
    }

    public interface AnimationEndListener {
        void onAnimationEnd();
    }
}

