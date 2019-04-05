package server.impl;

import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import ru.grpc.GreeterGrpc;
import ru.grpc.HelloReply;

@Slf4j
@GRpcService
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

  @Override
  public void sayHello(ru.grpc.HelloRequest request,
                       io.grpc.stub.StreamObserver<ru.grpc.HelloReply> responseObserver) {
    log.info("Server got message with name {}", request.getName());

    String response = "Hello " + request.getName();

    HelloReply helloReply = HelloReply.newBuilder().setMessage(response).build();
    responseObserver.onNext(helloReply);
    responseObserver.onCompleted();

    log.info("Server replied with {}", helloReply.getMessage());

  }
}
