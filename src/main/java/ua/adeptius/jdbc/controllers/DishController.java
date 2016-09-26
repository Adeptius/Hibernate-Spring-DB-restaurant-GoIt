package ua.adeptius.jdbc.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.jdbc.dao.DishDao;
import ua.adeptius.jdbc.model.Dish;
import ua.adeptius.jdbc.model.DishCategory;
import ua.adeptius.jdbc.model.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void createDish(){
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(5F);
        plov.setWeight(300F);

        Dish salat = new Dish();
        salat.setName("Salat");
        salat.setCategory(DishCategory.SALAT);
        salat.setPrice(2F);
        salat.setWeight(200F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(3F);
        potato.setWeight(100F);

        Set<Dish> dishes = new HashSet<>(dishDao.findall());

        if (!dishes.contains(plov)) dishDao.save(plov);
        if (!dishes.contains(salat)) dishDao.save(salat);
        if (!dishes.contains(potato)) dishDao.save(potato);
    }

    @Transactional
    public List<Dish> getAllDishes(){
        return dishDao.findall();

    }

    @Transactional
    public Dish getDishByName(String name){
        return dishDao.findByName(name);
    }

}
