package com.test.java.lampkicking.service;

import org.springframework.stereotype.Component;

import com.test.java.lampkicking.model.RoombaResponse;
import com.test.java.lampkicking.model.RoombaSolution;

import static java.util.Arrays.asList;

@Component
public class RoombaSolutionToResponseTransformer {

	public RoombaResponse transform(RoombaSolution solution) {
		RoombaResponse output = new RoombaResponse();
		output.setCoords(asList(solution.getPosition().getX(), solution.getPosition().getY()));
		output.setPatches(solution.getPatches());
		return output;
	}

}
