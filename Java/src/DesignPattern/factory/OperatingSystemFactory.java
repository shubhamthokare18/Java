package factory;

public class OperatingSystemFactory {
    public OS getInstance(String string){
        if (string.equals("open"))
            return new Android();
        else if (string.equals("close"))
            return new IOS();
        else
            return new Windows();
    }
}
