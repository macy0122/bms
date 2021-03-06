package com.yzy.common.rabbitmq;

import com.yzy.common.utils.SMSSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @title:
 * @description: 登陆验证码消息发送
 *
 * @package: com.yzy.common.rabbitmq.RabbitmqReceiver.java
 * @author: yzy
 * @date: 2019-09-12 08:24:00
 * @version: v1.0
 */

@Component
@RabbitListener(queues = {"login"})
public class RabbitmqReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqReceiver.class);

    @Autowired
    SMSSender smsSender;

    @RabbitHandler
    public void process(String msg) {
        try {
            String[] args = msg.split(",");
            System.out.println("验证码：" + args[1]);
//            smsSender.sendSMS(args[0], "验证码：" + args[1]);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

}
