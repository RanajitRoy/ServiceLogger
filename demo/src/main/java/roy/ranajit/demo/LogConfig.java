package roy.ranajit.demo;

import roy.ranajit.logging.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    @Bean
    public Logger newLogger() {
        return new Logger();
    }    
}
