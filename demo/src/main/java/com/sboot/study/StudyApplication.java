package com.sboot.study;

import com.sboot.study.kafka.KafkaProducer;
import com.sboot.study.redis.RedisService;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.sboot.study.dao")
public class StudyApplication implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(StudyApplication.class);
    @Autowired
    RedisService redisService;
    @Autowired
    KafkaProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    //每30秒执行一次
    @Scheduled(fixedRate = 1000 * 3)
    public void reportCurrentTime(){
//        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
//        producer.sendMessage("topic1","haha");
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }

    /**
     * 服务启动后自动执行的方法
     * @param args
     */

    @Override
    public void run(String... args) {
        System.out.println(">>>>>>>>>>>>>>>服务启动成功<<<<<<<<<<<<<");
        log.debug("-------------------------log");
        log.info("hhhhhhhhhhhhhhhhhhh");
        redisService.setValue();
        Properties props = new Properties();
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<>("mysf", "key1", "value1"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/wsjc?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                    "root", "root");
            Statement statement = connection.createStatement();
            System.out.println(connection.isClosed());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
