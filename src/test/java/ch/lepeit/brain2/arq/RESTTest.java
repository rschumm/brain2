package ch.lepeit.brain2.arq; 

import java.net.URL;
import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.lepeit.brain2.BrainRESTService;
import ch.lepeit.brain2.model.Stage;

@RunWith(Arquillian.class)
@RunAsClient
public class RESTTest {
    //private static final String RESOURCE_PREFIX = JaxRsActivator.class.getAnnotation(ApplicationPath.class).value().substring(1);

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(BrainRESTService.class.getPackage())
                .addClasses(EntityManagerProducer.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource("import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @ArquillianResource
    URL deploymentUrl;

    @Test
    public void testGetStages() throws Exception {
        //deploymentUrl = new URL("http://localhost:8180/test/");
        // GET http://localhost:8080/test/rest/customer/1
        ClientRequest request = new ClientRequest("http://localhost:8080/brain2/rest/brain2/stages");
        //request.header("Accept", MediaType.APPLICATION_XML);

        // we're expecting a String back
        ClientResponse<List<Stage>> responseObj = request.get(); 
        
        System.out.println(responseObj.toString());


    }
}
