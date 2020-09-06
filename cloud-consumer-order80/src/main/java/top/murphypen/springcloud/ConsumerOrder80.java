package top.murphypen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import top.murphypen.LoadBalanceRuleConfig;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = LoadBalanceRuleConfig.class)
public class ConsumerOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80.class, args);
    }
}
