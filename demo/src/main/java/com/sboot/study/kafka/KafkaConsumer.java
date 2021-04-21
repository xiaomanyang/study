package com.sboot.study.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2019-10-12 11:50
 */
@Service
public class KafkaConsumer {
    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(id = "miaoshagroup", topics = "topic1")
    public void listen(ConsumerRecord<?,?> record) throws Exception{
      log.debug(record.toString());
        System.out.println(record.toString());
    }
}
