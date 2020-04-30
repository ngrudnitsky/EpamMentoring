package by.epam.nickgrudnitsky.homework4.task1.beans;

public class F {
    private String name;

    public void initializeF(){
        System.out.println("Bean F initializing");
    }

    public void destroyF(){
        System.out.println("Bean F destroying");
    }

    public F(String name) {
        this.name = name;
    }

    public F() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        F f = (F) o;

        return getName() != null ? getName().equals(f.getName()) : f.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "F{" +
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
