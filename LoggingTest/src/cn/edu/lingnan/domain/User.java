package cn.edu.lingnan.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private Date birthday;

    public User(String username, String password, Date birthday) {
//        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public User() {
    }

    /**
     * 逻辑视图
     * @return
     */
    public String getBirToStr(){
        if (birthday!=null){
            //格式化日期对象
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //返回字符串
            return simpleDateFormat.format(birthday);
        }else {
            return "";
        }
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
