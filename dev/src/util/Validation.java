package util;

import model.Course;

/**
 * Created with IntelliJ IDEA.
 * User: rrd09
 * Date: 20/10/13
 * Time: 21:00
 */
public class Validation {


    public boolean checkCourse(Course course) {
        if (course.getRoom().getCapacity() < course.size()) return false;
        return true;
    }

}
