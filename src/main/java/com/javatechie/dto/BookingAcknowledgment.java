package com.javatechie.dto;

import com.javatechie.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingAcknowledgment {

  private String status;
  private Double totalFare;
  private String pnrNo;
  private PassengerInfo passengerInfo;

}
