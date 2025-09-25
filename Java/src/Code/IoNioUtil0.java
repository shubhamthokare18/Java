package Java;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IoNioUtil0 {
    public static void main(String[] args) throws IOException {
        IoNioUtil0 ioNioUtil0 = new IoNioUtil0();
        ioNioUtil0.createIoDir();
        ioNioUtil0.createNioDir();
    }

    public void createIoDir() throws IOException {
        File file = new File("C:\\Users\\Sreenivas Bandaru\\IdeaProjects\\Java\\src\\Java\\IoDir");
        if (!file.exists()) {
            file.mkdir();
        } else {
            System.out.println("IoDir Exists");
        }
        createIoFile(file.getAbsolutePath());
    }

    public void createIoFile(String path) throws IOException {
        File file = new File(path + "/IoFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("IoFile.txt Exists");
        }
        writeIoFile(file);
        writeBufferedFile(file);
        readBufferedFile(file);
    }

    public void writeIoFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file);) {
            fileWriter.write("Hello World");
            fileWriter.write("Hello Asia");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("Hello India");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readIoFile(file);
    }

    public void readIoFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeBufferedFile(File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("Hello Buffer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readBufferedFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createNioDir() throws IOException {
        Path path = Paths.get("C:\\Users\\Sreenivas Bandaru\\IdeaProjects\\Java\\src\\Java\\NioDir");
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        } else {
            System.out.println("NioDir Exists");
        }
        createNioFile(path);
    }

    public void createNioFile(Path path) throws IOException {
        Path resolve = path.resolve("NioFile.txt");
        if (!Files.exists(resolve)) {
            Files.createFile(resolve);
        }
        else {
            System.out.println("NioFile.txt Exists");
        }
        writeNioFile(resolve);
    }

    public void writeNioFile(Path resolve) throws IOException {
        List<String> list = Arrays.asList("I Love India");
        Files.write(resolve, list, StandardCharsets.UTF_8);
        try(BufferedWriter bufferedWriter=Files.newBufferedWriter(resolve, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            bufferedWriter.write("I Love Bharat");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}