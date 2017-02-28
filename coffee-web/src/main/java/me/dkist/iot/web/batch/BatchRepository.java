package me.dkist.iot.web.batch;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BatchRepository extends MongoRepository<Batch, String> {
	
	@Query("{ 'status' : {$in : ['PENDING', 'IN_PRODUCTION'] }}")
	List<Batch> findOpenBatches(Sort sort);
	
	@Query("{ 'status' : {$in : ['PENDING', 'IN_PRODUCTION'] }}")
	Batch findOpenBatch();

}
