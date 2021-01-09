package joycai.springboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * application boot entry
 */
@EnableScheduling
@EnableDubbo
@SpringBootApplication
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    static boolean debugMode = true;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 用于获取启动参数
     * @param args
     */
    @Autowired
    public Application(ApplicationArguments args) {

    }

}
