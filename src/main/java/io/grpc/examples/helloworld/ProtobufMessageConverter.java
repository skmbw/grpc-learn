package io.grpc.examples.helloworld;

import com.google.protobuf.Message;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;

import java.lang.reflect.Method;
import java.util.Arrays;
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
        System.out.println(Arrays.toString(msg));

        Message.Builder builder = getMessageBuilder(HelloRequest.class);
        builder.mergeFrom(msg);
        Message message1 = builder.build();

        Request request = new Request();
        request.setName("yinlei");
        byte[] pbyte = ProtostuffIOUtil.toByteArray(request, RuntimeSchema.getSchema(Request.class), LinkedBuffer.allocate());
        System.out.println(Arrays.toString(pbyte));

        Message.Builder builder2 = getMessageBuilder(HelloRequest.class);
        builder.mergeFrom(pbyte);
        Message message3 = builder.build();
        // 输出的值是一样的
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
