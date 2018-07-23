package com.qq.reader.common.conn.socket;

import java.io.Serializable;

public final class QRPushMessage extends f implements Serializable {
    public static final int TYPE_MSG_QD = 1001;
    public static final int TYPE_MSG_SYNC = 1000;
    private String mContent;
    private int mMsgType;

    public QRPushMessage() {
        super();
        this.mMsgType = 1001;
    }

    public String getContent() {
        return this.mContent;
    }

    public int getMsgType() {
        return this.mMsgType;
    }

    public void setContent(String arg1) {
        this.mContent = arg1;
    }

    public void setMsgType(int arg1) {
        this.mMsgType = arg1;
    }

    public String toString() {
        String v0 = this.mContent != null ? this.mContent.toString() : super.toString();
        return v0;
    }
}

