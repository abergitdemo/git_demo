package model;

import java.util.HashSet;

public class Course extends HashSet<Student>{
    private Lecturer lecturer;
    private Room room;
    private String title;

    public Course() {

    }

    public Course(Lecturer lecturer, Room room) {
        super();
        this.lecturer = lecturer;
        this.room = room;
    }

    public boolean addStudent(Student student) {
        if (super.size() >= room.getCapacity()) return false;
        super.add(student);
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
