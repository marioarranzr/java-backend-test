package com.test.java.lampkicking.model;

import java.util.List;

public class RoombaResponse {

	private List<Integer> coords;
	private int patches;

	public List<Integer> getCoords() {
		return coords;
	}
	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

	public int getPatches() {
		return patches;
	}
	public void setPatches(int patches) {
		this.patches = patches;
	}

}
