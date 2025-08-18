package com.jp.posto_combustivel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class PostoCombustivelApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(PostoCombustivelApplication.class);
		Environment env = app.run(args).getEnvironment();

		String info = """
				\n------------------------------------------------------------------------------------------------------
				 Application {} is running!
				--------------------------------------------------------------------------------------------------------
				Access URLs:
					Local:\t\thttp://localhost:{}{}/swagger-ui/index.html
					External:\thttp://{}:{}{}/swagger-ui/index.html
				--------------------------------------------------------------------------------------------------------
				""";
		log.info(info, env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				env.getProperty("server.servlet.context-path"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getProperty("server.servlet.context-path"));
	}

}
