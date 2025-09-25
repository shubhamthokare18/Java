package com.example.jackson.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Jackson {
    public static void main(String[] args) throws Exception {
        Jackson jackson = new Jackson();
        jackson.javaToJson();
        jackson.jsonToJava();
        jackson.javaToFile();
        jackson.fileToJava();
        jackson.entityToDto();
        jackson.dtoToEntity();
        jackson.check();
    }

    public void javaToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person(1, "Shubham");
        String jtj = objectMapper.writeValueAsString(person);
        System.out.println(jtj);
    }

    public void jsonToJava() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jtj = "{\"id\":1, \"name\":\"Shubham\"}";
        Person person = objectMapper.readValue(jtj, Person.class);
        System.out.println(person);
    }

    public void javaToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person(2, "Virat");
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Desktop\\SpringBoot\\jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\entity\\Person.txt");
        objectMapper.writeValue(file, person);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void fileToJava()throws IOException{
        ObjectMapper objectMapper=new ObjectMapper();
        String file="C:\\Users\\Sreenivas Bandaru\\Desktop\\SpringBoot\\jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\entity\\Person.txt";
        Person person=objectMapper.readValue(new File(file), Person.class);
        System.out.println(person);
    }
    public void entityToDto(){
        ObjectMapper objectMapper=new ObjectMapper();
        Person person=new Person(3, "Alex");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        PersonDto personDto=objectMapper.convertValue(person, PersonDto.class);
        System.out.println(personDto);
    }
    public void dtoToEntity(){
        ObjectMapper objectMapper=new ObjectMapper();
        PersonDto personDto=new PersonDto("John");
        Person person=objectMapper.convertValue(personDto, Person.class);
        System.out.println(person);
    }
    public void check()throws JsonProcessingException{
        ObjectMapper objectMapper=new ObjectMapper();
        String json="{\"id\":1,\"name\":\"Shubham\"}";
        JsonNode jsonNode=objectMapper.readTree(json);
        System.out.println(jsonNode);
        String id=jsonNode.get("id").asText();
        System.out.println(id);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    private int id;
    private String name;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class PersonDto{
    private String name;
}