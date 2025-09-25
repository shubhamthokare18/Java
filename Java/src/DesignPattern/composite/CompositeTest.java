package composite;

public class CompositeTest {
    public static void main(String[] args) {
        Component hdd=new Leaf(4000, "hdd");
        Component mouse=new Leaf(500, "mouse");
        Component monitor=new Leaf(8000, "monitor");
        Component ram=new Leaf(3000, "ram");
        Component cpu=new Leaf(9000, "cpu");

        Composite peri=new Composite("peri");
        Composite cabinet=new Composite("cabinet");
        Composite mb=new Composite("mb");
        Composite computer=new Composite("computer");

        mb.addComponent(ram);
        mb.addComponent(cpu);

        peri.addComponent(mouse);
        peri.addComponent(monitor);
        cabinet.addComponent(hdd);
        cabinet.addComponent(mb);

        computer.addComponent(peri);
        computer.addComponent(cabinet);

        computer.showPrice();
    }
}
