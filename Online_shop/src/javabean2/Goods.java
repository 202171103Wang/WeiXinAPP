package javabean2;

public class Goods {
	private String goodid;     //��Ʒid
	private String goodname;   //��Ʒ����
	private String goodimg;   //��ƷͼƬ
	private int goodnum;      //���
	private float goodprice;  //��Ʒ�۸�
	private String goodkind;  //��Ʒ����
	private String goodmess;  //��Ʒ���
	private String shopid;    //����id
	private String buynum;    //��������
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
