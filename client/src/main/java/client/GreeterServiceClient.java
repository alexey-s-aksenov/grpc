package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.grpc.GreeterGrpc;
import ru.grpc.HelloReply;
import ru.grpc.HelloRequest;
import client.configs.ServerProperties;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class GreeterServiceClient {

    private GreeterGrpc.GreeterBlockingStub stub;

    @Autowired
    private ServerProperties props;

    @PostConstruct
    void init(){
        ManagedChannel ch = ManagedChannelBuilder.forAddress(props.getHost(), props.getPort()).usePlaintext().build();
        stub = GreeterGrpc.newBlockingStub(ch);
    }

    String sayHello(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        log.info("Sending request: {}", request);

        HelloReply reply = stub.sayHello(request);

        log.info("Received reply: {}", reply);

        return reply.getMessage();

    }
}
