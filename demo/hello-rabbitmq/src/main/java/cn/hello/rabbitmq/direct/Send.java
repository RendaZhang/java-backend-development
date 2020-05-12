package cn.hello.rabbitmq.direct;

import cn.hello.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
/**
 * 生产者，模拟为商品服务
 */
public class Send {
    private final static String EXCHANGE_NAME = "direct_exchange_test";

    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为direct
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // 消息内容
        String message1 = "商品删除了， id = 1001";
        String message2 = "商品新增了， id = 1002";
        String message3 = "商品更新了， id = 1003";
        // 发送消息，并且指定routing key 为：insert ,代表新增商品
        channel.basicPublish(EXCHANGE_NAME, "delete", null, message1.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "insert", null, message2.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "update", null, message3.getBytes());
        System.out.println(" [商品服务：] Sent '" + message1 + "'");
        System.out.println(" [商品服务：] Sent '" + message2 + "'");
        System.out.println(" [商品服务：] Sent '" + message3 + "'");


        //关闭通道和连接
        channel.close();
        connection.close();
    }
}