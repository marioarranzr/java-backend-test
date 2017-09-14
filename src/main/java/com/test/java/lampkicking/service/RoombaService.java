package com.test.java.lampkicking.service;

import com.test.java.lampkicking.dao.RoombaRequestRepository;
import com.test.java.lampkicking.dao.RoombaResponseRepository;
import com.test.java.lampkicking.model.RoombaRequest;
import com.test.java.lampkicking.model.RoombaResponse;
import com.test.java.lampkicking.model.RoombaSolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoombaService {

	private RoombaRequestRepository requestRepository;
	private RoombaResponseRepository responseRepository;
	private RoombaProcessor processor;
	private RoombaRequestToConfigTransformer requestToConfigTransformer;
	private RoombaSolutionToResponseTransformer solutionToResponseTransformer;

	@Autowired
	public RoombaService(RoombaRequestRepository requestRepository, RoombaResponseRepository responseRepository, RoombaProcessor processor,
							 RoombaRequestToConfigTransformer requestToConfigTransformer, RoombaSolutionToResponseTransformer solutionToResponseTransformer) {
		this.requestRepository = requestRepository;
		this.responseRepository = responseRepository;
		this.processor = processor;
		this.requestToConfigTransformer = requestToConfigTransformer;
		this.solutionToResponseTransformer = solutionToResponseTransformer;
	}

	public RoombaResponse process(RoombaRequest request) {
		requestRepository.save(request);
		RoombaSolution solution = processor.process(requestToConfigTransformer.transform(request));
		RoombaResponse response = solutionToResponseTransformer.transform(solution);
		responseRepository.save(response);
		return response;
	}

}
