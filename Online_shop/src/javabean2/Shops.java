package javabean2;

public class Shops {
	   private String shopid;    //����id
	   private String shopimg;   //����ͼƬ
	   private String shopname;  //��������
	   private String shopadd; //��������
	   private int shopstar;     //�����Ǽ�
	   private int state;         //����״̬
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