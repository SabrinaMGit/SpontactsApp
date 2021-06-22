package portfolio.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "portfolio.website")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
