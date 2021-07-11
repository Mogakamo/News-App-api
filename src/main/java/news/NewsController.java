package news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewsController {

    @Autowired
    private NewsService service;

    @SuppressWarnings("rawtypes")
    @GetMapping("/getTopStories")
    public Map getTopStories() {
        return service.getTopStories();
    }
}
