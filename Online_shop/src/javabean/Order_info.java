package javabean;

import java.util.Date;

public class Order_info {
	private String Order_id;
	private int Order_num;
	private int good_num;
	private float Order_sum;
	private Date Order_time;
	private String Order_wait_time;
	private int Order_state;
	private String Order_shopid;
	private String Order_personid;
	public String getOrder_personid() {
		return Order_personid;
	}
	public void setOrder_personid(String order_personid) {
		Order_personid = order_personid;
	}
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	public int getOrder_num() {
		return Order_num;
	}
	public void setOrder_num(int order_num) {
		Order_num = order_num;
	}
	public int getGood_num() {
		return good_num;
	}
	public void setGood_num(int good_num) {
		this.good_num = good_num;
	}
	public float getOrder_sum() {
		return Order_sum;
	}
	public void setOrder_sum(float order_sum) {
		Order_sum = order_sum;
	}
	public Date getOrder_time() {
		return Order_time;
	}
	public void setOrder_time(Date order_time) {
		Order_time = order_time;
	}
	public String getOrder_wait_time() {
		return Order_wait_time;
	}
	public void setOrder_wait_time(String order_wait_time) {
		Order_wait_time = order_wait_time;
	}
	public int getOrder_state() {
		return Order_state;
	}
	public void setOrder_state(int order_state) {
		Order_state = order_state;
	}
	public String getOrder_shopid() {
		return Order_shopid;
	}
	public void setOrder_shopid(String order_shopid) {
		Order_shopid = order_shopid;
	}
	
}
