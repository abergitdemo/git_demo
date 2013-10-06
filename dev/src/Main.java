import model.Student;

public class Main {

    private static final String root = ".";
    private static int count = 0;
    private static boolean forward = true;

    public static void main(String[] args) {
        System.out.println("test 0");

        while (count < 20) {
            System.out.println("test " + count);
            count();
        }

        Student student = new Student();
        student.setFirstName("ABCDEF");
        student.setLastName("abc");
        
    }
    
    public static void count () {
    	count++;
    }
    
    public static void reset() {
    	count = 0;
    }

    public static void inverse() {
        forward = !forward;
    }
}
