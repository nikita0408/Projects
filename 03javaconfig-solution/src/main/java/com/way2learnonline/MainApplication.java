package com.way2learnonline;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.way2learnonline.service.BankService;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(MainApplication.class);
		BankService bankService = context.getBean(BankService.class);
		bankService.transfer(1L, 2L, 3000);
	}

}
