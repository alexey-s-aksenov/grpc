package client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

  @Autowired
  GreeterServiceClient client;

  @GetMapping("/{name}")
  public String greet(@PathVariable("name") String name) {
    return client.sayHello(name);
  }
}
