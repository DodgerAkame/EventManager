package simon.remy.ensisa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@Import(RepositoryRestMvcConfiguration.class)
@EnableJpaRepositories
@SpringBootApplication
public class Application {
	
	@Autowired
	JdbcTemplate jdbc;

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	
	
	/*@Override
	public void run(String... arg0) throws Exception {
		jdbc.execute("DROP TABLE events IF EXISTS");
		jdbc.execute("CREATE TABLE events( id SERIAL, date DATE, title VARCHAR(255), hours INTEGER, lieu VARCHAR(255), type VARCHAR(255))");
		
	}

	@Bean
	public CommandLineRunner demo(EventRepository repository){
		return (args)-> {
			repository.save(new Event("05/02/2017","YO","YO",1,"ICI","JSP"));
			repository.save(new Event("06/02/2017","YO","YO",1,"ICI","JSP"));
			log.info("Commande findAll()");
			log.info("-------------------");
			for(Event e : repository.findAll()){
				log.info(e.getDescription());
			}
		};
		
	}*/
	
	
}
