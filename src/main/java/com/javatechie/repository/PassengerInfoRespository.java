package com.javatechie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.javatechie.entity.PassengerInfo;

public interface PassengerInfoRespository extends JpaRepository<PassengerInfo, Long> {

}
