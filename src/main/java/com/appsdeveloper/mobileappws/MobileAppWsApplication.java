package com.appsdeveloper.mobileappws;

import com.appsdeveloper.mobileappws.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Configuration

public class MobileAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}
        
        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder(){
            return new BCryptPasswordEncoder();
        }
        
        @Bean
        public SpringApplicationContext springApplicationContext()
        {
            return new SpringApplicationContext();
        }
        
        @Bean (name="AppProperties")
        public AppProperties getAppProperties()
        {
            return new AppProperties();
        }

}
