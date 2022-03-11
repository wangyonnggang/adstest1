package com.dylanz.luckydog.service;

import android.annotation.SuppressLint;

public class ADBtest {

    public void exeOrderOnTouchEvent(float X, float Y) {
        try {
            Process ps = Runtime.getRuntime().exec(orderStr(X, Y));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("DefaultLocale")
    public String orderStr(float X, float Y) {
        return String.format("input tap %.2f %.2f", X, Y);
    }

    public void exeOrderOnSwipeEvent(float X1, float Y1,float X2, float Y2) {
        try {
            Process ps = Runtime.getRuntime().exec(swipeStr(X1, Y1,X2,Y2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("DefaultLocale")
    public String swipeStr(float X1, float Y1,float X2, float Y2) {
        return String.format("input swipe %.2f %.2f %.2f %.2f", X1, Y1,X2, Y2);
    }
}
