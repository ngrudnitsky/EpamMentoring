package by.epam.nickgrudnitsky.homework4.task1.beans;

public class C {
    private String name;

    public D createD(){
        return new D();
    }

    public C(String name) {
        this.name = name;
    }

    public C() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        C c = (C) o;

        return getName() != null ? getName().equals(c.getName()) : c.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "C{" +
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
