package de.gruemme.spring.blog.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller query the title of the application.
 *
 * @author <a href="mailto:christian.gruemme@gmx.com">Christian Gruemme</a>
 */
@RestController
@Slf4j
public class TitleController {

  @Autowired
  private Environment environment;

  @GetMapping(path = "/title")
  public String getTitle() {
    String title = environment.getProperty("BLOG_TITLE", "My Blog");
    log.info("request for title: " + title);
    return title;
  }
}
