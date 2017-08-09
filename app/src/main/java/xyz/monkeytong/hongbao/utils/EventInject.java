package xyz.monkeytong.hongbao.utils;


import android.annotation.SuppressLint;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by AnyMarvel on 2017/8/09.
 * 按键, 触摸事件注入
 */
@SuppressLint("DefaultLocale")
public class EventInject {
    private static final String TAG = "EventInject";
    private Process process;
    private OutputStream outputStream;
    private static EventInject eventInject;

    private EventInject() {
    }

    public static EventInject getInstance() {
        if (eventInject == null) {
            synchronized (EventInject.class) {
                if (eventInject == null) {
                    eventInject = new EventInject();
                }
            }
        }
        return eventInject;
    }

    public void init() {
        try {
            process = Runtime.getRuntime().exec("su");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tap(int x, int y) {
        checkProcessInitialized();
        String cmd = String.format("input tap %d %d", x, y);
        runCmd(cmd);
    }

    public void swipe(int x1, int y1, int x2, int y2) {
        checkProcessInitialized();
        String cmd = String.format("input swipe %d %d %d %d", x1, y1, x2, y2);
        runCmd(cmd);
    }

    public void longPress(int x, int y, int time) {
        checkProcessInitialized();
        // 长按也是使用swipe命令, 但是起点和重点坐标一样
        String cmd = String.format("input swipe %d %d %d %d %d", x, y, x, y, time);
        runCmd(cmd);
    }

    public void inputKey(int keyCode) {
        checkProcessInitialized();
        String cmd = String.format("input keyevent %d", keyCode);
        runCmd(cmd);
    }

    public void inputText(String text) {
        checkProcessInitialized();
        String cmd = String.format("input text '%s'", text);
        runCmd(cmd);
    }

    private void checkProcessInitialized() {
        if (process == null) {
            throw new RuntimeException("You should call init() first");
        }
    }

    private void runCmd(String cmd) {
        Log.d(TAG, "runCmd start:" + System.currentTimeMillis());
        cmd = cmd + "\n";
        try {
            if (outputStream == null) {
                outputStream = process.getOutputStream();
            }

            outputStream.write(cmd.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "runCmd end:" + System.currentTimeMillis());
    }


}
