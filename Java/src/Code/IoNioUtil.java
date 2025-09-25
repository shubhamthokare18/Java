import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IoNioUtil {

    public static void main(String[] args) throws IOException {
        IoNioUtil ioNioUtil = new IoNioUtil();
        ioNioUtil.createIoDir();
        ioNioUtil.createNioDir();
    }

    public void createNioDir() throws IOException {
        Path path = Paths.get("C:\\Users\\Sreenivas Bandaru\\IdeaProjects\\NioDir");
        if(!Files.exists(path))
        {
            Files.createDirectory(path);
        }
        createNioFile(path);

    }

    public void createNioFile(Path path)throws IOException{
        if (Files.exists(path)){
            Path resolve=path.resolve("NioFile.txt");
            Files.createFile(resolve);
        }else {
            System.out.println("NioFile.txt Exists");
        }
            writeNioFile(path);
    }

    public void writeNioFile(Path path) throws IOException {
        List<String> list= Arrays.asList("I LOVE INDIA");
        Files.write(path,list, StandardCharsets.UTF_8);

        try(BufferedWriter bufferedWriter=Files.newBufferedWriter(path,StandardCharsets.UTF_8))
        {
            bufferedWriter.write("I LOVE BHARAT");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void createIoDir() throws IOException {
        File file = new File("C:\\Users\\Sreenivas Bandaru\\IdeaProjects\\IoDir");

        if (!file.exists()) {
            file.mkdir();
        } else {
            System.out.println("IoDir Exists");
        }

        createIoFile(file.getAbsolutePath());
    }

    public void createIoFile(String path) throws IOException {
        File file=new File(path+"\\IoFile.txt");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        if(!file.exists())
        {
            file.createNewFile();
        }
        else
        {
            System.out.println("IoFile Exists");
        }
        writeIoFile(file);
        createBufferFile(file);
        readBufferFile(file);
    }

    public void writeIoFile(File file)
    {
        try(FileWriter fileWriter=new FileWriter(file))
        {
            fileWriter.write("Hello World");
            fileWriter.write("Hello Asia");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("Hello India");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readIoFile(file);
    }

    public void readIoFile(File file)
    {
        try(FileReader fileReader=new FileReader(file))
        {
            Scanner scanner=new Scanner(fileReader);
            while(scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createBufferFile(File file)
    {
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true)))
        {
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("Hello Buffer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readBufferFile(File file)
    {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
