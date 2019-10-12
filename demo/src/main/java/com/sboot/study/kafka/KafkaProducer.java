package com.sboot.study.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2019-10-12 11:37
 */
@Service
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> template;

    @Autowired
    public KafkaProducer(KafkaTemplate template){
        this.template = template;
    }

    public void sendMessage(String topic, String data){
        template.send(topic, data);
        log.debug("send data : " + data);
    }
}
