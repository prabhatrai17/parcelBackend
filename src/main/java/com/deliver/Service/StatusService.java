package com.deliver.Service;

public interface StatusService {
    public String getPickupStatus(Integer userId,Integer orderId);
    public String getDispatchStatus(Integer userId , Integer orderId);
    public String getArrivingStatus(Integer userId , Integer orderId);
    public String getDeliverStatus(Integer userId , Integer orderId);

}
