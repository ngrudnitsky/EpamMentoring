package by.epam.nickgrudnitsky.homework4.task2.factory;

import by.epam.nickgrudnitsky.homework4.task2.service.PositionService;
import org.springframework.beans.factory.FactoryBean;

public class PositionServiceFactory implements FactoryBean<PositionService> {
    @Override
    public PositionService getObject() throws Exception {
        System.out.println("Position Service is created from factory that implements FactoryBean interface.");
        return new PositionService();
    }

    @Override
    public Class<?> getObjectType() {
        return PositionService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
