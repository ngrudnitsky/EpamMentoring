package by.epam.nickgrudnitsky.homework5.task1;

import by.epam.nickgrudnitsky.homework5.task1.entities.BaseEntity;
import by.epam.nickgrudnitsky.homework5.task1.entities.Role;
import by.epam.nickgrudnitsky.homework5.task1.entities.Status;
import by.epam.nickgrudnitsky.homework5.task1.entities.User;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ProgramRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Role role = new Role();
        User user = new User();

        setupRole(role, Collections.singletonList(user));
        setupUser(user, Collections.singletonList(role));

        System.out.println("Before serialization:\n" + user + "\n" + role);

        serializeEntity(user, "user");
        serializeEntity(role, "role");

        BaseEntity deserializedUser = deserializeEntity("user");
        BaseEntity deserializedRole = deserializeEntity("role");

        System.out.println("After serialization:\n" + deserializedUser + "\n" + deserializedRole);

    }

    private static BaseEntity deserializeEntity(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(filePath)
        );
        BaseEntity deserializedEntity = (BaseEntity) inputStream.readObject();
        inputStream.close();
        return deserializedEntity;
    }

    private static void serializeEntity(BaseEntity entity, String filePath) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(filePath)
        );
        outputStream.writeObject(entity);
        outputStream.close();
    }

    private static void setupUser(User user, List<Role> roles) {
        user.setUserName("NickGS");
        user.setFirstName("Nikita");
        user.setLastName("Grudnitsky");
        user.setEmail("email@email.com");
        user.setPassword("123");
        user.setRoles(roles);
        user.setCreated(new Date());
        user.setStatus(Status.ACTIVE);
    }

    private static void setupRole(Role role, List<User> users) {
        role.setName("Admin");
        role.setCreated(new Date());
        role.setStatus(Status.ACTIVE);
        role.setUsers(users);
    }
}
