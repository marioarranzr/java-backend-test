package com.test.java.lampkicking.service;

import org.junit.Before;
import org.junit.Test;

import com.test.java.lampkicking.model.Point2D;
import com.test.java.lampkicking.model.RoombaResponse;
import com.test.java.lampkicking.model.RoombaSolution;
import com.test.java.lampkicking.service.RoombaSolutionToResponseTransformer;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoombaSolutionToResponseTransformerTest {

	private RoombaSolutionToResponseTransformer transformer;

	@Before
	public void setUp() {
		transformer = new RoombaSolutionToResponseTransformer();
	}

	@Test
	public void shouldTransform() {
		// given
		RoombaSolution solution = new RoombaSolution(new Point2D(3, 5), 2);

		// when
		RoombaResponse response = transformer.transform(solution);

		// then
		assertThat(response.getPatches(), is(2));
		assertThat(response.getCoords(), is(asList(3, 5)));
	}

}