package com.msvc.partners.service;

import com.msvc.partners.model.Book;
import com.msvc.partners.model.entity.LoanEnt;
import com.msvc.partners.model.entity.PartnerEnt;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IPartnerService extends IGenericCRUDImpl<PartnerEnt, Integer> {
    @Transactional
    Optional<Book> registerLoan(Integer idBook, Integer idPartner);
    @Transactional
    void registerLoanReturn(Integer idBook, Integer idPartner) throws Exception;
}
