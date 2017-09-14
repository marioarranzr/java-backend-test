package com.test.java.lampkicking.model;

import java.util.ArrayList;
import java.util.List;

public class RoombaRequest {

	private List<Integer> roomSize = new ArrayList<>();
	private List<Integer> coords = new ArrayList<>();
	private List<List<Integer>> patches = new ArrayList<>();
	private String instructions;

	public List<Integer> getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(List<Integer> roomSize) {
		this.roomSize = roomSize;
	}

	public List<Integer> getCoords() {
		return coords;
	}
	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

	public List<List<Integer>> getPatches() {
		return patches;
	}
	public void setPatches(List<List<Integer>> patches) {
		this.patches = patches;
	}

	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
