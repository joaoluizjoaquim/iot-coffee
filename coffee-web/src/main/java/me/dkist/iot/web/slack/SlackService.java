package me.dkist.iot.web.slack;

import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;

import me.dkist.iot.web.person.Person;
import me.dkist.iot.web.person.PersonRepository;

@Component
public class SlackService {
	
	@Value("${slack.webhook.url}")
	private String slackWebhookUrl;
	
	private Slack slack = Slack.getInstance();
	
	@Autowired PersonRepository personRepository;
	
	@Async
	public void notifyPersons(List<ObjectId> persons) {
		if (persons == null || persons.size() == 0) return;
		Person maker = personRepository.findById(persons.remove(0));
		sendSlackNotification(maker.getSlackUser(), "Coffee is ready!");
		if(persons.size() > 0) sleep(30000);
		persons.forEach(personId -> {
			Person p = personRepository.findById(personId);
			if(p != null) {
				sendSlackNotification(p.getSlackUser(), "Coffee is ready!");
			}
		});
		sleep(60000);
		sendSlackNotification("#coffee", "Coffee is ready! Thanks to " + maker.getSlackUser());
		
	}

	private void sendSlackNotification(String channel, String message) {
		if(channel.equals("@johndoe")) return;
		
		String url = slackWebhookUrl;
		if(url == null || url.length() == 0) url = System.getenv("SLACK_WEBHOOK_URL");
		if(url == null) return;
		
		Payload payload = Payload.builder().channel(channel).text(message).build();
		try {
			slack.send(url, payload);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sleep(Integer delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
