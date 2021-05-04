package com.example.lazydevs.ipl.Repository;


import com.example.lazydevs.ipl.modal.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TeamRepository extends JpaRepository<Team,Integer>{
    

}
