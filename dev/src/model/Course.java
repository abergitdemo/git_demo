package model;

import java.util.HashSet;

public class Course {
	private Lecturer lecturer;
	private Room room;
	private HashSet<Student> students;
    private String title;

    public Course() {
		
	}
	
	public Course (Lecturer lecturer, Room room) {
		this.lecturer = lecturer;
		this.room = room;
        this.students = new HashSet<Student>();
	}

    public boolean addStudent(Student student) {
        if (students.size() >= room.getCapacity()) return false;
        students.add(student);
        return true;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
