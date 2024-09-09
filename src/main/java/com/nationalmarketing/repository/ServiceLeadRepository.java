package com.nationalmarketing.repository;

import com.nationalmarketing.entity.ServiceLead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceLeadRepository extends JpaRepository<ServiceLead, Long> {
}