package model;

/**
 * Created with IntelliJ IDEA.
 * User: rrd09
 * Date: 06/10/13
 * Time: 21:42
 */
public class People {
    private String firstName;
    private String lastName;

    public People() {
    }

    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
