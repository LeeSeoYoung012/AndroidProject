package org.cafesss.sssmenu;

public class User {
    String id;
    String pw;
    String name;
    String age;
    String phone;
    int point;

    public User(String id, String pw, String name, String age, String phone){
        this.id=id;
        this.pw=pw;
        this.name=name;
        this.age=age;
        this.phone=phone;
        point=0;
    }
    public User(String id, String pw, String name, String age, String phone,int point){
        this.id=id;
        this.pw=pw;
        this.name=name;
        this.age=age;
        this.phone=phone;
        this.point=point;
    }
    User(String id, String pw)
    {
        this.id=id;
        this.pw=pw;
    }
    User(String userId, String name, String phone)
    {
        this.id=userId;
        this.name=name;
        this.phone=phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
