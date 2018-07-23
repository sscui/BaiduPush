package com.lab310.fdu.template.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * Created by azure on 2018/5/3.
 */

public class BDUtil {

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


    public static Object deserialize(ByteArrayOutputStream byteOutStream)
    {
        ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
        ObjectInputStream ois2 = null;
        Object w2 = null;
        try {
            ois2 = new ObjectInputStream(byteInStream);
            w2 = ois2.readObject();
            ois2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return w2;
    }

    public static ByteArrayOutputStream serialize(Object o)
    {
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos2 = new ObjectOutputStream(byteOutStream);
            oos2.writeObject(o);
            oos2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(byteOutStream.toString());
        return byteOutStream;
    }


    public static byte[] merge(byte[] arg4, byte[] arg5) {
        byte[] v0 = new byte[arg4.length + arg5.length];
        System.arraycopy(arg4, 0, v0, 0, arg4.length);
        System.arraycopy(arg5, 0, v0, arg4.length, arg5.length);
        return v0;
    }

    public String getMsgSign(String app_id, String msg_id, byte[] body)
    {
        String v3_1 = a(merge(merge(app_id.getBytes(), msg_id.getBytes()), body), false);
        return v3_1;
    }
    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public static String key2 = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAtadv7/MPKp+9Djta\r/DIEt15755s3h1KYA4Lbej2GL2Mx0mdk4wzmjMCzfvNh+v4R7/mF8kfN8Kzowuaa\rFjAzfwIDAQABAkBVYQxguFoxi4DddpJuJMhIs3UDR9YSmYRvagrkapRuIqJmj3hO\rk+EsDQUtNA7JYJdiv/hrPrH0UACDV/Whb1MJAiEA8Rw37/dC157fsxasiTDz9bMQ\reAq9F8GudeH8oT5j8r0CIQDA30JBzOmu7CpPWbsTFh9YuL9wujJdiAdcBVHqmmfg\r6wIhAJbQIMkPr5axgJlDqH5TyXU5IScFCIwwkNCZn2y4Wso9AiBmMydhxJojFYNJ\r7stBTtynX6YZrqBXjWgQ68S/YrgepwIgdIQpvO4xNCT1j/mGIRcM/dqTGwiPOi/x\r/YLmfF2zQkM=";
    public static String key0___ = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMPGuiFnHoDFak4nw1ipCr6EiCA2gSBJ\rtUKSfL41Goz+h4oX2Fs6uNvc0XNPlowZw1Np1AFKGwRgVLuLvot6XnkCAwEAAQ==";
    public static String key2__ = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAtadv7/MPKp+9Djta/DIEt15755s3h1KYA4Lbej2GL2Mx0mdk4wzmjMCzfvNh+v4R7/mF8kfN8KzowuaaFjAzfwIDAQABAkBVYQxguFoxi4DddpJuJMhIs3UDR9YSmYRvagrkapRuIqJmj3hOk+EsDQUtNA7JYJdiv/hrPrH0UACDV/Whb1MJAiEA8Rw37/dC157fsxasiTDz9bMQeAq9F8GudeH8oT5j8r0CIQDA30JBzOmu7CpPWbsTFh9YuL9wujJdiAdcBVHqmmfg6wIhAJbQIMkPr5axgJlDqH5TyXU5IScFCIwwkNCZn2y4Wso9AiBmMydhxJojFYNJ7stBTtynX6YZrqBXjWgQ68S/YrgepwIgdIQpvO4xNCT1j/mGIRcM/dqTGwiPOi/x/YLmfF2zQkM=";
    public static String key00 =   "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMPGuiFnHoDFak4nw1ipCr6EiCA2gSBJtUKSfL41Goz+h4oX2Fs6uNvc0XNPlowZw1Np1AFKGwRgVLuLvot6XnkCAwEAAQ==";
    public static String key0_ =   "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALWnb+/zDyqfvQ47WvwyBLdee+ebN4dS\rmAOC23o9hi9jMdJnZOMM5ozAs37zYfr+Ee/5hfJHzfCs6MLmmhYwM38CAwEAAQ==";
    public static String key0 =   "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALWnb+/zDyqfvQ47WvwyBLdee+ebN4dSmAOC23o9hi9jMdJnZOMM5ozAs37zYfr+Ee/5hfJHzfCs6MLmmhYwM38CAwEAAQ==";

    public static String decryptSecur(byte[] s)
    {
        try {
            byte[] v2_1 = a(s, key2);
            return new String(v2_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String a(byte[] arg2, boolean arg3) {
        String v0_2;
        try {
            MessageDigest v0_1 = MessageDigest.getInstance("MD5");
            v0_1.reset();
            v0_1.update(arg2);
            v0_2 = a(v0_1.digest(), "", arg3);
        }
        catch(NoSuchAlgorithmException v0) {
            v0_2 = null;
        }

        return v0_2;
    }

    public static String a(byte[] arg6, String arg7, boolean arg8) {
        StringBuilder v2 = new StringBuilder();
        int v3 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            String v0 = Integer.toHexString(arg6[v1] & 255);
            if(arg8) {
                v0 = v0.toUpperCase();
            }

            if(v0.length() == 1) {
                v2.append("0");
            }

            v2.append(v0).append(arg7);
        }

        return v2.toString();
    }
    private static final byte[] a;
    static {
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    public static byte[] a(byte[] arg3, String arg4) throws Exception {
        PrivateKey v0 = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(m1910a(arg4.getBytes(), arg4.getBytes().length)));
        Cipher v1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        v1.init(2, ((Key)v0));
        return v1.doFinal(arg3);
    }

    public static byte[] b(byte[] arg3, String arg4) throws Exception {
        PublicKey v0 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(m1910a(arg4.getBytes(), arg4.getBytes().length)));
        Cipher v1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        v1.init(1, ((Key)v0));
        return v1.doFinal(arg3);
    }

    public static byte[] c(byte[] arg10, String arg11) throws Exception {
        PublicKey v0 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(m1910a(arg11.getBytes(), arg11.getBytes().length)));
        Cipher v5 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        v5.init(1, ((Key)v0));
        int v6 = 128;
        int v1 = 117;
        int v7 = arg10.length;
        byte[] v8 = new byte[(v7 + 116) / v1 * v6];
        int v2 = 0;
        int v4 = 0;
        while(v4 < v7) {
            int v0_1 = v7 - v4;
            if(v1 < v0_1) {
                v0_1 = v1;
            }

            byte[] v9 = new byte[v0_1];
            System.arraycopy(arg10, v4, v9, 0, v0_1);
            v4 += v0_1;
            System.arraycopy(v5.doFinal(v9), 0, v8, v2, v6);
            v2 += v6;
        }

        return v8;
    }

    public static String aa(byte[] arg11, String arg12) throws UnsupportedEncodingException
    {
        int v2;
        byte v10 = 61;
        int v0 = arg11.length * 4 / 3;
        byte[] v5 = new byte[v0 + (v0 / 76 + 3)];
        int v6 = arg11.length - arg11.length % 3;
        v0 = 0;
        int v4 = 0;
        int v1 = 0;
        while(v4 < v6) {
            v2 = v1 + 1;
            v5[v1] = a[(arg11[v4] & 255) >> 2];
            v1 = v2 + 1;
            v5[v2] = a[(arg11[v4] & 3) << 4 | (arg11[v4 + 1] & 255) >> 4];
            int v7 = v1 + 1;
            v5[v1] = a[(arg11[v4 + 1] & 15) << 2 | (arg11[v4 + 2] & 255) >> 6];
            v2 = v7 + 1;
            v5[v7] = a[arg11[v4 + 2] & 63];
            if((v2 - v0) % 76 != 0 || v2 == 0) {
                v1 = v2;
            }
            else {
                v1 = v2 + 1;
                v5[v2] = 10;
                ++v0;
            }

            v4 += 3;
        }

        switch(arg11.length % 3) {
            case 1: {
                v0 = v1 + 1;
                v5[v1] = a[(arg11[v6] & 255) >> 2];
                v1 = v0 + 1;
                v5[v0] = a[(arg11[v6] & 3) << 4];
                v2 = v1 + 1;
                v5[v1] = v10;
                v0 = v2 + 1;
                v5[v2] = v10;
                break;
            }
            case 2: {
                v0 = v1 + 1;
                v5[v1] = a[(arg11[v6] & 255) >> 2];
                v1 = v0 + 1;
                v5[v0] = a[(arg11[v6] & 3) << 4 | (arg11[v6 + 1] & 255) >> 4];
                v2 = v1 + 1;
                v5[v1] = a[(arg11[v6 + 1] & 15) << 2];
                v0 = v2 + 1;
                v5[v2] = v10;
                break;
            }
            default: {
                v0 = v1;
                break;
            }
        }

        return new String(v5, 0, v0, arg12);
    }

    public static byte[] m1910a(byte[] bArr, int i) throws Exception {
        int i2 = (i / 4) * 3;
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] obj = new byte[i2];
        i2 = 0;
        while (true) {
            byte b = bArr[i - 1];
            if (!(b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9)) {
                if (b != (byte) 61) {
                    break;
                }
                i2++;
            }
            i--;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        byte b;
        int i7;
        while (i3 < i) {
            b = bArr[i3];
            if (b == (byte) 10 || b == (byte) 13 || b == (byte) 32) {
                i7 = i4;
                i4 = i6;
                i6 = i5;
            } else if (b == (byte) 9) {
                i7 = i4;
                i4 = i6;
                i6 = i5;
            } else {
                if (b >= (byte) 65 && b <= (byte) 90) {
                    i7 = b - 65;
                } else if (b >= (byte) 97 && b <= (byte) 122) {
                    i7 = b - 71;
                } else if (b >= (byte) 48 && b <= (byte) 57) {
                    i7 = b + 4;
                } else if (b == (byte) 43) {
                    i7 = 62;
                } else if (b != (byte) 47) {
                    return null;
                } else {
                    i7 = 63;
                }
                i4 = (i4 << 6) | ((byte) i7);
                if (i5 % 4 == 3) {
                    i7 = i6 + 1;
                    obj[i6] = (byte) ((16711680 & i4) >> 16);
                    i6 = i7 + 1;
                    obj[i7] = (byte) ((65280 & i4) >> 8);
                    i7 = i6 + 1;
                    obj[i6] = (byte) (i4 & 255);
                } else {
                    i7 = i6;
                }
                i6 = i5 + 1;
                int i8 = i4;
                i4 = i7;
                i7 = i8;
            }
            i3++;
            i5 = i6;
            i6 = i4;
            i4 = i7;
        }
        if (i2 > 0) {
            i4 <<= i2 * 6;
            i7 = i6 + 1;
            obj[i6] = (byte) ((16711680 & i4) >> 16);
            if (i2 == 1) {
                i6 = i7 + 1;
                obj[i7] = (byte) ((65280 & i4) >> 8);
            } else {
                i6 = i7;
            }
        }
        byte[] obj2 = new byte[i6];
        System.arraycopy(obj, 0, obj2, 0, i6);
        return obj2;
    }

}
