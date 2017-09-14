package com.test.java.lampkicking.service;

import org.junit.Before;
import org.junit.Test;

import com.test.java.lampkicking.model.Point2D;
import com.test.java.lampkicking.model.RoombaConfig;
import com.test.java.lampkicking.model.RoombaRequest;
import com.test.java.lampkicking.service.RoombaRequestToConfigTransformer;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoombaRequestToConfigTransformerTest {

	private RoombaRequestToConfigTransformer transformer;

	@Before
	public void setUp() {
		transformer = new RoombaRequestToConfigTransformer();
	}

	@Test
	public void shouldTransform() {
		// given
		RoombaRequest request = new RoombaRequest();
		request.setRoomSize(asList(2, 3));
		request.setCoords(asList(1, 1));
		request.setPatches(asList(asList(1, 2), asList(0, 1)));
		request.setInstructions("EWSN");

		// when
		RoombaConfig config = transformer.transform(request);

		// then
		assertThat(config.getOrigin(), is(new Point2D(0, 0)));
		assertThat(config.getCorner(), is(new Point2D(1, 2)));
		assertThat(config.getSource(), is(new Point2D(1, 1)));
		assertThat(config.getInstructions(), is("EWSN"));
		assertThat(config.getPatches(), is(new ArrayList<>(asList(new Point2D(1, 2), new Point2D(0, 1)))));
	}

}