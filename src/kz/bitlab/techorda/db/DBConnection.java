package kz.bitlab.techorda.db;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sprint_task_4_2",
                    "root",
                    "root");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Items> getItems(){
        ArrayList<Items> items = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Items item = new Items();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public static Users getUser(String email) {
        Users  user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ?"
            );
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("fullName"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void addUser(Users user){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users ( email, password, fullName) "+
                            "VALUES (?,?,?)"
            );
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteUser(int id){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE  FROM  users WHERE id=?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
