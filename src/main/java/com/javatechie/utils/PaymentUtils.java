package com.javatechie.utils;

import java.util.HashMap;
import java.util.Map;

import com.javatechie.exception.InsufficientAmountException;

public class PaymentUtils {

  private static Map<String, Double> paymentMap = new HashMap<>();

  static {
    paymentMap.put("acc1", 12000.0);
    paymentMap.put("acc2", 10000.0);
    paymentMap.put("acc3", 5000.0);
    paymentMap.put("acc4", 8000.0);
  }

  public static boolean validateCreditLimit(String accNo, double amt) {

    if (amt > paymentMap.get(accNo)) {
      throw new InsufficientAmountException("insufficient amount found");
    } else {
      return true;
    }

  }
}
