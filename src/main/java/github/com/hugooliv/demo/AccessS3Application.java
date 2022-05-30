package github.com.hugooliv.demo;

import github.com.hugooliv.demo.service.UploadS3Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages={"github.com.hugooliv.*"})
public class AccessS3Application implements CommandLineRunner {

	@Autowired
	private UploadS3Job job;

	public static void main(String[] args) {
		try {
			SpringApplication app = new SpringApplication(AccessS3Application.class);
			app.run(args);

			log.info("Finalizando servico...");

			System.exit(0);

		} catch(Exception e) {
			log.info("Finalizando serviço com ERRO...");
			log.error(e.getMessage(), e);
			System.exit(1);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		this.job.process(args);
	}
}
