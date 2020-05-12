package cn.hello.rabbitmq.persistence;

/**
 * @author Renda Zhang
 * @create 2020-05-12 19:51
 */

import cn.hello.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

/**
 * 生产者，模拟为商品服务
 */
public class Send {
    private final static String EXCHANGE_NAME = "persistence_exchange_test";

    public static void main(String[] argv) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 开启交换机持久化,设durable=true
        channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);


        String message1 = "商品删除了， id = 1001";
        String message2 = "商品新增了， id = 1002";
        String message3 = "商品更新了， id = 1003";

        // 开启消息持久化，设 basicPrperties 为 MessageProperties.PERSISTENT_TEXT_PLAIN
        channel.basicPublish(EXCHANGE_NAME, "item.delete",
                MessageProperties.PERSISTENT_TEXT_PLAIN, message1.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "item.insert",
                MessageProperties.PERSISTENT_TEXT_PLAIN, message2.getBytes());
        channel.basicPublish(EXCHANGE_NAME, "item.update",
                MessageProperties.PERSISTENT_TEXT_PLAIN, message3.getBytes());

        System.out.println(" [商品服务：] Sent '" + message1 + "'");
        System.out.println(" [商品服务：] Sent '" + message2 + "'");
        System.out.println(" [商品服务：] Sent '" + message3 + "'");


        channel.close();
        connection.close();
    }
}
