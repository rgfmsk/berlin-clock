package com.protel.emre.controller;

import com.protel.emre.entity.BerlinClock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tester class of webservice api
 *
 * @author Emre Ozdemir
 * @version 1.0
 * @since 2018-10-22
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ClockController.class)
public class ClockControllerTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    @MockBean
    private ClockController clockController;

    @Autowired
    private MockMvc mvc;

    /**
     * Test for the get method /api/berlinClock with confirmation of the result
     */
    @Test
    public void testRest() {
        BerlinClock ret = new BerlinClock("O" +
                NEW_LINE +
                "RRRR" +
                NEW_LINE +
                "RROO" +
                NEW_LINE +
                "YYRYOOOOOOO" +
                NEW_LINE +
                "YOOO" +
                NEW_LINE);

        given(clockController.berlinClock(Optional.of("22:21:42"))).willReturn(ret);
    }

    /**
     * Test for the /api/berlinClock method without a parameter
     *
     * @throws Exception mock.Perform throws
     */
    @Test
    public void testRest2() throws Exception {
        mvc.perform(get("/api/berlinClock"))
                .andExpect(status().isOk());
    }

}
