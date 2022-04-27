package com.springframework.boot.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.boot.data.jpa.entity.Cource;
import com.springframework.boot.data.jpa.entity.CourceMaterial;

@SpringBootTest
class CourceMaterialTest {

	@Autowired
	private CourceMaterialRepository courceMaterialRepository; 
	
//	@Test
	public void saveCourceMaterial() {
		
		Cource cource = Cource.builder()
						.title("DSA")
						.credit(6)
						.build();
		
		CourceMaterial courceMaterial = CourceMaterial.builder()
										.url("www.google.com")
										.cource(cource)
										.build();
		
		courceMaterialRepository.save(courceMaterial);
		
	}

	@Test
	public void printAllCurceMaterial() {
		
		List<CourceMaterial> materials = courceMaterialRepository.findAll();
		
		System.out.println("List Of Materials : "+materials);
		
	}
	
}
