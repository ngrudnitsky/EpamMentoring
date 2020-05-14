package by.epam.nickgrudnitsky.homework5.examples;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial();
        oos.writeObject(ts);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ts = (TestSerial) ois.readObject();
        System.out.println(ts.version);
        System.out.println(ts.count);
    }
}

class TestSerial implements Serializable {
    public byte version = 100;
    public byte count = 0;

}
