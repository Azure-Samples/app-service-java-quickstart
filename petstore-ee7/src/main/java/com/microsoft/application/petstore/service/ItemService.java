package com.microsoft.application.petstore.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.microsoft.application.petstore.model.Item;
import com.microsoft.application.petstore.model.Product;
import com.microsoft.application.petstore.util.Loggable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
@Loggable
public class ItemService extends AbstractService<Item> implements Serializable
{


   // ======================================
   // =            Constructors            =
   // ======================================

   public ItemService()
   {
      super(Item.class);
   }

   // ======================================
   // =         Protected methods          =
   // ======================================

   @Override
   protected Predicate[] getSearchPredicates(Root<Item> root, Item example)
   {
      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String name = example.getName();
      if (name != null && !"".equals(name))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("name")), '%' + name.toLowerCase() + '%'));
      }
      String description = example.getDescription();
      if (description != null && !"".equals(description))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("description")), '%' + description.toLowerCase() + '%'));
      }
      String imagePath = example.getImagePath();
      if (imagePath != null && !"".equals(imagePath))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("imagePath")), '%' + imagePath.toLowerCase() + '%'));
      }
      Product product = example.getProduct();
      if (product != null)
      {
         predicatesList.add(builder.equal(root.get("product"), product));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }
}