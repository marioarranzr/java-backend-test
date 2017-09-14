package com.test.java.lampkicking;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.test.java.lampkicking.RoombaApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RoombaApp.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RoombaIntegrationTest {

	@Value("${local.server.port}")
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void shouldSolveRoboHoover() {
		Response response = given()
				.contentType("application/json").
						body("{\n" +
								"  \"roomSize\" : [5, 5],\n" +
								"  \"coords\" : [1, 2],\n" +
								"  \"patches\" : [\n" +
								"    [1, 0],\n" +
								"    [2, 2],\n" +
								"    [2, 3]\n" +
								"  ],\n" +
								"  \"instructions\" : \"NNESEESWNWW\"\n" +
								"}").
						when().
						post("/instructions");

		assertThat(response.getBody().asString(), is("{\"coords\":[1,3],\"patches\":1}"));
	}

}
