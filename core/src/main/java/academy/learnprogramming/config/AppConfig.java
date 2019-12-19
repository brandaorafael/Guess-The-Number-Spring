package academy.learnprogramming.config;

import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.MessageGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }
}
