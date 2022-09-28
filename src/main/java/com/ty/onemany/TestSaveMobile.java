package com.ty.onemany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobile {

	public static void main(String[] args) {

		Mobile mobile = new Mobile();
		mobile.setName("Samsung");
		mobile.setCost(15000);
		
		Sim sim = new Sim();
		sim.setName("Airtel sim");
		sim.setProvider("Airtel");

		Sim sim1 = new Sim();
		sim1.setName("Vodofone");
		sim1.setProvider("Vodofone");

		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim);
		sims.add(sim1);

		mobile.setSims(sims);
		sim.setMobile(mobile);
		sim1.setMobile(mobile);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityTransaction.commit();

	}

}
