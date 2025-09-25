package com.example.jackson.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

public class Jackson2 {

    public void javaToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student3 student3 = new Student3(1, "Pratik", "sarasu10");
        String s = objectMapper.writeValueAsString(student3);
        System.out.println(s);
    }

    //json to java
    public void jsonToJava() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"Pratik\",\"password\":\"sarasu10\"}";
        Student3 student3 = objectMapper.readValue(json, Student3.class);
        System.out.println(student3);
    }

    //java to file
    public void javaToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student3 student3 = new Student3(1, "Pratik", "sarasu");
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Desktop\\SpringBoot\\jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\entity\\student.txt");
        objectMapper.writeValue(file, student3);
    }

    //file to java
    public void fileToJava() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String file = "C:\\Users\\Sreenivas Bandaru\\Desktop\\SpringBoot\\jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\entity\\student.txt";
        Student3 student = objectMapper.readValue(new File(file), Student3.class);
        System.out.println(student);
    }


    //student to student DTO
    public void studentTostudentDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        Student3 student3 = new Student3(2, "Abhay", "sarasu10");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Student3DTO student3DTO = objectMapper.convertValue(student3, Student3DTO.class);
        System.out.println(student3DTO);
    }

    public static void main(String[] args) throws IOException {
        Jackson2 jackson2 = new Jackson2();
        jackson2.javaToJson();
        jackson2.jsonToJava();
        jackson2.javaToFile();
        jackson2.fileToJava();
        jackson2.studentTostudentDTO();
//        jackson2.studentTostudentDTO();
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student3 {
    private int id;
    private String name;
    private String password;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Student3DTO {
    private int id;
    private String name;

}
