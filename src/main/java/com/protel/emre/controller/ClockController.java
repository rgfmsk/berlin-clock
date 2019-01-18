package com.protel.emre.controller;

import com.protel.emre.entity.BerlinClock;
import com.protel.emre.util.ClockUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for the webservice api of Berlin Clock Application
 *
 * @author Emre Ozdemir
 * @version 1.0
 * @since 2018-10-22
 */
@RestController
@RequestMapping("/api")
public class ClockController {


    /**
     * Returns BerlinClock time format of either given time or the current time
     * with the help of the optional time parameter
     *
     * @param time Optional time parameterr
     * @return [BerlinClock]
     */
    @RequestMapping(value = {"/berlinClock"}, method = RequestMethod.GET, produces = "application/json")
    public BerlinClock berlinClock(@RequestParam Optional<String> time) {
        ClockUtil cu = new ClockUtil(time);
        return new BerlinClock(cu.getBerlinFormat());
        //new push branch commit
    }
}
