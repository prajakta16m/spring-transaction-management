package com.javatechie.dto;

import com.javatechie.entity.PassengerInfo;
import com.javatechie.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

  private PassengerInfo passengerInfo;

  private PaymentInfo paymentInfo;
}
