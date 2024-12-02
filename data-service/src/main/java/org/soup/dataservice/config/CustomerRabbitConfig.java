package org.soup.dataservice.config;

import org.soup.dataservice.service.CustomerService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRabbitConfig {
    public static final String QUEUE_NAME = "customer";

    @Bean
    public DirectExchange customerExchange() {
        return new DirectExchange(QUEUE_NAME + ".exchange", true, false);
    }

    @Bean
    public Queue customerQueue() {
        return new Queue(QUEUE_NAME + ".queue", true, false, false);
    }

    @Bean
    public Binding customerCreateBinding(Queue customerQueue, DirectExchange customerExchange) {
        return BindingBuilder.bind(customerQueue).to(customerExchange).with("create");
    }

    @Bean
    public Binding customerUpdateBinding(Queue customerQueue, DirectExchange customerExchange) {
        return BindingBuilder.bind(customerQueue).to(customerExchange).with("update");
    }

    @Bean
    public Binding customerDeleteBinding(Queue customerQueue, DirectExchange customerExchange) {
        return BindingBuilder.bind(customerQueue).to(customerExchange).with("delete");
    }

    @Bean
    public Binding customerDetailBinding(Queue customerQueue, DirectExchange customerExchange) {
        return BindingBuilder.bind(customerQueue).to(customerExchange).with("detail");
    }

    @Bean
    public MessageListenerAdapter customerMessageListenerAdapter(CustomerService customerService) {
        return new MessageListenerAdapter(customerService, QUEUE_NAME);
    }
}
