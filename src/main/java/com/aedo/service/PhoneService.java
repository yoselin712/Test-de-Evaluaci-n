package com.aedo.service;

import com.aedo.model.Phone;
import java.util.Set;

public interface PhoneService {

    /**
     * Guarda Phones
     * @param Phones
     */
    void savePhones(Set<Phone> Phone);
}
