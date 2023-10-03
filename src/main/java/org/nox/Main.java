package org.nox;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List<Human> humans = new ArrayList<>();
    humans.add(new Human("Анна", 3));
    humans.add(new Human("Татьяна", 6));
    humans.add(new Human("Богдан", 12));
    humans.add(new Human("Таисия", 19));
    humans.add(new Human("Егор", 37));
    humans.add(new Human("Александр", 65));

    // Сериализую список в файл
    FileOutputStream fos = new FileOutputStream("humans.bin");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(humans);
    oos.close();

    // Десериализуею обратно в список
    FileInputStream fis = new FileInputStream("humans.bin");
    ObjectInputStream ois = new ObjectInputStream(fis);
    List<Human> dHumans = (List<Human>) ois.readObject();
    ois.close();

    for (Human h : dHumans) {
      System.out.println(h);
    }
  }
}
