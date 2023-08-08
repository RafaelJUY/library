package com.msvc.partners.repository;

import com.msvc.partners.model.entity.LoanEnt;
import com.msvc.partners.model.entity.PartnerEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IPartnerRepository extends IGenericRepository<PartnerEnt, Integer>{
}
