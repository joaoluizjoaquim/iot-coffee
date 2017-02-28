package me.dkist.iot.web.person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	@Query("{ 'slackUser' : ?0 }")
	List<Person> findUsersBySlack(String slackUser);

}
