package com.example.pirp2.repos;


import com.example.pirp2.entity.Billionaires;

import org.springframework.data.jpa.repository.JpaRepository;



public  interface BillRepository extends JpaRepository<Billionaires,Integer>
{

}
