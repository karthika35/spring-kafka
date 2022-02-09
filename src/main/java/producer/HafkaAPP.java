package producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "*")
public class HafkaAPP {
    public static void main(String args[])  {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HafkaConfig.class);


        Producer jmsHelper = applicationContext.getBean(Producer.class);
        jmsHelper.sendMessage("hooray!!!");
    }
}
