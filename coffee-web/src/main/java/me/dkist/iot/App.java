
package me.dkist.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("Webhook Slack: " + System.getProperty("SLACK_WEBHOOK_URL"));
		SpringApplication.run(App.class, args);
	}
}