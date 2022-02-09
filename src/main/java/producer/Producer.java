package producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Producer {

    private String topicName= "kafka";

//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
//
//    ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
//
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate ;

//    @Autowired
//    KafkaTemplate<String, String> kafkaTemplate;


//    @Autowired
//    KafkaTemplate<String, String> kafkaTemplate;

//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName, msg);
    }

    @KafkaListener(topics = "kafka",groupId = "kafka1")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @Bean
    public NewTopic createTopic(){

        return new NewTopic("kafka",1,(short) 1);
    }
//    public void sendMessage2(String message) {
//
//        ListenableFuture<SendResult<String, String>> future =
//                kafkaTemplate.send(topicName, message);
//
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                System.out.println("Sent message=[" + message +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            }
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Unable to send message=["
//                        + message + "] due to : " + ex.getMessage());
//            }
//        });
//    }
}
