package me.dkist.iot.web.person;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	@Query("{ 'slackUser' : ?0 }")
	Person findUsersBySlack(String slackUser);
	
	@Query("{ 'rfid' : ?0 }")
	Person findUsersByRfid(String rfid);
	
	Person findById(ObjectId id);

}
