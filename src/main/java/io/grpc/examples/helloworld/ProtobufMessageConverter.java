package io.grpc.examples.helloworld;

import com.google.protobuf.Message;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yinlei
 * @since 2018/8/3 15:48
 */
public class ProtobufMessageConverter {
    private static final ConcurrentHashMap<Class<?>, Method> methodCache = new ConcurrentHashMap<Class<?>, Method>();

    public static void main(String[] args) throws Exception {
        long d = System.currentTimeMillis();
        Message message = HelloRequest.newBuilder().setName("yinlei").build();
        byte[] msg = message.toByteArray();

        Message.Builder builder = getMessageBuilder(HelloRequest.class);
        builder.mergeFrom(msg);
        Message message1 = builder.build();
        System.out.println(System.currentTimeMillis() - d);
    }

    private static Message.Builder getMessageBuilder(Class<? extends Message> clazz) throws Exception {
        Method method = methodCache.get(clazz);
        if (method == null) {
            method = clazz.getMethod("newBuilder");
            methodCache.put(clazz, method);
        }
        return (Message.Builder) method.invoke(clazz);
    }
}
