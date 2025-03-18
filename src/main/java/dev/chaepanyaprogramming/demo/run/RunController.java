package dev.chaepanyaprogramming.demo.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);

        if(run.isEmpty()) {
            throw new RunNotFoundException(id);
        }
        return run.get();
    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@Valid  @RequestBody Run run) {
        runRepository.create(run);
    }

    // put
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody Run run, @PathVariable Integer id) {
        Optional<Run> existingRun = runRepository.findById(run.id());
        if(existingRun.isEmpty()) {
            throw new RunNotFoundException(id);
        }
        runRepository.update(run);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        Optional<Run> existingRun = runRepository.findById(id);
        if(existingRun.isEmpty()) {
            throw new RunNotFoundException(id);
        }
        runRepository.delete(id);
    }

}
