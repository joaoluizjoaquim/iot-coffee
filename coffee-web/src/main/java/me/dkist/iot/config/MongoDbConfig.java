package me.dkist.iot.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import me.dkist.iot.App;

@Configuration
@EnableMongoRepositories(basePackageClasses = App.class)
public class MongoDbConfig extends AbstractMongoConfiguration {

	public @Bean Mongo mongo() throws UnknownHostException {
		return new MongoClient(System.getenv("MONGODB_SERVER"));
	}

	@Override
	protected String getDatabaseName() {
		return "iot-coffee";
	}
}