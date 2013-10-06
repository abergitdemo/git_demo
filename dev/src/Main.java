import model.Student;

public class Main {

    private static final String root = ".";
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("test 0");

        while (count < 20) {
            System.out.println("test " + count);
            count();
        }

        Student student = new Student();
        student.setFirstName("ABCDE");
        
    }
    
    public static void count () {
    	count++;
    }

}
