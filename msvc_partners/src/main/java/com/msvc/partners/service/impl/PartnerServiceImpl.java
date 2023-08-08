package com.msvc.partners.service.impl;

import com.msvc.partners.clients.IBookClientRest;
import com.msvc.partners.exception.LendBookException;
import com.msvc.partners.exception.ModelNotFoundException;
import com.msvc.partners.model.Book;
import com.msvc.partners.model.entity.LoanEnt;
import com.msvc.partners.model.entity.PartnerEnt;
import com.msvc.partners.repository.IGenericRepository;
import com.msvc.partners.repository.IPartnerRepository;
import com.msvc.partners.service.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements IPartnerService {
    @Autowired
    private IPartnerRepository repository;

    @Autowired
    private IBookClientRest client;


    @Override
    public IGenericRepository<PartnerEnt, Integer> getRepository() {
        return repository;
    }

    @Override
    public Optional<Book> registerLoan(Integer idBook, Integer idPartner) {
        Optional<PartnerEnt> partnerOp = repository.findById(idPartner);
        if (partnerOp.isPresent()){
            Book bookMsvc = client.lendBook(idBook);
            PartnerEnt partnerEnt = partnerOp.get();
            for (LoanEnt loan:partnerEnt.getLoans()) {
                if (loan.getIdBook().equals(bookMsvc.getIdBook()) && loan.getReturnDate() == null){
                    throw new LendBookException("IdBook: "+ idBook +" This book was not returned");
                }
            }
            LoanEnt loanEnt = new LoanEnt();
            loanEnt.setIdBook(bookMsvc.getIdBook());
            partnerEnt.addLoan(loanEnt);
            repository.save(partnerEnt);

            return Optional.of(bookMsvc);
        }
        return Optional.empty();
    }

    @Override
    public void registerLoanReturn(Integer idBook, Integer idPartner) throws Exception{
        Optional<PartnerEnt> partnerOp = repository.findById(idPartner);
        if(partnerOp.isPresent()){
            PartnerEnt partnerEnt = partnerOp.get();

            boolean returned = false;
            for (LoanEnt loan:partnerEnt.getLoans()) {
                if (loan.getIdBook().equals(idBook) && loan.getReturnDate() == null){
                    client.returnBookLoan(idBook);
                    loan.setReturnDate(LocalDateTime.now());
                    repository.save(partnerEnt);
                    returned = true;
                    break;
                }
            }

            if (!returned){
                throw new ModelNotFoundException("The partner does not have the book borrowed.");
            }
        }else {
            throw new ModelNotFoundException("PARTNER ID NOT FOUND " + idPartner);
        }

    }

}
