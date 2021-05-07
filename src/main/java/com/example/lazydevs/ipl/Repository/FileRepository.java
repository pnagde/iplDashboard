package com.example.lazydevs.ipl.Repository;

import java.util.List;

import com.example.lazydevs.ipl.modal.UploadFileResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<UploadFileResponse,String>{
    
}
