package com.xueershangda.tianxun;

import com.google.protobuf.InvalidProtocolBufferException;
import com.xueershangda.tianxun.user.model.UserOuterClass;

import java.util.Arrays;

/**
 * @author yinlei
 * @since 18-8-23 下午9:48
 */
public class ProtobufJSTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        UserOuterClass.UserReplyList.Builder builder = UserOuterClass.UserReplyList.newBuilder();
        builder.setCode(1);

        UserOuterClass.User.Builder userBuilder = UserOuterClass.User.newBuilder();
        userBuilder.setAccount("yinlei");
        userBuilder.setAge(30);
        userBuilder.setPageSize(10);
        userBuilder.setAgreement(false);

        UserOuterClass.User user1 = userBuilder.build();

        UserOuterClass.User.Builder userBuilder2 = UserOuterClass.User.newBuilder();
        userBuilder2.setAccount("尹雷");
        userBuilder2.setAge(32);
        userBuilder2.setPageSize(10);
        userBuilder2.setAgreement(false);
        UserOuterClass.User user2 = userBuilder2.build();

        builder.addData(user1);
        builder.addData(user2);

        byte[] array = builder.build().toByteArray();
        System.out.println(Arrays.toString(array));
        System.out.println("长度：" + array.length);

        UserOuterClass.UserReplyList.parseFrom(array);

    }

    public static void testHelloWorld() {

    }
}
