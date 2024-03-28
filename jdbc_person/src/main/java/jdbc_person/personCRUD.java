package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class personCRUD {
	person person= new person();
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;
		
	}
	public int signUpPerson(person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("Insert into person values(?,?,?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhno());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setString(5, person.getPass());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
		
		
		
	}
	public String getPass (String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from person where email=?");
		preparedStatement.setString(1, email);
		ResultSet resultset = preparedStatement.executeQuery();
		String pass = null;
		while(resultset.next()) {
			pass = resultset.getString("pass");
		}
		connection.close();
		return pass;
		
	}
	
		
		public person getInfo(String email) throws Exception {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from person where email=?");
             
			preparedStatement.setString(1, email);
            ResultSet resultset = preparedStatement.executeQuery();
            while(resultset.next()) {
            person.setId(resultset.getInt("id"));
            person.setName(resultset.getString("name"));
            
            person.setPhno(resultset.getLong("phno"));
            
            person.setEmail(resultset.getString("email"));
            
            person.setPass(resultset.getString("pass"));
            
            
            
            }
    		connection.close();
			return person;
		}
		public int updatePassword(String email,String pass) throws Exception {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("update person set pass where email=?");
             
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pass);
            int result = preparedStatement.executeUpdate();
            
            
    		connection.close();
			return result;
		}
		public int deletePerson(String email) throws Exception {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from person where email=?");
             
			preparedStatement.setString(1, email);
			
            int result = preparedStatement.executeUpdate();
            
            
    		connection.close();
			return result;
		}
		
            
            
		
		


}