package top.murphypen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerOrderZk80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderZk80.class, args);
    }
}
