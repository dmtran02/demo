package dev.chaepanyaprogramming.demo.run;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RunController {

    private final RunRepository runRepository;

    RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    List<Run> findAll() {
        return runRepository.findAll();
    }

}
