package az.ingress.paginationandspecification.client;

import az.ingress.paginationandspecification.model.client.CatFactDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author caci
 */

@FeignClient(name = "cat-fact-client", url = "https://catfact.ninja")
@Configuration
public interface CatFactClient {

    @GetMapping("/fact")
    CatFactDto getCatFact();

}
