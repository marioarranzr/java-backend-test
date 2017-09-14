package com.test.java.lampkicking.service;

import com.test.java.lampkicking.dao.RoombaRequestRepository;
import com.test.java.lampkicking.dao.RoombaResponseRepository;
import com.test.java.lampkicking.model.*;
import com.test.java.lampkicking.service.RoombaProcessor;
import com.test.java.lampkicking.service.RoombaRequestToConfigTransformer;
import com.test.java.lampkicking.service.RoombaService;
import com.test.java.lampkicking.service.RoombaSolutionToResponseTransformer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static java.util.Arrays.asList;

@RunWith(MockitoJUnitRunner.class)
public class RoombaServiceTest {

	private RoombaService service;

	@Mock private RoombaRequestRepository requestRepository;
	@Mock private RoombaResponseRepository responseRepository;
	@Mock private RoombaProcessor processor;
	@Mock private RoombaRequestToConfigTransformer requestToConfigTransformer;
	@Mock private RoombaSolutionToResponseTransformer solutionToResponseTransformer;

	private RoombaConfig config = new RoombaConfig();
	private RoombaSolution solution = new RoombaSolution(new Point2D(3, 5), 2);
	private RoombaResponse response = new RoombaResponse();

	@Before
	public void setUp() {
		service = new RoombaService(requestRepository, responseRepository, processor, requestToConfigTransformer, solutionToResponseTransformer);
	}

	@Test
	public void shouldOrchestrateRequest() {
		// given
		RoombaRequest request = givenValidRequest();

		given(requestToConfigTransformer.transform(request)).willReturn(config);
		given(processor.process(config)).willReturn(solution);
		given(solutionToResponseTransformer.transform(solution)).willReturn(response);

		// when
		RoombaResponse result = service.process(request);

		// then
		verify(requestRepository).save(request);
		assertThat(result, is(response));
		verify(responseRepository).save(response);
	}

	private RoombaRequest givenValidRequest() {
		RoombaRequest request = new RoombaRequest();
		request.setRoomSize(asList(2, 3));
		request.setCoords(asList(1, 1));
		request.setPatches(asList(asList(1, 1)));
		request.setInstructions("EWSN");
		return request;
	}

}