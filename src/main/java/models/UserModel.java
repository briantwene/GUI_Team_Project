package models;

// user model that is used to keep track of the current user that is logged into the application
public class UserModel {

    private int userId; // id of the user
    private String username; // username, first name last name fields
    private String firstname;
    private String lastname;
    private String gender; // gender
    private String Role; // role
    private int rentId; // rentId

    public UserModel(int userId, String username, String firstname, String lastname, String gender, String Role,
            int rentId2) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.Role = Role;
        this.rentId = rentId2;
    }

    // getter and setter methods
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

}
