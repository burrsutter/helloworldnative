package mypackage;

import java.util.LinkedHashMap;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.net.URL;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * MyFunction
 */
public class MyFunction implements RequestHandler<Object, String> {


  private int count = 0;  // just something to "see" process lifecycle

  @Inject
  @RestClient
  CheckIp myip;

  public String handleRequest(final Object input, final Context context) {
    System.out.println("Java Lambda Handler");
    System.out.println("---------------------------------");

    if (input != null) {
      System.out.println("Input class: " + input.getClass().getName());
      System.out.println("Input keys and values");
      
      LinkedHashMap realInput = (LinkedHashMap) input;
      
      // list out everything contained in the event input
      realInput.forEach((k,v) -> System.out.println(k + ":" + v));
      
      System.out.println("---------------------------------");
    }

    printEnvVars();
    
    String ip = "myip: " + myip;
    System.out.println(ip);

    String output = String.format("{ \"message\": \"aloha\", \"location\": \"%s\", \"count\": %d}", ip, count++);
    
    return output;
    
  }
  private void printEnvVars() {
    Map<String, String> env = System.getenv();
    System.out.println("---------------------------------");
    env.forEach((k,v) -> System.out.println(k + ":" + v));
    System.out.println("---------------------------------");
  }

  // private String getPageContents(String address) throws IOException{
  //   URL url = new URL(address);
  //   try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
  //       return br.lines().collect(Collectors.joining(System.lineSeparator()));
  //   }
  // }


}