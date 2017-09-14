package com.test.java.lampkicking.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.java.lampkicking.model.RoombaRequest;

public interface RoombaRequestRepository extends MongoRepository<RoombaRequest, String> {

	RoombaRequest save(RoombaRequest request);

}
