package com.boot.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public  void sendMessage(){
        Message msg = new Message();
        msg.setId(System.currentTimeMillis());
        msg.setMsg(UUID.randomUUID().toString());
        msg.setSendTime(new Date());

        String json =JSON.toJSONString(msg);
        kafkaTemplate.send("kafka1",json);

    }


}
