package com.driver.Service;

import com.driver.Model.DeliveryPartner;
import com.driver.Model.Order;
import com.driver.Repository.DeliveryPartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class OrderService {
    @Autowired
    private DeliveryPartnerRepo repository;

    public void addOrder(Order order){
        repository.addOrder(order);
    }

    public void addDeliveryPartner(String deliveryPartner){
        repository.addDeliveryPartner(deliveryPartner);
    }

    public void addOrderPartnerPair(String orderId, String partnerId){
        repository.addOrderPartnerPair(orderId, partnerId);
    }

    public Order getOrderById(String orderId){
        return repository.getOrderById(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId){
        return repository.getPartnerById(partnerId);
    }

    public int getOrderCountByPartnerId(String partnerId){
        return repository.getOrderCountByPartnerId(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId){
        List<Order> orderList = repository.getOrdersByPartnerId(partnerId);
        List<String> stringList = new ArrayList<>();
        for(Order order:orderList) stringList.add(order.getId());
        return stringList;
    }

    public List<String> getAllOrders(){
        List<Order> orderList = repository.getAllOrders();
        List<String> stringList = new ArrayList<>();
        for(Order order:orderList) stringList.add(order.getId());
        return stringList;
    }

    public int getCountOfUnassignedOrders(){
        return repository.getCountOfUnassignedOrders();
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String deliveryTime, String partnerId){
        return repository.getOrdersLeftAfterGivenTimeByPartnerId(deliveryTime,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId){
        return repository.getLastDeliveryTimeByPartnerId(partnerId);
    }

    public void deletePartnerById(String partnerId){
        repository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId){
        repository.deleteOrderById(orderId);
    }
}
