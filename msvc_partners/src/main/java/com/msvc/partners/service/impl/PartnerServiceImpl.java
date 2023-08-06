package com.msvc.partners.service.impl;

import com.msvc.partners.model.entity.PartnerEnt;
import com.msvc.partners.repository.IGenericRepository;
import com.msvc.partners.repository.IPartnerRepository;
import com.msvc.partners.service.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements IPartnerService {
    @Autowired
    private IPartnerRepository repository;


    @Override
    public IGenericRepository<PartnerEnt, Integer> getRepository() {
        return repository;
    }
}
