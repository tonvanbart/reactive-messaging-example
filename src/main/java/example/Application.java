package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Created by ton on 30/05/16.
 */
@SpringBootApplication
@EnableJms
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Application.class);
        springApplicationBuilder.sources(Application.class).run(args);
    }

    public MessageConverter jsonMessageConverter() {
        LOG.info("jsonMessageConverter()");
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("object-type");
        return converter;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        LOG.info("setJmsTemplate()");
        jmsTemplate.setMessageConverter(jsonMessageConverter());
    }
}
