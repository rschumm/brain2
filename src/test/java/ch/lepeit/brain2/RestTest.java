package ch.lepeit.brain2;

import org.junit.Rule;
import org.junit.runner.RunWith;
import static com.eclipsesource.restfuse.Assert.*; 

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith( HttpJUnitRunner.class )
public class RestTest {
 
  @Rule
  public Destination destination = new Destination(  this, "http://localhost:8080" ); 
 
  @Context
  private Response response; // will be injected after every request
 
  @HttpTest( method = Method.GET, path = "/brain2/rest/brain2/stages" )
  public void checkRestfuseOnlineStatus() {
    assertOk( response );
  }  
}


//Jacoco Agent: -javaagent:D:\SCRE_Library\jacoco-0.6.3.201306030806\lib\jacocoagent.jar=output=tcpserver,address=*,port=4711   