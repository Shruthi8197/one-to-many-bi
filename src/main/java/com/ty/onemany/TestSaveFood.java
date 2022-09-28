package com.ty.onemany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveFood {

	public static void main(String[] args) {
		
		FoodOrder foodOrder=new FoodOrder();
		foodOrder.setToName("Shruthi");
		foodOrder.setStatus("pending");
		
		Item item=new Item();
		item.setName("Burger");
		item.setQuantity(2);
		item.setCost(75);
		
		Item item1=new Item();
		item1.setName("Pizza");
		item1.setQuantity(3);
		item1.setCost(175);
		
		List<Item> items=new ArrayList();
		items.add(item1);
		items.add(item);
		
		foodOrder.setItems(items);
		item.setFoodOrder(foodOrder);
		item1.setFoodOrder(foodOrder);
	
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityManager.persist(item);
		entityManager.persist(item1);
		entityTransaction.commit();

	}

}
