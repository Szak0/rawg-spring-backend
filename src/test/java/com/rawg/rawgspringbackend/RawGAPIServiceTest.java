package com.rawg.rawgspringbackend;

import com.rawg.rawgspringbackend.model.generated.game.Game;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RawGAPIServiceTest {

    @Test
    void testGameById() {
        RestTemplate template = mock(RestTemplate.class);
        RawGAPIService service = new RawGAPIService();
        when();
        service.getGameById("1");
    }

}