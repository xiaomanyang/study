package com.sboot.study.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class KafkaProducer {
    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
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
