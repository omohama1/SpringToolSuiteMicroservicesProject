package com.obmohamad.photoapp.api.acctmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAccoutManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccoutManagementApplication.class, args);
	}

}
