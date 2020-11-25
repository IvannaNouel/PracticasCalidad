package com.mayab.calidad.dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoDAOOracle implements DAO {
	Connection con;

	public boolean addAlumno(Alumno a) {	
		
		try {
			PreparedStatement preparedStatement;
			preparedStatement = con.prepareStatement("insert INTO alumno(id, student_name, email, age, grade) values (?, ?, ?, ?, ?)");
			
			preparedStatement.setInt(1, a.getId());
			preparedStatement.setString(2, a.getNombre());
			preparedStatement.setString(3, a.getEmail());
			preparedStatement.setInt(4, a.getEdad());
			preparedStatement.setDouble(5, a.getCalificacion());

			
			preparedStatement.executeUpdate();
			
			
			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return true;
	}

	public void deleteAlumno(int id) {
		try {
			 
			PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM ALUMNO WHERE id = ?");
			
			prepareStatement.setInt(1, id);

			prepareStatement.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println(e);
	}
		
		
	}


	public void updatePromedio(Alumno a, double nuevoPromedio) {
		// TODO Auto-generated method stub
		
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE ALUMNO set grade = ? WHERE  id = ?");
			
		
			
			preparedStatement.setDouble(1, a.getCalificacion());
			preparedStatement.setInt(2, a.getId());
			
			 preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		

	}

	public int getNumeroAlumnos() {
		int count = 0;
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(*) FROM ALUMNO");
			
			ResultSet result = preparedStatement.executeQuery();
			
			result.next();
			
			count = result.getInt(1);
			
			
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return count;
	}

	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Connection getConnection() {
		Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbunit","dbunit");
            System.out.println("Connected");
        }catch(Exception e){System.out.println(e);}  
        return con;  
        
	}

	@Override
	public Alumno getAlumno(double d) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
