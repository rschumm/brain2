package ch.lepeit.brain2;

import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static com.eclipsesource.restfuse.Assert.*;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith(HttpJUnitRunner.class)
public class RestServerTest {

    @Rule
    public Destination destination = new Destination(this, "http://localhost:8080");

    @Context
    private Response response; // will be injected after every request

    @HttpTest(method = Method.GET, path = "/brain2/rest/brain2/stages")
    public void checkRestfuseOnlineStatus() {
        String erwAntwort = "[{\"name\":\"Development\",\"kurzName\":\"dev\",\"stage_ID\":1},{\"name\":\"Acceptance\",\"kurzName\":\"acc\",\"stage_ID\":2},{\"name\":\"Production\",\"kurzName\":\"prod\",\"stage_ID\":3}]";

        assertOk(response);
        String body = response.getBody();
        assertEquals(erwAntwort, body);

    }
}

// Jacoco Agent:
// -javaagent:D:\SCRE_Library\jacoco-0.6.3.201306030806\lib\jacocoagent.jar=output=tcpserver,address=*,port=4711,excludes=*$$$*
// Agent SN
// -javaagent:C:\eplatform\lib\m3-repository\org\jacoco\org.jacoco.agent\0.6.4-SNAPSHOT\org.jacoco.agent-0.6.4-SNAPSHOT-runtime.jar=output=tcpserver,address=*,port=4711,excludes=*$$$*

// -javaagent:C:\eplatform\lib\m3-repository\org\jacoco\org.jacoco.agent\0.6.4-SNAPSHOT\org.jacoco.agent-0.6.4-SNAPSHOT-runtime.jar=output=tcpserver,address=*,port=4711,excludes=*$$$*

// -javaagent:D:\SCRE_Library\jacoco-builds\jacocoagent.jar=output=tcpserver,address=*,port=4711,excludes=*$$$*

// -javaagent:D:\SCRE_Library\jacoco-0.6.4.201312101107\lib\jacocoagent.jar=output=tcpserver,address=*,port=4711,excludes=*$$$*

