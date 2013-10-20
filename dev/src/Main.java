import model.Course;
import model.Room;
import model.Student;

public class Main {

    private static final String root = ".";
    private static int count = 0;
    private static boolean forward = true;

    public static void main(String[] args) {
        System.out.println("test 0");

        while (count < 40) {
            Course course = new Course();
            System.out.println("test " + count);
            Student student = new Student("A" + count, "abc");
            System.out.println(student.getFirstName());
            course.addStudent(student);
            count();
        }

        Student student = new Student("xyz", "abc");
        System.out.println(student.getFirstName());

        Course course = new Course();
        Room room = new Room();
        course.setRoom(room);
        course.setTitle("Git Tutorial");

        System.out.println(course.getTitle());
    }

    public static void count() {
        count++;
    }

    public static void reset() {
        count = 0;
    }

    public static void inverse() {
        forward = !forward;
    }

}
