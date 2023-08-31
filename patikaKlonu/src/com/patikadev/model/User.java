package com.patikadev.model;

import com.patikadev.helper.DBConnector;
import com.patikadev.helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String uname;
    private String password;
    private String type;

    public User(int id, String name, String uname, String password, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.type = type;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getUserList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user_table";
        User obj;
        try {

            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("user_name"));
                obj.setUname(rs.getString("user_username"));
                obj.setPassword(rs.getString("user_password"));
                obj.setType(rs.getString("user_type"));

                userList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    public static boolean add(String name, String uname, String password, String type) {
        String query = "INSERT INTO user_table (user_name, user_username, user_password, user_type) VALUES(?,?,?,?)";

        User findUser = User.getFetch(uname);
        if (findUser != null){
            Helper.showMsg("Bu kullanıcı adı daha önce eklenmiş. Yeniden deneyin.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, password);
            pr.setString(4, type);

            int response = pr.executeUpdate();

            return response != -1;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static User getFetch(String uname){
        User obj = null;
        String query = "SELECT * FROM user_table WHERE user_username = ? ";
        try{
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("user_name"));
                obj.setUname(rs.getString("user_username"));
                obj.setPassword(rs.getString("user_password"));
                obj.setType(rs.getString("user_type"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static boolean delete(int id){
        String query = "DELETE FROM user_table WHERE id = ?";
        try {
        PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
        pr.setInt(1, id);
        return pr.executeUpdate() != -1;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;


    }
}
