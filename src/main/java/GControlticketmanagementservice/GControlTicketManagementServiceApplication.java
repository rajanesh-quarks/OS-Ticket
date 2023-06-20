package GControlticketmanagementservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.globetouch.iotsmp")
@EnableEurekaClient
@EnableSwagger2
public class GControlTicketManagementServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GControlTicketManagementServiceApplication.class, args);
	}
	@Bean
	DispatcherServlet dispatcherServlet() {     // To allow RequestContextHolder in ClientHttpRequestInterceptor
		DispatcherServlet servlet = new DispatcherServlet();
		servlet.setThreadContextInheritable(true);
		return servlet;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GControlTicketManagementServiceApplication.class);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@LoadBalanced
	@Bean("ticketRestTemplate")
	public RestTemplate ticketService(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

	@LoadBalanced
	@Bean(name = "tokenVerifier")
	public RestTemplate tokenVerifier(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

	

}
