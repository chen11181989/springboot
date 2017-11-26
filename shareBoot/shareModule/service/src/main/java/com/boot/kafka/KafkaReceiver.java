package com.boot.kafka;

import com.alibaba.fastjson.JSON;
import com.boot.utils.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

    @KafkaListener(topics = "kafka1")
    public void processMessage(String content){

        Message m = JSON.parseObject(content,Message.class);
        System.out.println(m.getMsg());
    }

}
