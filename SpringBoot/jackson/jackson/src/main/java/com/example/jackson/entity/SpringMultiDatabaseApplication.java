//package com.example.jackson.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Optional;
//
//@SpringBootApplication
//public class SpringMultiDatabaseApplication {
//
//    public static void main(String[] args) throws IOException {
//     SpringApplication.run(SpringMultiDatabaseApplication.class, args);
//
//     Student student=new Student("Mahesh",12,24);
//        SpringMultiDatabaseApplication application = new SpringMultiDatabaseApplication();
//     System.out.println(application.toJson());
//     application.jsonToJava();
//     application.javaToFile();
//        System.out.println(application.toStudentDTO());
//        System.out.println(application.employeeName());
//        System.out.println(application.fileToJava("C:\\Users\\Sreenivas Bandaru\\Downloads\\SpringBoot2\\student.txt"));
//        application.check();
//
//
//    }
//
//    public void check() throws JsonProcessingException {
//        String json = "{\"id\":1,\"address\":\"Hyderabad\",\"vehicle\":{\"color\":\"red\",\"name\":\"Honda\",\"vehicleType\":{\"vehicleType\":\"Two\"}}}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(json);
//        System.out.println(jsonNode);
//        String id = jsonNode.get("id").asText();
//        System.out.println(id);
//        JsonNode vehicle = jsonNode.get("vehicle");
//        System.out.println(vehicle);
//        ((ObjectNode) vehicle).put("Engine", "BS6");
//        ((ObjectNode) vehicle).remove("Engine");
//
//        System.out.println(vehicle);
//
//     Vehicle vehicle1 = objectMapper.treeToValue(vehicle, Vehicle.class);
//     System.out.println(vehicle1);
//    }
//
//      public String toJson()
//  {
//     Student student=new Student("Mahesh",12,24);
//     ObjectMapper objectMapper=new ObjectMapper();
//     try
//     {
//        return objectMapper.writeValueAsString(student);
//     } catch (JsonProcessingException e) {
//        throw new RuntimeException(e);
//     }
//  }
//
//    public StudentDto toStudentDTO() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Student student = new Student("Mahesh", 12, 24, "opopoppop");
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        return objectMapper.convertValue(student, StudentDto.class);
//
//    }
//  public void javaToFile() throws IOException {
//     Student student=new Student("Mahesh",12,29);
//     ObjectMapper objectMapper=new ObjectMapper();
//     File file=new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\SpringBoot2\\student.txt");
//     objectMapper.writeValue(file,student);
//
//     Student student1 = fileToJava(file.getPath());
//     System.out.println(student1);
//  }
//
//  public void jsonToJava() throws JsonProcessingException {
//  String json="{\"name\":\"Mahesh\",\"id\":12,\"age\":24}";
//  ObjectMapper objectMapper=new ObjectMapper();
//     Student student = objectMapper.readValue(json, Student.class);
//     System.out.println(student);
//  }
//
//    public Student fileToJava(String path) throws IOException {
//        ObjectMapper om = new ObjectMapper();
//
//        Student student = om.readValue(new File(path), Student.class);
//        return student;
//    }
//
//    public String employeeName() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        VehicleType vehicleType = new VehicleType("Two");
//        Vehicle vehicle = new Vehicle("red", "Honda", vehicleType);
//        Employee employee = new Employee(1, "Hyderabad", vehicle);
//        try {
//            return objectMapper.writeValueAsString(employee);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException();
//        }
//
//    }
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Student {
//    private String name;
//    private int id;
//    private int age;
//    private String password;
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class StudentDto {
//    private String name;
//    private int id;
//    private int age;
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Employee
//{
//  private Integer id;
//  private String address;
//  private Vehicle vehicle;
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Vehicle {
//    @JsonIgnore
//    private String color;
//    private String name;
//    private VehicleType vehicleType;
//}
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class VehicleType {
//    private String vehicleType;
//
//}