package de.gruemme.spring.blog.repository;

import de.gruemme.spring.blog.model.Entry;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository to sync entry objects with the database.
 *
 * @author <a href="mailto:chrisitan.gruemme@gmx.com">Christian Gruemme</a>
 */
public interface EntryRepository extends CrudRepository<Entry, Long> {

}
