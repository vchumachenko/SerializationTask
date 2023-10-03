package org.nox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Human implements Serializable {
  private String name;
  private int age;
  private transient String career;

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setCareer() {
    if (age >= 0 && age <= 3) {
      career = "Сидит дома";
    } else if (age >= 3 && age <= 7) {
      career = "Ходит в детский сад";
    } else if (age >= 7 && age <= 18) {
      career = "Учится в школе";
    } else if (age >= 17 && age <= 23) {
      career = "Учится в институте";
    } else if (age >= 24 && age <= 65) {
      career = "Работает";
    } else if (age >= 65) {
      career = "На пенсии";
    }
  }
  // При десериализации вызывается этот метод, в котором вычисляется career
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    setCareer();
  }

  @Override
  public String toString() {
    return "Имя: " + name + "; Возраст: " + age + "; Род деятельности: " + career;
  }
}
