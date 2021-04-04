package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonParsingService implements  ParsingService{
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public fake_karama parse(String url) {
        return restTemplate.getForObject(url,fake_karama.class);
    }
}
