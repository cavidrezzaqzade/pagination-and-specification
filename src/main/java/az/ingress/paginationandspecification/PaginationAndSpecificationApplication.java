package az.ingress.paginationandspecification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PaginationAndSpecificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationAndSpecificationApplication.class, args);
    }

}
