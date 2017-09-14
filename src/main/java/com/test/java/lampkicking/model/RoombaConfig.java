package com.test.java.lampkicking.model;

import java.util.ArrayList;
import java.util.List;

public class RoombaConfig {

	private Point2D origin;

	private Point2D corner;

	private Point2D source;

	private List<Point2D> patches = new ArrayList<>();

	private String instructions;

	public Point2D getOrigin() {
		return origin;
	}
	public void setOrigin(Point2D origin) {
		this.origin = origin;
	}

	public Point2D getCorner() {
		return corner;
	}
	public void setCorner(Point2D corner) {
		this.corner = corner;
	}

	public Point2D getSource() {
		return source;
	}
	public void setSource(Point2D source) {
		this.source = source;
	}

	public List<Point2D> getPatches() {
		return patches;
	}
	public void setPatches(List<Point2D> patches) {
		this.patches = patches;
	}

	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
