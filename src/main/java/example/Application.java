package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

/**
 * Created by ton on 30/05/16.
 */
@SpringBootApplication
@EnableJms
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Application.class);
        springApplicationBuilder.sources(Application.class).run(args);
//        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
    }
}
