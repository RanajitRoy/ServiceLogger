package roy.ranajit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import logger.Interface.LogMsg.LOG_LEVEL;
import roy.ranajit.logging.Logger;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Logger logger = new Logger();

		for(int i=0;i<5;i++) {
			logger.log((LOG_LEVEL.INFO.getNumber()+i)%5, "service-"+i, "Message"+i);
		}
	}

}
