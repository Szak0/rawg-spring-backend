package com.rawg.rawgspringbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.rawg.rawgspringbackend.model.generated.game.Game;
import com.rawg.rawgspringbackend.service.RawGAPIService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest(classes = {RawGAPIService.class})
@RunWith(SpringRunner.class)
public class RawGAPIServiceTest {

    @Autowired
    private RawGAPIService service;

    @Test
    public void testGameByIdReturnValueMatch() {
        var mockId = "1";
        Game game = service.getGameById(mockId);
        assertEquals(Integer.parseInt(mockId), game.getId());
    }

    @Test
    public void testGameByIdMalformedId() {
        var mockId = "1L";
        assertThrows(ResponseStatusException.class, () -> {
            service.getGameById(mockId);
        });
    }
}