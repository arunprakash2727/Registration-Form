package RegistrationForm;

import java.sql.*;

public class FormDAO {
    public void getUpdate(int id,String name,String email,String selectedHobbies,String selectedCounty,String gender) throws SQLException {
        Connection conect=DBConnection.getConnection();
        String query="UPDATE USERS SET NAME=?,EMAIL=?,HOBBIES=?,COUNTRY=?,GENDER=? WHERE ID=?";
        PreparedStatement pst=conect.prepareStatement(query);
        pst.setString(1,name);
        pst.setString(2,email);
        pst.setString(3,selectedHobbies);
        pst.setString(4,selectedCounty);
        pst.setString(5,gender);
        pst.setInt(6,id);
        pst.executeUpdate();
    }

    public void getDelete(int id) throws SQLException {
        Connection conect=DBConnection.getConnection();
        String query="DELETE FROM USERS WHERE ID=?";
        PreparedStatement pst=conect.prepareStatement(query);
        pst.setInt(1,id);
        pst.executeUpdate();
    }

    public void getSave(int id,String name,String email,String selectedHobbies,String selectedCountry,String gender) throws SQLException {
        Connection conect=DBConnection.getConnection();
        String query="INSERT INTO USERS VALUES (?,?,?,?,?,?)";
        PreparedStatement pst=conect.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setString(3,email);
        pst.setString(4,selectedHobbies);
        pst.setString(5,selectedCountry);
        pst.setString(6,gender);
        pst.executeUpdate();
    }

    public ResultSet getDisplay(int id) throws SQLException {
        Connection conect=DBConnection.getConnection();
        String query="SELECT * FROM USERS WHERE ID="+id;
        Statement st=conect.createStatement();
        ResultSet result=st.executeQuery(query);
        return result;
    }
}
