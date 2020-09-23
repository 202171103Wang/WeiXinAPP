package javabean2;

public class Shops {
	   private String shopid;    //商铺id
	   private String shopimg;   //商铺图片
	   private String shopname;  //商铺名称
	   private String shopadd; //商铺评价
	   private int shopstar;     //商铺星级
	   private int state;         //商铺状态
	   public String getShopadd() {
		return shopadd;
	}
	public void setShopadd(String shopadd) {
		this.shopadd = shopadd;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getShopimg() {
		return shopimg;
	}
	public void setShopimg(String shopimg) {
		this.shopimg = shopimg;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public int getShopstar() {
		return shopstar;
	}
	public void setShopstar(int shopstar) {
		this.shopstar = shopstar;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	}