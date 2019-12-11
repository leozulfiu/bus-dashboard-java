package application.adapters.gateways;

import application.adapters.gateways.dtos.DeparturesDto;
import application.usecases.ports.DepartureTimesGateway;
import application.domain.Departures;
import application.domain.Connection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SearchApiGateway implements DepartureTimesGateway {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Departures fetchDeparturesFor(Connection connection) {
        String URL_ENDPOINT = "https://bananas.cloud.tyk.io/transport";

        DeparturesDto departuresDto = null;
        try {
            URI departureUri = new URIBuilder(URL_ENDPOINT)
                    .addParameter("from", connection.from())
                    .addParameter("to", connection.to())
                    .addParameter("show_delays", "1")
                    .addParameter("num", "3")
                    .build();

            Response response = Request.Get(departureUri)
                    .connectTimeout(2000)
                    .socketTimeout(2000)
                    .execute();
            departuresDto = this.objectMapper.readValue(response.returnContent().asBytes(), DeparturesDto.class);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return departuresDto.toDepartures();
    }
}
