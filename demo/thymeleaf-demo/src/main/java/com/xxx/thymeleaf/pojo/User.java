package com.xxx.thymeleaf.pojo;

/**
 * @author Renda Zhang
 * @create 2020-05-11 18:38
 */
public class User {
    private String name;
    private int age;
    private User friend;// 对象类型属性
    private Boolean sex;
    private String role;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, User friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public User(String name, int age, User friend, Boolean sex, String role) {
        this.name = name;
        this.age = age;
        this.friend = friend;
        this.sex = sex;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String name, int age, User friend, Boolean sex) {
        this.name = name;
        this.age = age;
        this.friend = friend;
        this.sex = sex;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
