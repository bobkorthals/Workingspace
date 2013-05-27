package pas.models.role;

/**
 *
 * @author jkg
 */
public class Employee extends AbsractPerson {

    private String function;

    public Employee(String firstName, String lastName, String suffix, String dateOfBirth, String gender, int employeeID, String function) {
        super(firstName, lastName, suffix, dateOfBirth, gender);
        this.function = function;
        this.employeeID = employeeID;

    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    private int employeeID;
}
