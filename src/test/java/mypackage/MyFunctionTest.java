package mypackage;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyFunctionTest {
  @Test
  public void successfulResponse() {
    MyFunction func = new MyFunction();
    String result = func.handleRequest(null, null);
    
    System.out.println("result: " +result);

    
  }
}
