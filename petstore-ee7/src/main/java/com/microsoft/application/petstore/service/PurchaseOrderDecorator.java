package com.microsoft.application.petstore.service;

import javax.decorator.Decorator;
import javax.inject.Inject;

import com.microsoft.application.petstore.service.ComputablePurchaseOrder;

import javax.decorator.Delegate;

@Decorator
public abstract class PurchaseOrderDecorator implements ComputablePurchaseOrder
{

   @Inject
   @Delegate
   private ComputablePurchaseOrder delegate;
}