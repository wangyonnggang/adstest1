package com.dylanz.luckydog.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.app.Notification;
import android.app.PendingIntent;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;

import androidx.annotation.RequiresApi;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;

public class LuckyService2 extends AccessibilityService {
    /**
     * 日志的 tag，随意
     */
    public static final String TAG = "LuckyService";

    /**
     * 红包是否打开的状态记录变量
     */
    private boolean isRedPacketOpened = false;

    /**
     * 红包消息辨别关键字
     */
    private static final String HONG_BAO_TXT = "[微信红包]";

    /**
     * 有"开"的那个小弹窗的 className
     */
    private static final String ACTIVITY_DIALOG_LUCKY_MONEY = "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI";

    /**
     * 红包领取后的详情页面的 className
     */
    private static final String LUCKY_MONEY_DETAIL = "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI";

    /**
     * 收到的红包，整个控件的 id
     */
    private static final String opensendbutton = "com.sina.weibo:id/tipview";

    private static final String opensendbutton1 = "com.sina.weibo:id/titleSave";
    /**
     * 已领过的红包有个"已领取"字眼，这个字眼对应的控件 id
     */
    //private static final String OPENED_ID = "com.tencent.mm:id/tt";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {


        if (event.getClassName().toString().equals("com.sina.weibo.MainTabActivity")) {
            Log.i(TAG, "点击1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //List<AccessibilityWindowInfo> Awi= getWindows();
            tap(1000,163);


            AccessibilityNodeInfo rootNode = getRootInActiveWindow();
           // jumpIntoRedPacket(rootNode);

                   // AccessibilityNodeInfo node=  nodeInfo.getRoot();
                    List<AccessibilityNodeInfo> nodeInfoList = rootNode.findAccessibilityNodeInfosByViewId(opensendbutton1);
                    for(AccessibilityNodeInfo An :nodeInfoList){
                        if(An !=null){

                            //adbClick(opensendbutton1, 1000);
                           tap(999,163);
                            // An.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        }
                        //System.out.println("hhhhhhhhhhhhh");

                    }




                //  AccessibilityNodeInfo rootNode = getRootInActiveWindow();
                // System.out.println(rootNode.toString());
                //  openRedPacket(rootNode);
                // clickPlusButton(rootNode);
/*

            List<AccessibilityWindowInfo> Awi1= getWindows();
            for (AccessibilityWindowInfo nodeInfo1 : Awi1) {
                if (nodeInfo1 != null) {
                    AccessibilityNodeInfo node1=  nodeInfo1.getRoot();
                    List<AccessibilityNodeInfo> nodeInfoList1 = node1.findAccessibilityNodeInfosByViewId(opensendbutton);
                    for(AccessibilityNodeInfo An1 :nodeInfoList1){
                        if(An1 !=null){
                            Log.i(TAG, "点击2");
                            //adbClick(opensendbutton, 1000);
                            tap(799,313);
                            // An.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        }
                        //System.out.println("hhhhhhhhhhhhh");

                    }
                }
                //  AccessibilityNodeInfo rootNode = getRootInActiveWindow();
                // System.out.println(rootNode.toString());
                //  openRedPacket(rootNode);
                // clickPlusButton(rootNode);

            }
*/



            return;

            //有
        }

        //遍历消息列表的每个消息，点击红包控件



        if (event.getClassName().toString().equals("com.sina.weibo.composerinde.OriginalComposerActivity")) {
            //可能会由于网络原因，"开"的那个小弹框会需要加载后才显示，我们此处最多等 5 秒钟
            Log.i(TAG, "编辑");
            List<AccessibilityWindowInfo> Awi= getWindows();
            for (AccessibilityWindowInfo nodeInfo : Awi) {
                if (nodeInfo != null) {
                    AccessibilityNodeInfo node=  nodeInfo.getRoot();
                    List<AccessibilityNodeInfo> nodeInfoList = node.findAccessibilityNodeInfosByViewId("com.sina.weibo:id/edit_view");
                    for(AccessibilityNodeInfo An :nodeInfoList){
                        if(An !=null){
                            ClipboardManager clipboard = (ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("text", "15066306736");
                            clipboard.setPrimaryClip(clip);
                            //焦点（n是AccessibilityNodeInfo对象）
                            An.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
                           // 粘贴进入内容
                            An.performAction(AccessibilityNodeInfo.ACTION_PASTE);


                            // An.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        }
                        //System.out.println("hhhhhhhhhhhhh");

                    }
                }
                //  AccessibilityNodeInfo rootNode = getRootInActiveWindow();
                // System.out.println(rootNode.toString());
                //  openRedPacket(rootNode);
                // clickPlusButton(rootNode);
           }


            return;

        }

        //是否微信聊天页面的类


    /**
     * 点击"开"按钮
     *
     * @param rootNode rootNode
     */
    /*
    private void openRedPacket(AccessibilityNodeInfo rootNode) {
        if (rootNode == null) {
            return;
        }
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            AccessibilityNodeInfo node = rootNode.getChild(i);
            if ("android.widget.Button".equals(node.getClassName().toString())) {
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                isRedPacketOpened = true;
                break;
            }
            openRedPacket(node);
        }
    }
*/


  /*

    public void clickPlusButton(AccessibilityNodeInfo nodeInfo){
        if (rootNode == null) {
            return;
        }
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            //获取到子控件
            AccessibilityNodeInfo node = rootNode.getChild(i);
            //获取红包控件
            AccessibilityNodeInfo target = findViewByID(node, opensendbutton);
            if (target != null) {
                //已领取这个控件为空，红包还没有被领取
                //if (findViewByID(node, OPENED_ID) == null) {
                  //  Log.e(TAG, "找到未领取的红包，点击红包");
                  //  performViewClick(target);
                    break;
               // }
            }
            //jumpIntoRedPacket(node);
        }
    }
*/
    /**
     * 模拟点击事件
     *
     * @param nodeInfo nodeInfo
     */
    /*
    public void performViewClick(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo == null) {
            return;
        }
       // while (nodeInfo != null) {
          //  Log.e(TAG, "打开红包1");
          //  if (nodeInfo.isEnabled()) {
               // Log.e(TAG, "打开红包2");
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
               // break;
          //  }
            //nodeInfo = nodeInfo.getParent();
       // }
    }
*/

/*
    public AccessibilityNodeInfo findViewByID(AccessibilityNodeInfo accessibilityNodeInfo, String id) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        List<AccessibilityNodeInfo> nodeInfoList = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(id);
        if (nodeInfoList != null && !nodeInfoList.isEmpty()) {
            for (AccessibilityNodeInfo nodeInfo : nodeInfoList) {
                if (nodeInfo != null) {
                    return nodeInfo;
                }
            }
        }
        return null;
    }
}
*/

}

    @Override
    public void onInterrupt() {

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void tap(int x, int y) {
        Log.i(TAG,"tap++");
        Rect rect = new Rect();
       // Log.d(TAG, "printTree: bound:" + rect);
        Point position = new Point(rect.left+10, rect.top + 10);
       // new Point()
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path p = new Path();
        p.moveTo(position.x, position.y);
        builder.addStroke(new GestureDescription.StrokeDescription(p, 0L, 100L));
        GestureDescription gesture = builder.build();
         dispatchGesture(gesture, new GestureResultCallback() {
            @Override
            public void onCompleted(GestureDescription gestureDescription) {
                super.onCompleted(gestureDescription);
                Log.i(TAG, "onCompleted: 完成..........");
            }

            @Override
            public void onCancelled(GestureDescription gestureDescription) {
                super.onCancelled(gestureDescription);
                Log.i(TAG, "onCompleted: 取消..........");
            }
        }, null);
    }

    public void adbShell(String cmd) {
        try {
            // 申请获取root权限，这一步很重要，不然会没有作用
            Process process = Runtime.getRuntime().exec("su");
            // 获取输出流
            OutputStream outputStream = process.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(
                    outputStream);
            dataOutputStream.writeBytes(cmd);
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
            Log.d(TAG, "adbShell: 输出命令:" + cmd + "成功");
        } catch (Throwable t) {
            t.printStackTrace();
            Log.d(TAG, "adbShell: 输出命令:" + cmd + "失败");
        }
    }
    public void adbClick(final String id, int delay) {
        Handler handler = null;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AccessibilityService service = null;
                AccessibilityNodeInfo root = service.getRootInActiveWindow();
                if (root == null) {
                    Log.d(TAG, "无Root:" + id);
                }
                List<AccessibilityNodeInfo> tab = root.findAccessibilityNodeInfosByViewId(id);
                if (tab == null || tab.size() == 0) {
                    Log.d(TAG, "找不到点击控件:" + id);
                    return;
                }
                for (AccessibilityNodeInfo info : tab) {
                    if (info != null ) {
                        Rect rect = new Rect();
                        info.getBoundsInScreen(rect);
                        Log.d(TAG, "adb点击位置: " + rect.top + "," + rect.bottom + "," + rect.left + "," + rect.right);
                        adbShell("input tap " + rect.left + " " + rect.top);
                    } else Log.d(TAG, "abd 找不到点击控件:" + id + "," );
                }
            }
        }, delay);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void jumpIntoRedPacket(AccessibilityNodeInfo rootNode) {
        if (rootNode == null) {
            return;
        }
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            //获取到子控件
            AccessibilityNodeInfo node = rootNode.getChild(i);
            //获取红包控件
            AccessibilityNodeInfo target = findViewByID(node, opensendbutton1);
            if (target != null) {
                //已领取这个控件为空，红包还没有被领取
                // if (findViewByID(node, OPENED_ID) == null) {
                Log.e(TAG, "找到未领取的红包，点击红包");
                // performViewClick(target);
                tap(999,163);
                break;
                //  }
            }
            jumpIntoRedPacket(node);
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public AccessibilityNodeInfo findViewByID(AccessibilityNodeInfo accessibilityNodeInfo, String id) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        List<AccessibilityNodeInfo> nodeInfoList = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(id);
        if (nodeInfoList != null && !nodeInfoList.isEmpty()) {
            for (AccessibilityNodeInfo nodeInfo : nodeInfoList) {
                if (nodeInfo != null) {
                    return nodeInfo;
                }
            }
        }
        return null;
    }
}