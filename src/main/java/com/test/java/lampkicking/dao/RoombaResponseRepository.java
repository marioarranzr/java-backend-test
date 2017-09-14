package com.test.java.lampkicking.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.java.lampkicking.model.RoombaResponse;

public interface RoombaResponseRepository extends MongoRepository<RoombaResponse, String> {

	RoombaResponse save(RoombaResponse response);

}
