package com.example.lazydevs.ipl.Repository;


import java.util.List;

import com.example.lazydevs.ipl.modal.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  TeamRepository extends JpaRepository<Team,Integer>{
    
    @Query("select t from Team t where t.teamName LIKE %?1%"+ " OR CONCAT(t.teamName,'') LIKE %?1%")
   public List<Team> search(String keyword);
}
