package com.msvc.partners.repository;

import com.msvc.partners.model.entity.LoanEnt;
import com.msvc.partners.model.entity.PartnerEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IPartnerRepository extends IGenericRepository<PartnerEnt, Integer>{

//    @Query(value = "SELECT * FROM msvc_partners.loans l WHERE id_book=:idBook AND id_partner=:idPartner AND return_date IS NULL", nativeQuery = true)
//    Object getLoansByBookAndPartner(@Param("idBook") Integer idBook,@Param("idPartner") Integer idPartner);
//
//    @Query(value = "UPDATE msvc_partners.loans l SET return_date=:dateTime WHERE id_book=:idBook AND id_partner=:idPartner AND return_date IS NULL", nativeQuery = true)
//    Integer registerDateOfReturn(@Param("dateTime") LocalDateTime dateTime, @Param("idBook") Integer idBook, @Param("idPartner") Integer idPartner);
//
//    @Query(value = "FROM PartnerEnt p WHERE id_book=:idBook AND id_partner=:idPartner AND return_date IS NULL")
//    List<LoanEnt> asdas();
}
