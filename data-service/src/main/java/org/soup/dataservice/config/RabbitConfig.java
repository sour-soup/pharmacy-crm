package org.soup.dataservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfig {
    public static final String CUSTOMER = "customer";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter jsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter);
        return template;
    }

    @Bean
    public DirectExchange customerExchange() {
        return new DirectExchange(CUSTOMER + ".exchange", true, false);
    }

    @Bean
    public Queue customerQueue() {
        return new Queue(CUSTOMER + ".queue", true, false, false);
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

    // Order
    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange("order.exchange", true, false);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue("order.queue", true, false, false);
    }

    @Bean
    public Binding orderCreateBinding(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("create");
    }

    @Bean
    public Binding orderUpdateBinding(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("update");
    }

    @Bean
    public Binding orderDeleteBinding(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("delete");
    }

    @Bean
    public Binding orderDetailBinding(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("detail");
    }

    // Medicine
    @Bean
    public DirectExchange medicineExchange() {
        return new DirectExchange("medicine.exchange", true, false);
    }

    @Bean
    public Queue medicineQueue() {
        return new Queue("medicine.queue", true, false, false);
    }

    @Bean
    public Binding medicineCreateBinding(Queue medicineQueue, DirectExchange medicineExchange) {
        return BindingBuilder.bind(medicineQueue).to(medicineExchange).with("create");
    }

    @Bean
    public Binding medicineUpdateBinding(Queue medicineQueue, DirectExchange medicineExchange) {
        return BindingBuilder.bind(medicineQueue).to(medicineExchange).with("update");
    }

    @Bean
    public Binding medicineDeleteBinding(Queue medicineQueue, DirectExchange medicineExchange) {
        return BindingBuilder.bind(medicineQueue).to(medicineExchange).with("delete");
    }

    @Bean
    public Binding medicineDetailBinding(Queue medicineQueue, DirectExchange medicineExchange) {
        return BindingBuilder.bind(medicineQueue).to(medicineExchange).with("detail");
    }

    // Pharmacist
    @Bean
    public DirectExchange pharmacistExchange() {
        return new DirectExchange("pharmacist.exchange", true, false);
    }

    @Bean
    public Queue pharmacistQueue() {
        return new Queue("pharmacist.queue", true, false, false);
    }

    @Bean
    public Binding pharmacistCreateBinding(Queue pharmacistQueue, DirectExchange pharmacistExchange) {
        return BindingBuilder.bind(pharmacistQueue).to(pharmacistExchange).with("create");
    }

    @Bean
    public Binding pharmacistUpdateBinding(Queue pharmacistQueue, DirectExchange pharmacistExchange) {
        return BindingBuilder.bind(pharmacistQueue).to(pharmacistExchange).with("update");
    }

    @Bean
    public Binding pharmacistDeleteBinding(Queue pharmacistQueue, DirectExchange pharmacistExchange) {
        return BindingBuilder.bind(pharmacistQueue).to(pharmacistExchange).with("delete");
    }

    @Bean
    public Binding pharmacistDetailBinding(Queue pharmacistQueue, DirectExchange pharmacistExchange) {
        return BindingBuilder.bind(pharmacistQueue).to(pharmacistExchange).with("detail");
    }

    // OrderItem
    @Bean
    public DirectExchange orderItemExchange() {
        return new DirectExchange("orderitem.exchange", true, false);
    }

    @Bean
    public Queue orderItemQueue() {
        return new Queue("orderitem.queue", true, false, false);
    }

    @Bean
    public Binding orderItemCreateBinding(Queue orderItemQueue, DirectExchange orderItemExchange) {
        return BindingBuilder.bind(orderItemQueue).to(orderItemExchange).with("create");
    }

    @Bean
    public Binding orderItemUpdateBinding(Queue orderItemQueue, DirectExchange orderItemExchange) {
        return BindingBuilder.bind(orderItemQueue).to(orderItemExchange).with("update");
    }

    @Bean
    public Binding orderItemDeleteBinding(Queue orderItemQueue, DirectExchange orderItemExchange) {
        return BindingBuilder.bind(orderItemQueue).to(orderItemExchange).with("delete");
    }

    @Bean
    public Binding orderItemDetailBinding(Queue orderItemQueue, DirectExchange orderItemExchange) {
        return BindingBuilder.bind(orderItemQueue).to(orderItemExchange).with("detail");
    }
}
