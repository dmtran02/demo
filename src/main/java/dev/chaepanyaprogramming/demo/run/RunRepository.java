package dev.chaepanyaprogramming.demo.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    // This annotation is used to mark a method that needs to be executed after dependency injection is done to perform any initialization.
    private void init() {
        runs.add(new Run(1,
                "First Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                5,
                Location.INDOOR));
        runs.add(new Run(2,
                "Second Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                3,
                Location.OUTDOOR));
    }
}
