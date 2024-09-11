package com.tns.fooddeliverysystem.entities;

public class DeliveryPerson {
	
	 	private int deliveryPersonId;
	    private String name;
	    private long contactNo;

	    public DeliveryPerson(int deliveryPersonId, String name, long contactNo) {
	        this.deliveryPersonId = deliveryPersonId;
	        this.name = name;
	        this.contactNo = contactNo;
	    }
	    

	    public int getDeliveryPersonId() {
			return deliveryPersonId;
		}


		public void setDeliveryPersonId(int deliveryPersonId) {
			this.deliveryPersonId = deliveryPersonId;
		}


		@Override
	    public String toString() {
	        return "DeliveryPerson{id=" + deliveryPersonId + ", name='" + name + "', contactNo=" + contactNo + "}";
	    }


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public long getContactNo() {
			return contactNo;
		}


		public void setContactNo(long contactNo) {
			this.contactNo = contactNo;
		}
		

}
