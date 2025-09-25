package factory;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory ofs=new OperatingSystemFactory();
        OS os=ofs.getInstance("lkdjf");
        os.spec();
    }
}