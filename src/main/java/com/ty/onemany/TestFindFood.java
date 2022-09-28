package com.ty.onemany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFindFood {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		FoodOrder foodOrder=entityManager.find(FoodOrder.class,1);
		if(foodOrder!=null) {
			System.out.println("Food id is:"+foodOrder.getId());
			System.out.println("Food name is:"+foodOrder.getToName());
			System.out.println("Food status:"+foodOrder.getStatus());
			System.out.println("*******************");
		}
		List<Item> ls=foodOrder.getItems();
		if(ls!=null) {
			for(Item i:ls) {
				System.out.println("Item id :"+i.getId());
				System.out.println("Item name:"+i.getName());
				System.out.println("Item quantity:"+i.getQuantity());
				System.out.println("Item cost:"+i.getCost());
				System.out.println("*****************");
			}
		}

	}

}
