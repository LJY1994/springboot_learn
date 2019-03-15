package cn.sf.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/12 16:07
 */
@Entity
public class User {

    public Integer getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String userCardId;

    @Column(nullable = false)
    private String userName;

    private String userDesc;

    @Column(nullable = false)
    private int userAge;

    public User(){

    }

    public User(String userCardId, String userName, String userDesc, int userAge) {
        this.userCardId = userCardId;
        this.userName = userName;
        this.userDesc = userDesc;
        this.userAge = userAge;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userCardId='" + userCardId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
