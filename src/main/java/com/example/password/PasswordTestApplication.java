package com.example.password;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PasswordTestApplication implements CommandLineRunner {

	@Value("${spring.datasource.password}")
	private String password;

	@Autowired
	private StringEncryptor encryptor;

	public static void main(String[] args) {
		SpringApplication.run(PasswordTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("The value of password is ["+ password+"]");

		String msg = encryptor.encrypt("readme");
		log.info("The encrypted value is ["+msg+"]");
	}
}
