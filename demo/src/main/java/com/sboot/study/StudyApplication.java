package com.sboot.study;

import com.sboot.study.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.sboot.study.dao")
@Slf4j
public class StudyApplication implements CommandLineRunner {

    @Autowired
    RedisService redisService;

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    //每30秒执行一次
//    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime(){
        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
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
