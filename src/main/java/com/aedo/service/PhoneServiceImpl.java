package com.aedo.service;

import com.aedo.model.Phone;
import com.aedo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class PhoneServiceImpl implements PhoneService{

    @Autowired
    PhoneRepository PhoneRepository;

    /**
     * Guarda Phones
     * @param Phones
     */
    public void savePhones(Set<Phone> Phones) {
        PhoneRepository.saveAll(Phones);
    }

}