package model;

import java.util.HashSet;

public class Course {
	private Lecturer lecturer;
	private Room room;
	private HashSet<Student> students;
	
	public Course() {
		
	}
	
	public Course (Lecturer lecturer, Room room) {
		this.lecturer = lecturer;
		this.room = room;
	}
}
