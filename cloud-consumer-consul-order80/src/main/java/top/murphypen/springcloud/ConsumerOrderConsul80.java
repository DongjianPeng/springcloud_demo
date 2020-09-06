package top.murphypen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerOrderConsul80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderConsul80.class, args);
    }
}
