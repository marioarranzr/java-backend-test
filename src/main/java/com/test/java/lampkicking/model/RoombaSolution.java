package com.test.java.lampkicking.model;

public class RoombaSolution {

	private final Point2D position;

	private final int patches;

	public RoombaSolution(Point2D position, int patches) {
		this.position = position;
		this.patches = patches;
	}

	public Point2D getPosition() {
		return position;
	}

	public int getPatches() {
		return patches;
	}

}
