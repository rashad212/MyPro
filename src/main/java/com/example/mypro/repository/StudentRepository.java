package com.example.mypro.repository;

import com.example.mypro.model.dto.StudentDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<StudentDTO> getAll() {
        String dbName = "jdbc:postgresql://localhost/mydb";
        String dbDriver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "ghffymh";
        List<StudentDTO> students = new ArrayList<>();
        try{
            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbName, userName, password);
            Statement statement = con.createStatement();
            String sql = "select * from resschema.students";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(rs.getInt("id"));
                studentDTO.setName(rs.getString("name"));
                studentDTO.setAge(rs.getInt("age"));
                students.add(studentDTO);
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return students;
    }

}
