package com.conflentkafka.Controller;

import com.conflentkafka.Producer.ConfluentProducer;
import com.conflentkafka.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class KafkaController {


    private final ConfluentProducer producer;

    @Autowired
    KafkaController(ConfluentProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        this.producer.sendMessage(new User(name, age));
    }

}
