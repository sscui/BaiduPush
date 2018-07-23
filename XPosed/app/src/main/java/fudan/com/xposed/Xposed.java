package fudan.com.xposed;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import fudan.com.xposed.util.MyUtil;


public class Xposed implements IXposedHookLoadPackage {
    private static final String package_name_baidumap = "com.baidu.BaiduMap";
    private static final String package_name_qqreader = "com.qq.reader";
    private static final String package_name_mbaby = "com.baidu.mbaby";
    private static final String package_name_haokan = "com.baidu.haokan";
    private static final String package_name_kdmfxs = "com.kdmfxsgg.novel";
    private static final String package_name_htinns = "com.htinns";
    private String TAG = "MYXPOSED";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (package_name_haokan.equals(lpparam.packageName)) {
            XposedBridge.log(TAG + " into 好看视频");
            XposedHelpers.findAndHookMethod("com.baidu.haokan.external.push.HaokanPushMessageReceiver", lpparam.classLoader, "onMessage", Context.class, String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(TAG + " into HaokanPushMessageReceiver() onMessage()...");
                    String string = (String) param.args[1];
                    XposedBridge.log(TAG + " " +  string);
//                    Intent intent = (Intent) param.args[1];
//                    XposedBridge.log(TAG + " " +  intent.getAction());
//                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
                    XposedBridge.log(TAG + "\n\n\n\n\n\n");
                }
            });

            XposedHelpers.findAndHookMethod("com.baidu.haokan.external.push.HaokanPushMessageReceiver", lpparam.classLoader, "a", Context.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(TAG + " into HaokanPushMessageReceiver() a()...");
                    String string = (String) param.args[1];
                    XposedBridge.log(TAG + " " +  string);
                    XposedBridge.log(TAG + "\n\n\n\n\n\n");
                }
            });
        }

        if (package_name_mbaby.equals(lpparam.packageName)) {
            XposedBridge.log(TAG + " into 宝宝知道");
            XposedHelpers.findAndHookMethod("com.baidu.android.pushservice.PushMessageReceiver", lpparam.classLoader, "onReceive", Context.class, Intent.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(TAG + " into mbaby PushMessageReceiver onReceive()...");
                    Intent intent = (Intent) param.args[1];
                    XposedBridge.log(TAG + " " +  intent.getAction());
                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
                    XposedBridge.log(TAG + "\n\n\n\n\n\n");
                }
            });

//            com.baidu.android.pushservice.h
            XposedHelpers.findAndHookMethod("com.baidu.android.pushservice.h.u", lpparam.classLoader, "r", Context.class, String.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(TAG + " into mbaby u r()...");
                    boolean u_r = (boolean)param.getResult();
                    XposedBridge.log(TAG + " result should be FFFFFFFFFFFFFFFFFFFFFFFFF and real is " + u_r);
                }
            });
        }

        if (package_name_kdmfxs.equals(lpparam.packageName)) {
            XposedBridge.log(TAG + " into 快读免费小说");
            XposedHelpers.findAndHookMethod("com.baidu.android.pushservice.PushMessageReceiver", lpparam.classLoader, "onReceive", Context.class, Intent.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(TAG + " into kdmfxs PushMessageReceiver onReceive()...");
                    Intent intent = (Intent) param.args[1];
                    XposedBridge.log(TAG + " " +  intent.getAction());
                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
                    XposedBridge.log(TAG + "\n\n\n\n\n\n");
                }
            });
        }

        if (package_name_htinns.equals(lpparam.packageName)) {
            XposedBridge.log(TAG + " into 华住酒店");
            XposedHelpers.findAndHookMethod("com.htinns.UI.PushMessageReceiver", lpparam.classLoader, "onReceive", Context.class, Intent.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log(TAG + " into htinns PushMessageReceiver onReceive()...");
                    Intent intent = (Intent) param.args[1];
                    XposedBridge.log(TAG + " " +  intent.getAction());
                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
                    XposedBridge.log(TAG + "\n\n\n\n\n\n");
                }
            });
        }




//        if (package_name_baidumap.equals(lpparam.packageName)) {
//            XposedHelpers.findAndHookMethod("com.baidu.baidumaps.push.BMPushMainReceiver", lpparam.classLoader, "onReceive", Context.class, Intent.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into BMPushMainReceiver onReceive()...");
//                    Intent intent = (Intent) param.args[1];
//                    XposedBridge.log(TAG + " " +  intent.getAction());
//                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));}
//            });
//            XposedHelpers.findAndHookMethod("com.baidu.baidumaps.alarm.AlarmReceiver", lpparam.classLoader, "onReceive", Context.class, Intent.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into AlarmReceiver onReceive()...");
//                    Intent intent = (Intent) param.args[1];
//                    XposedBridge.log(TAG + " " +  intent.getAction());
//                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
//                }
//            });
//            XposedHelpers.findAndHookMethod("com.baidu.baidumaps.WelcomeScreen", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into WelcomeScreen onCreate()...");
//                }
//            });
//        }
//        if (package_name_qqreader.equals(lpparam.packageName)) {
//            XposedBridge.log(TAG + " into qq reader");
//            XposedHelpers.findAndHookMethod("com.qq.reader.activity.MainActivity", lpparam.classLoader, "onStart", new XC_MethodHook() {
//                        @Override
//                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                            XposedBridge.log(TAG + " qq reader started!!!");
//                        }
//                    });
//            XposedHelpers.findAndHookMethod("com.qq.reader.common.conn.socket.PushMessageReceiver", lpparam.classLoader, "onReceive", Context.class, Intent.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into PushMessageReceiver() onReceive()...");
//                    Intent intent = (Intent) param.args[1];
//                    XposedBridge.log(TAG + " " +  intent.getAction());
//                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
//                }
//            });
//            final Class C = XposedHelpers.findClass("com.qq.reader.common.conn.socket.QRPushMessage", lpparam.classLoader);
//            XposedHelpers.findAndHookMethod("com.qq.reader.common.receiver.QRPushReceiver", lpparam.classLoader, "a", Context.class, C, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into QRPushReceiver() a()...");
//                }
//            });
//            XposedHelpers.findAndHookMethod("com.qq.reader.common.conn.socket.QRPushMessage", lpparam.classLoader,"toString", new XC_MethodHook() {
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into QRPushMessage() toString()...");
//                    String str = (String)param.getResult();
//                    XposedBridge.log(TAG + " " + str);
//                }
//            });
//            XposedHelpers.findAndHookMethod("com.qq.reader.cservice.download.game.DownloadGameBroadcastReceiver", lpparam.classLoader,"onReceive",  Context.class, Intent.class, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into DownloadGameBroadcastReceiver() onReceive()...");
//                    Intent intent = (Intent) param.args[1];
//                    XposedBridge.log(TAG + " " +  intent.getAction());
//                    XposedBridge.log(TAG + " " +  MyUtil.printBundle(intent.getExtras()));
//                }
//            });
//            XposedHelpers.findAndHookMethod("com.qq.reader.common.download.task.l", lpparam.classLoader,"b", int.class, new XC_MethodHook() {
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(TAG + " into l() b()...");
//                    Object o = param.getResult();
//                    XposedBridge.log(TAG + " " + o);
//                }
//            });
//        }
    }



}