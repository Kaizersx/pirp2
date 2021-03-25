package com.example.pirp2.repos;


import com.example.pirp2.entity.Piro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public  interface PiroRepository extends JpaRepository<Piro,Integer>
{

List<Piro>findByTag(String tag);
}
