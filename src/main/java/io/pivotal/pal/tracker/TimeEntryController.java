package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return created(null).body(timeEntryRepository.create(timeEntry));
    }

    @DeleteMapping("/{timeEntryId}")
    public ResponseEntity<Void> delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return noContent().build();
    }

    @GetMapping("/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        var te = timeEntryRepository.find(timeEntryId);
        return te == null ? notFound().build() : ok(te);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return ok(timeEntryRepository.list());
    }

    @PutMapping("/{timeEntryId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeEntry) {
        TimeEntry te = timeEntryRepository.update(timeEntryId, timeEntry);
        return te == null ? notFound().build(): ok(te);
    }
}
