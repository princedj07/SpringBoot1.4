package com.springframework.boot.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.boot.data.jpa.entity.Cource;

@SpringBootTest
class CourceRepositoryTest {

	@Autowired
	private CourceRepository courceRepository;
	
	@Test
	public void getCourceMaterial() {
		List<Cource> cources = courceRepository.findAll();
		System.out.println("List Of Cources : "+cources);
	}

}
