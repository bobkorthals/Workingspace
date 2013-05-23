/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.util.Date;

/**
 *
 * @author jkg
 */
public class Person {

    private String firstName;
    private String lastName;
    private String suffix;
    private String gender;
    private String dateOfBrith;
    
    private int age;

    public Person(String firstName, String lastName, String suffix, String gender, String dateOfBrith) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix=suffix;
        this.dateOfBrith=dateOfBrith;
        this.gender=gender;


    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String Suffix) {
        this.suffix = Suffix;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }
}
