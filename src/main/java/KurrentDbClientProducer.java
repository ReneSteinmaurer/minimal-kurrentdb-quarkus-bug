import io.kurrent.dbclient.KurrentDBClient;
import io.kurrent.dbclient.KurrentDBConnectionString;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class KurrentDbClientProducer {
    private KurrentDBClient client;

    @Produces
    public KurrentDBClient produceClient() {
        if (client == null) {
            var settings = KurrentDBConnectionString.parseOrThrow("kurrentdb://localhost:2113?tls=false");
            client = KurrentDBClient.create(settings);
        }
        return client;
    }
}

