package com.springframework.boot.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springframework.boot.data.jpa.entity.Cource;

@Repository
public interface CourceRepository extends JpaRepository<Cource, Long>{

}
