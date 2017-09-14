package com.test.java.lampkicking.controller;

import com.test.java.lampkicking.model.RoombaRequest;
import com.test.java.lampkicking.model.RoombaResponse;
import com.test.java.lampkicking.service.RoombaService;
import com.test.java.lampkicking.validator.RoombaRequestValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructions")
public class RoombaController {

	private RoombaService roombaService;

	@Autowired
	public RoombaController(RoombaService roombaService) {
		this.roombaService = roombaService;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RoombaRequestValidator());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public RoombaResponse request(@RequestBody @Validated RoombaRequest request) {
		return roombaService.process(request);
	}

}
