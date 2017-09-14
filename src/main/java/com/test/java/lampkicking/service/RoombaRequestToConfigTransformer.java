package com.test.java.lampkicking.service;

import org.springframework.stereotype.Component;

import com.test.java.lampkicking.model.Point2D;
import com.test.java.lampkicking.model.RoombaConfig;
import com.test.java.lampkicking.model.RoombaRequest;

import static java.util.stream.Collectors.toList;

@Component
public class RoombaRequestToConfigTransformer {

	public RoombaConfig transform(RoombaRequest request) {
		RoombaConfig config = new RoombaConfig();
		config.setOrigin(new Point2D(0, 0));
		config.setCorner(new Point2D(request.getRoomSize().get(0) - 1, request.getRoomSize().get(1) - 1));
		config.setSource(new Point2D(request.getCoords().get(0), request.getCoords().get(1)));
		config.setInstructions(request.getInstructions());
		config.setPatches(request.getPatches().stream().map(it -> new Point2D(it.get(0), it.get(1))).collect(toList()));
		return config;
	}

}
