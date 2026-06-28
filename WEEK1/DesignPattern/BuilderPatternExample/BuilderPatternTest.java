package WEEK1.DesignPattern.BuilderPatternExample;

public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer pc1 = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32 GB")
                .setStorage("2 TB SSD")
                .build();

        Computer pc2 = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("8 GB")
                .setStorage("500 GB HDD")
                .build();

        Computer pc3 = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("4 GB")
                .setStorage("128 GB SSD")
                        .build();

        pc1.displayDetails();
        pc2.displayDetails();
        pc3.displayDetails();
    }
}