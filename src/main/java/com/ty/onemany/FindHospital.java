package com.ty.onemany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindHospital {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Branch branch=entityManager.find(Branch.class, 1);
		if(branch!=null) {
			System.out.println("Branch id:"+branch.getId());
			System.out.println("Branch location is:"+branch.getLocation());
			System.out.println("City:"+branch.getCity());
			System.out.println("Phone number:"+branch.getPhone());
			System.out.println("*****************");
		}
		Branch branch1=entityManager.find(Branch.class, 2);
		if(branch1!=null) {
			System.out.println("Branch id:"+branch1.getId());
			System.out.println("Branch location is:"+branch1.getLocation());
			System.out.println("City:"+branch1.getCity());
			System.out.println("Phone number:"+branch1.getPhone());
			System.out.println("*****************");
		}
		
		Hospital hospital=branch1.getHospital();
		if(hospital!=null) {
			System.out.println("Hospital id:"+hospital.getId());
			System.out.println("Hospital name:"+hospital.getName());
			System.out.println("Hopital website:"+hospital.getWebsite());
		}
				

	}

}
