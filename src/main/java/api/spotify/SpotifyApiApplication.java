package api.spotify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.Date;
import java.util.Locale;

@EnableFeignClients
@EnableWebMvc
@SpringBootApplication
public class SpotifyApiApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOGGER.info("-------------SUBIU-------------");
		LOGGER.info(String.valueOf(new Date()).concat(new Locale(" pt", "BR").toString()));
	}
}