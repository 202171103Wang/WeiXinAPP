package javabean2;

public class Orders {
	private String orderid;
	private String ordertime;
	private int orderstate;   
	private int goodnum; 
	private String shopid;   
	private int ordernum;
	private float ordersum;
	private String shopname;
	private String shopimg;
	public String getShopname() {
		return shopname;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopimg() {
		return shopimg;
	}
	public void setShopimg(String shopimg) {
		this.shopimg = shopimg;
	}
	public float getOrdersum() {
		return ordersum;
	}
	public void setOrdersum(float ordersum) {
		this.ordersum = ordersum;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	public int getGoodnum() {
		return goodnum;
	}
	public void setGoodnum(int goodnum) {
		this.goodnum = goodnum;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}    
	
}
