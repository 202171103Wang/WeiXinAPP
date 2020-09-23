// pages/message/cart/cart.js
var app = getApp()
Page({
  data: {
    carts: [], //数据 
    isAllSelect: false,
    totalMoney: 0,
    iscart: true,
    isnull: false,
    shopid:"",
    personid:"",
  },
  onLoad: function (options) {
    var that = this;
    var personid1 = wx.getStorageSync('user').openid;
    that.setData({
      shopid: options.shopid,
      personid: personid1,
      totalMoney:options.sum,
    })
    var shopid=this.data.shopid;
    var personid=this.data.personid;
    console.log('shopid'+shopid);
    console.log('personid'+personid);
  },
  onShow: function () {
    // 获取产品展示页保存的缓存数据（购物车的缓存数组，没有数据，则赋予一个空数组）
    var shopid=this.data.shopid;  
    var arr = wx.getStorageSync('cart'+shopid) || [];
    console.info("缓存数据：" + arr);    // 有数据的话，就遍历数据，计算总金额 和 总数量  
    if (arr.length > 0) {
      // 更新数据  
      this.setData({
        carts: arr,
        totalMoney:0
      });
    }
    else{
      this.setData({
        iscart: false,
        isnull: true
      });
     
    }
  },
  //勾选事件处理函数  
  switchSelect: function (e) {
    // 获取item项的id，和数组的下标值  
    var Allprice = 0, i = 0;
    let id = e.target.dataset.id,
      index = parseInt(e.target.dataset.index);
    this.data.carts[index].isSelect = !this.data.carts[index].isSelect;    //价钱统计
    if (this.data.carts[index].isSelect) {
      this.data.totalMoney = this.data.totalMoney + (this.data.carts[index].goodprice * this.data.carts[index].buynum);
    } else {
      this.data.totalMoney = this.data.totalMoney - (this.data.carts[index].goodprice * this.data.carts[index].buynum);
    }
    //是否全选判断
    for (i = 0; i < this.data.carts.length; i++) {
      Allprice = Allprice + (this.data.carts[index].price * this.data.carts[index].count);
    }
    if (Allprice == this.data.totalMoney) {
      this.data.isAllSelect = true;
    } else {
      this.data.isAllSelect = false;
    }
    this.setData({
      carts: this.data.carts,
      totalMoney: this.data.totalMoney,
      isAllSelect: this.data.isAllSelect,
    })
  },
  //全选
  allSelect: function (e) {
    //处理全选逻辑
    let i = 0;
    if (!this.data.isAllSelect) {
      this.data.totalMoney = 0;
      for (i = 0; i < this.data.carts.length; i++) {
        this.data.carts[i].isSelect = true;
        this.data.totalMoney = this.data.totalMoney + (this.data.carts[i].goodprice * this.data.carts[i].buynum);
      }
    } else {
      for (i = 0; i < this.data.carts.length; i++) {
        this.data.carts[i].isSelect = false;
      }
      this.data.totalMoney = 0;
    }
    this.setData({
      carts: this.data.carts,
      isAllSelect: !this.data.isAllSelect,
      totalMoney: this.data.totalMoney,
    })
  },  // 去结算
  toBuy() {
    var that = this;
    var shopid=this.data.shopid;
    var money=this.data.totalMoney;
    if(money==0)
    {
      
    }
    else{
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Order_addservlet',
      data: {
        shopid: this.data.shopid,
        personid:this.data.personid,
        array:this.data.carts,
        sum:this.data.totalMoney,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        wx.setStorageSync('cart'+shopid, []);
        wx.switchTab({
          url: 'cart',
        })
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    })
    }
  },
  /* 减数 */
  removeFromTrolley: function (e) {
    var index = e.target.dataset.index;
    var count = this.data.carts[index].buynum;    // 商品总数量-1  
    if (count >1) {
      this.data.carts[index].buynum--;
    }
    // 将数值与状态写回  
    this.setData({
      carts: this.data.carts
    });
    this.priceCount();
  },
  /* 加数 */
  addToTrolley: function (e) {
    var index = e.target.dataset.index;
    var count = this.data.carts[index].buynum;    // 商品总数量+1  
    if (count < 10) {
      this.data.carts[index].buynum++;
    }
    // 将数值与状态写回  
    this.setData({
      carts: this.data.carts
    });
    this.priceCount();
  },
  priceCount: function (e) {
    this.data.totalMoney = 0;
    for (var i = 0; i < this.data.carts.length; i++) {
      if (this.data.carts[i].isSelect == true) {
        this.data.totalMoney = this.data.totalMoney + (this.data.carts[i].goodprice * this.data.carts[i].buynum);
      }
    }
    this.setData({
      totalMoney: this.data.totalMoney,
    })
  },
  /* 删除item */
  delGoods: function (e) {
    var shopid=this.data.shopid;
    this.data.carts.splice(e.target.id.substring(3), 1);    // 更新data数据对象  
    if (this.data.carts.length > 0) {
      this.setData({
        carts: this.data.carts
      })
      wx.setStorageSync('cart'+shopid, this.data.carts);
      this.priceCount();
    } else {
      this.setData({
        cart: this.data.carts,
        iscart: false,
        isnull: true
      })
      wx.setStorageSync('cart'+shopid, []);
    }
  }
})