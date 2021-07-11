package news;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NewsService {

    private RestTemplate restTemplate;

    public NewsService() {
        restTemplate = new RestTemplate();
    }
    public Map getTopStories() {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(header);
        ResponseEntity<Map> entity = restTemplate.exchange("https://api.nytimes.com/svc/topstories/v2/world.json?api-key=HtjYdnd2cGXa9bNpf0XA4uEzrt9hnzBQ",
                HttpMethod.GET, requestEntity, Map.class);

        if (entity.getStatusCode() == HttpStatus.OK) {
            return entity.getBody();
        }
        return null;
    }
}
