package com.msvc.partners.service.impl;

import com.msvc.partners.clients.IBookClientRest;
import com.msvc.partners.model.Book;
import com.msvc.partners.model.entity.LoanEnt;
import com.msvc.partners.model.entity.PartnerEnt;
import com.msvc.partners.repository.IGenericRepository;
import com.msvc.partners.repository.IPartnerRepository;
import com.msvc.partners.service.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Book bookMsvc = client.findById(idBook);
            PartnerEnt partnerEnt = partnerOp.get();

            LoanEnt loanEnt = new LoanEnt();
            loanEnt.setIdBook(bookMsvc.getIdBook());
            partnerEnt.addLoan(loanEnt);
            repository.save(partnerEnt);

            return Optional.of(bookMsvc);
        }

        return Optional.empty();
    }
}
