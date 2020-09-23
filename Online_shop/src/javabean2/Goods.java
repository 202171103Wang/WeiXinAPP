package javabean2;

public class Goods {
	private String goodid;     //商品id
	private String goodname;   //商品名称
	private String goodimg;   //商品图片
	private int goodnum;      //库存
	private float goodprice;  //商品价格
	private String goodkind;  //商品类型
	private String goodmess;  //商品简介
	private String shopid;    //商铺id
	private String buynum;    //购买数量
	public String getGoodid() {
		return goodid;
	}
	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getGoodimg() {
		return goodimg;
	}
	public void setGoodimg(String goodimg) {
		this.goodimg = goodimg;
	}
	public int getGoodnum() {
		return goodnum;
	}
	public void setGoodnum(int goodnum) {
		this.goodnum = goodnum;
	}
	public float getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(float goodprice) {
		this.goodprice = goodprice;
	}
	public String getGoodkind() {
		return goodkind;
	}
	public void setGoodkind(String goodkind) {
		this.goodkind = goodkind;
	}
	public String getGoodmess() {
		return goodmess;
	}
	public void setGoodmess(String goodmess) {
		this.goodmess = goodmess;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getBuynum() {
		return buynum;
	}
	public void setBuynum(String buynum) {
		this.buynum = buynum;
	}
	public String toString() {
		String a="Goodid="+this.goodid+"Goodbuynum="+this.buynum;
		
		return a;
	}
	
}
