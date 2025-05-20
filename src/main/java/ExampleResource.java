import com.fasterxml.jackson.databind.ObjectMapper;
import io.kurrent.dbclient.EventData;
import io.kurrent.dbclient.KurrentDBClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/test")
public class ExampleResource {

    @Inject
    KurrentDBClient kurrentDBClient;

    @POST
    public String testEvent() throws Exception {
        var objectMapper = new ObjectMapper();
        var event = new SimpleEvent("test-id", "hello world");
        var eventData = EventData.builderAsJson(
                "TestEvent",
                objectMapper.writeValueAsBytes(event)
        ).build();

        // This is the problematic call!
        kurrentDBClient.appendToStream("test-stream", eventData).get();

        return "done";
    }

    public static record SimpleEvent(String id, String message) {}
}