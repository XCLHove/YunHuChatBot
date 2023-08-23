package com.yunhuchatbot.Constant;

public interface SendConstant {
    final String RECV_ID = "recvId";
    final String RECV_TYPE = "recvType";
    final String CONTENT_TYPE = "contentType";
    final String CONTENT = "content";

    public interface RecvType {
        final String GROUP = "group";
    }

    public interface ContentType {
        final String TEXT = "text";
    }

    public interface Content {
        final String TEXT = "text";
    }
}
