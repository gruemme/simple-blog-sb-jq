package de.gruemme.spring.blog.endpoint;

import de.gruemme.spring.blog.model.Entry;
import de.gruemme.spring.blog.repository.EntryRepository;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * REST controller to create an REST endpoint, so that the web ui can
 * communicate with the spring backend.
 *
 * @author <a href="mailto:christian.gruemme@gmx.com">Christian Gruemme</a>
 */
@RestController
@Slf4j
public class EntryController {

    /**
     * Database interface provided by dependency injection.
     */
    @Autowired
    private EntryRepository entryRepository;

    /**
     * Returns all Entry entries in the database.
     *
     * Returns a JSON (-Array) representation when performing a HTTP-GET on
     * http://localhost:8080/entries.
     *
     * @return all images in the database
     */
    @GetMapping(path = "/entries", produces = "application/json")
    public Iterable<Entry> getAllEntries() {
        log.info("query all Entries");
        return entryRepository.findAll();
    }

    /**
     * Reads one Entry by ID.
     *
     * Returns a JSON representation when performing a HTTP-GET.
     * <br /> Example: http://localhost:8080/entry/2 for the Entry with the ID
     * 2.
     * <br />
     * When no Entry is found a HTTP 404 is returned.
     *
     * @param id ID of the Entry to get
     * @return the Entry with the given ID
     */
    @GetMapping(path = "/entry/{id}", produces = "application/json")
    public Entry getEntry(@PathVariable Long id) {
        log.info("query entry with id " + id);
        return entryRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID " + id + " unknown")
                );
    }


    /**
     * Creates an Entry entry in the database.
     *
     * Expects an entry in JSON format and will convert it automatically into a
     * Java Entry object and saves it to the database via the repository.
     *
     * @param entry Data for the Entry to create
     * @return The ID for the Entry that has been created
     */
    @PutMapping(path = "/entries", consumes = "application/json", produces = "application/json")
    public Long createImage(@RequestBody Entry entry) {
        entry.setId(null);
        entry.setCreated(new Date());
        entryRepository.save(entry);
        log.info("saved new entry with id " + entry.getId());

        return entry.getId();
    }

    /**
     * Deletes an Entry by ID.
     *
     * Deletes an Entry when perfoming a HTTP-DELETE.
     * <br /> Example: http://localhost:8080/entry/2 for the Entry with the ID
     * 2.
     * <br />
     * When no Entry is found a HTTP 404 is returned.
     *
     * @param id ID of the Entry to be deleted
     */
    @DeleteMapping(path = "/entry/{id}")
    public void deleteImage(@PathVariable Long id) {
        log.info("delete entry with id " + id);
        entryRepository.deleteById(id);
    }
}
