package com.example.mypro.controller;

import java.io.*;
import java.util.List;

import com.example.mypro.model.dto.StudentDTO;
import com.example.mypro.repository.StudentRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    private String message;

//    public void init() {
//        message = "Hello World!";
//    }



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentRepository repository = new StudentRepository();
        List<StudentDTO> students = repository.getAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String jsonStr = objectMapper.writeValueAsString(students);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(jsonStr);

    }

    public void destroy() {
    }
}