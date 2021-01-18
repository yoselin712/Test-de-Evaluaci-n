package com.aedo.repository;
import com.aedo.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository  extends JpaRepository<Phone, String> {

}
