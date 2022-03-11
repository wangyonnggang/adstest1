package com.dylanz.luckydog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Date date=null;
    private Handler mHandler;
    private boolean mRunning = true;
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerThread thread = new HandlerThread("MyHandlerThread");
        thread.start();//创建一个HandlerThread并启动它
        mHandler = new Handler(thread.getLooper());//使用HandlerThread的looper对象创建Handler，如果使用默认的构造方法，很有可能阻塞UI线程
        mHandler.post(mBackgroundRunnable);//将线程post到Handler中
        Button helpSettingButton = findViewById(R.id.helper_setting_btn);
        helpSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
            }
        });

        Button developSettingButton = findViewById(R.id.develop_setting_btn);
        developSettingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(intent);
            }
        });





    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁线程
        mHandler.removeCallbacks(mBackgroundRunnable);
    }
    @Override
    protected void onStop() {
        super.onStop();
       // mRunning = false;
    }
    //实现耗时操作的线程
    Runnable mBackgroundRunnable = new Runnable() {

        @Override
        public void run() {
            //----------模拟耗时的操作，开始---------------
            while(mRunning){
                Log.i("tag", "thread running!");
                try {

                   // Thread.sleep(200);

                        Thread.sleep(1);
                        date=new Date();
                        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
                        String s=sdf.format(date);


                        if(s.equals("01:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("03:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("05:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("07:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("09:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("11:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("13:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("15:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("17:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("19:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("21:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }
                        if(s.equals("23:00:00")){
                            try {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                ComponentName cmp = new ComponentName("com.sina.weibo", "com.sina.weibo.MainTabActivity");
                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setComponent(cmp);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // TODO: handle exception
                                // Toast.makeText(this, "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                            }

                        }



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //----------模拟耗时的操作，结束---------------
        }
    };
    @Override
    protected void onResume() {
        super.onResume();
       // LogUtils.e("onResume is invoke!!!");
        //mRunning = true;

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//
//                // 写子线程中的操作
//            }
//        }).start();

    }
}