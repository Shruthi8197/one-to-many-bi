package com.ty.onemany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFindMobile {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Mobile mobile=entityManager.find(Mobile.class, 1);
		if(mobile!=null) {
			System.out.println("Mobile id is:"+mobile.getId());
			System.out.println("Mobile name is:"+mobile.getName());
			System.out.println("Mobile cost:"+mobile.getCost());
			System.out.println("****************");
		}
		List<Sim> sims=mobile.getSims();
		if(sims!=null) {
			for(Sim s:sims) {
				System.out.println("Sim id is:"+s.getId());
				System.out.println("Sim name is:"+s.getName());
				System.out.println("Sim provider is:"+s.getProvider());
				System.out.println("************************");
			}
		
			
		}

	}

}
