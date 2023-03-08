package com.microsoft.application.petstore.util;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.microsoft.application.petstore.util.Discount;
import com.microsoft.application.petstore.util.Vat;

public class NumberProducer
{

   @Produces
   @Vat
   @Named
   private Float vatRate;
   @Produces
   @Discount
   @Named
   private Float discountRate;
}