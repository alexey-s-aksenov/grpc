package client.configs;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("classpath:client.properties")
@ConfigurationProperties(prefix = "grpcserver")
@Data
public class ServerProperties {
    private String host;
    private int port;

}
