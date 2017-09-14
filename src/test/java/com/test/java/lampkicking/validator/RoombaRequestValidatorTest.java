package com.test.java.lampkicking.validator;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import com.test.java.lampkicking.validator.RoombaRequestValidator;
import com.test.java.lampkicking.model.RoombaRequest;

import java.util.HashMap;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoombaRequestValidatorTest {

	private RoombaRequestValidator validator;

	private RoombaRequest request;

	private BindingResult bindingResult;

	@Before
	public void setUp() {
		validator = new RoombaRequestValidator();
		request = new RoombaRequest();
		request.setInstructions(random(10, 'S', 'N', 'E', 'W'));

		bindingResult = new MapBindingResult(new HashMap<>(), "roboHooverRequest");
	}

	@Test
	public void shouldRejectMissingRoomSize() {
		// given
		request.setCoords(asList(2, 3));

		// when
		validator.validate(request, bindingResult);

		// then
		assertThat(bindingResult.hasErrors(), is(true));
		assertThat(bindingResult.getFieldErrors().size(), is(1));
		assertThat(bindingResult.getFieldError("roomSize"), notNullValue());
	}

	@Test
	public void shouldRejectMissingInitialCoordinates() {
		// given
		request.setRoomSize(asList(2, 3));

		// when
		validator.validate(request, bindingResult);

		// then
		assertThat(bindingResult.hasErrors(), is(true));
		assertThat(bindingResult.getFieldErrors().size(), is(1));
		assertThat(bindingResult.getFieldError("coords"), notNullValue());
	}

	@Test
	public void shouldRejectInvalidPatches() {
		// given
		request.setRoomSize(asList(2, 3));
		request.setCoords(asList(1, 1));
		request.setPatches(asList(asList(1, 1, 1)));

		// when
		validator.validate(request, bindingResult);

		// then
		assertThat(bindingResult.hasErrors(), is(true));
		assertThat(bindingResult.getFieldErrors().size(), is(1));
		assertThat(bindingResult.getFieldError("patches"), notNullValue());
	}

	@Test
	public void shouldRejectInvalidInstructions() {
		// given
		request.setRoomSize(asList(2, 3));
		request.setCoords(asList(1, 1));
		request.setPatches(asList(asList(1, 1)));
		request.setInstructions("EWSN" + randomAlphanumeric(1));

		// when
		validator.validate(request, bindingResult);

		// then
		assertThat(bindingResult.hasErrors(), is(true));
		assertThat(bindingResult.getFieldErrors().size(), is(1));
		assertThat(bindingResult.getFieldError("instructions"), notNullValue());
	}

}