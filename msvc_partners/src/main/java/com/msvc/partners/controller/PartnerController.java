package com.msvc.partners.controller;

import static com.msvc.partners.service.convert.entityToDto.PartnerConverter.*;

import com.msvc.partners.dto.PartnerDto;
import com.msvc.partners.exception.ModelKeyAutogeneratedException;
import com.msvc.partners.model.Book;
import com.msvc.partners.model.entity.LoanEnt;
import com.msvc.partners.service.IPartnerService;
import com.msvc.partners.service.impl.PartnerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private IPartnerService partnerService;

    @GetMapping
    public ResponseEntity<List<PartnerDto>> findAll() throws Exception {
        return ResponseEntity.ok(entityListToDtoList(partnerService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<PartnerDto> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(entityToDto(partnerService.findByid(id)));
    }

    @PostMapping()
    public ResponseEntity<PartnerDto> save(@Valid @RequestBody PartnerDto partnerDto) throws Exception {
        if(partnerDto.getIdPartner() != null){
            throw new ModelKeyAutogeneratedException("The primary key is autogenerated: "
                    .concat(partnerDto.getIdPartner().toString()));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entityToDto(partnerService.save(dtoToEntity(partnerDto))));
    }

    @PutMapping("{id}")
    public ResponseEntity<PartnerDto> update(@PathVariable Integer id, @Valid @RequestBody PartnerDto partnerDto) throws Exception {
        partnerDto.setIdPartner(id);
        return ResponseEntity.ok(entityToDto(partnerService.save(dtoToEntity(partnerDto))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        partnerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/register-loan/{idPartner}/{idBook}")
    public ResponseEntity<Book> registerLoan(@PathVariable Integer idPartner, @PathVariable Integer idBook) throws Exception{
        Optional<Book> bookOp = partnerService.registerLoan(idBook, idPartner);
        if(bookOp.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(bookOp.get());
        }

        return ResponseEntity.notFound().build();
    }
}