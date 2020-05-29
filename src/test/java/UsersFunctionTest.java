/*

import application.Application;
import application.entities.User;
import java.util.List;
import org.junit.Test;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import static org.assertj.core.api.Assertions.assertThat;


public class UsersFunctionTest {

  @Test
  public void start() throws Exception {
    AzureSpringBootRequestHandler<User,List<User>> handler = new AzureSpringBootRequestHandler<>(
        Application.class);
    List<User> result = handler.handleRequest(new User("kaser"), null);
    handler.close();
    assertThat(result.isEmpty()).isFalse();
  }


}
*/
