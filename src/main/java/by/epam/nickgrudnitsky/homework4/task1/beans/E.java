package by.epam.nickgrudnitsky.homework4.task1.beans;

public class E {
    private String name;

    public void sayHello(){
        System.out.println("Hello");
    }

    public E(String name) {
        this.name = name;
    }

    public E() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        E e = (E) o;

        return getName() != null ? getName().equals(e.getName()) : e.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "E{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
