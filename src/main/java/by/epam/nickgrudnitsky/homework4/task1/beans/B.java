package by.epam.nickgrudnitsky.homework4.task1.beans;

public class B {
    private String name;
    private A a;

    public B(String name, A a) {
        this.name = name;
        this.a = a;
    }

    public B() {
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        B b = (B) o;

        if (getName() != null ? !getName().equals(b.getName()) : b.getName() != null) return false;
        return getA() != null ? getA().equals(b.getA()) : b.getA() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getA() != null ? getA().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
