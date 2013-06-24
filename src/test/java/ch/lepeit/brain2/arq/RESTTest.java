package ch.lepeit.brain2.arq;

import java.net.URL;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.lepeit.brain2.BrainRESTService;
import ch.lepeit.brain2.model.Stage;

@RunWith(Arquillian.class)
@RunAsClient
public class RESTTest {
    // private static final String RESOURCE_PREFIX =
    // JaxRsActivator.class.getAnnotation(ApplicationPath.class).value().substring(1);

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(BrainRESTService.class.getPackage())
                .addPackage(Stage.class.getPackage()).addClasses(EntityManagerProducer.class)
                .addAsResource("META-INF/persistence.xml").addAsResource("import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @ArquillianResource
    URL deploymentUrl;

    // @Test
    // public void testGetStages() throws Exception {
    // //deploymentUrl = new URL("http://localhost:8180/test/");
    // // GET http://localhost:8080/test/rest/customer/1
    // ClientRequest request = new ClientRequest("http://localhost:8080/brain2/rest/brain2/stages");
    // //request.header("Accept", MediaType.APPLICATION_XML);
    //
    // // we're expecting a String back
    // ClientResponse<List<Stage>> responseObj = request.get();
    //
    // System.out.println(responseObj.toString());
    //
    //
    // }

    @Test
    @GET
    @Path("rest/brain2/stages")
    @Consumes(MediaType.APPLICATION_JSON)
    public void testWieVieleStages(ClientResponse<List<Stage>> response) {
        Assert.assertEquals(Status.OK.getStatusCode(), response.getStatus());

        List<Stage> stages = response.getEntity(new GenericType<List<Stage>>() {
        });
        Assert.assertEquals(3, stages.size());
    }
}
