package cn.hello.rabbitmq.persistence;

import cn.hello.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author Renda Zhang
 * @create 2020-05-12 19:52
 */
public class Recv {
    private final static String QUEUE_NAME = "persistence_exchange_queue";
    private final static String EXCHANGE_NAME = "persistence_exchange_test";

    public static void main(String[] argv) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 开启队列持久化，设durable=true
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "item.*");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println(" [消费者] received : " + msg + "!");
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
