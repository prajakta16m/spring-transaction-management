package com.javatechie.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javatechie.dto.BookingAcknowledgment;
import com.javatechie.dto.FlightBookingRequest;
import com.javatechie.entity.PassengerInfo;
import com.javatechie.entity.PaymentInfo;
import com.javatechie.repository.PassengerInfoRespository;
import com.javatechie.repository.PaymentInfoRepository;
import com.javatechie.utils.PaymentUtils;

import jakarta.transaction.Transactional;

@Service
public class FlightBookingService {

  @Autowired
  private PassengerInfoRespository passengerInfoRespository;

  @Autowired
  private PaymentInfoRepository paymentInfoRepository;

  @Transactional
  public BookingAcknowledgment bookFlightTicket(FlightBookingRequest request) {

    PassengerInfo info = request.getPassengerInfo();
    passengerInfoRespository.save(info);

    PaymentInfo payment = request.getPaymentInfo();

    PaymentUtils.validateCreditLimit(payment.getAccountNo(), info.getFare());

    payment.setPassengerId(info.getPId());
    payment.setAmount(info.getFare());

    paymentInfoRepository.save(payment);

    return new BookingAcknowledgment(
        "SUCCESS",
        info.getFare(),
        UUID.randomUUID().toString().split("-")[0],
        info);

  }
}
