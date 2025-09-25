package com.example.ocrdemo.repo;

import com.example.ocrdemo.entity.AadhaarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AadhaarRepository extends JpaRepository<AadhaarDetails, Long> {}
