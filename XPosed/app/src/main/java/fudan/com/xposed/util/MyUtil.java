package fudan.com.xposed.util;

import android.content.Intent;
import android.os.Bundle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by azure on 2018/5/3.
 */

public class MyUtil {

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        if(bundle == null)
            return "";
        for (String key : bundle.keySet()){
            if (bundle.get(key) == null){
                sb.append(connect(key, "null", "null"));
            } else if (byte[].class.isInstance(bundle.get(key))){
                String string = new String((byte[]) bundle.get(key));
                sb.append(connect(key, string, "byte[]"));
            }else {
                sb.append(connect(key, bundle.get(key).toString(), bundle.get(key).getClass().getName()));
            }
        }
        return sb.toString();
    }

    private static StringBuffer connect(String key, String value, String valueType){
        StringBuffer result = new StringBuffer();

        result.append(" (type : ").append(valueType).append(") ").append(key).append(" => ").append(value).append(";\n");
        return result;
    }
}
