/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author mario
 */
public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private String user_name;
    private String password_user;
    private String email;
    private double salary_employee;
    private String address;
    private String phone;
    private String state;
    private String type_user;
    
    public User(){}

    // Constructor

    public User(String first_name, String last_name, String user_name, String password_user, String email, double salary_employee, String address, String phone, String type_user) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.password_user = password_user;
        this.email = email;
        this.salary_employee = salary_employee;
        this.address = address;
        this.phone = phone;
        this.type_user = type_user;
    }

    public User(int user_id, String first_name, String last_name, String user_name, String password_user, String email, double salary_employee, String address, String phone, String type_user) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.password_user = password_user;
        this.email = email;
        this.salary_employee = salary_employee;
        this.address = address;
        this.phone = phone;
        this.type_user = type_user;
    }
    

    
    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }
    // Getters y setters (opcional)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary_employee() {
        return salary_employee;
    }

    public void setSalary_employee(double salary_employee) {
        this.salary_employee = salary_employee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }
    
}
