package de.gruemme.spring.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import lombok.Data;

/**
 * Database model for an entry.
 *
 * @author <a href="mailto:christian.gruemme@gmx.com">Christian Gruemme</a>
 */
@Entity
@Data
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date created;

    @Column(length = 4000)
    private String text;
}
