// pages/index/shopdetail.js
var app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
   shopid:"",
   shopmess:[],
   goods:[],
   type:[],
   kind:"",
   menuContent:[],
    swiperTitle: [{
      text: "点菜",
      id: 1
    }, {
      text: "评价",
      id: 2
    }, {
      text: "商家",
      id: 3
    }],
    currentPage: 0,
    selected: 100,
    cost: 0,
    cost1: 0,
    pullBar: false,
    commentList:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  var that=this;
  that.setData({
    shopid:options.shopid,
    cost:0,
  })
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Goodservlet',
      data:{
       shopid:this.data.shopid,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          menuContent: res.data
        });
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    }),
      wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Typeservlet',
        data: {
          shopid: this.data.shopid,
        },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          that.setData({
            type: res.data
          });
        },
        fail: function (res) {
          console.log("失败！！！！！！");
        }
      }),
      wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Comment_selectsh',
        data: {
          shopid: this.data.shopid,
        },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          that.setData({
            commentList: res.data
          });
        },
        fail: function (res) {
          console.log("失败！！！！！！");
        }
      }),
      wx.request({
        url: 'http://192.168.43.29:8080/Online_shop/Shop0servlet',
        data: {
          shopid: this.data.shopid,
        },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          that.setData({
            shopmess: res.data
          });
        },
        fail: function (res) {
          console.log("失败！！！！！！");
        }
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
   var shopid=this.data.shopid;
    var arr = wx.getStorageSync('cart' + shopid);
    if (arr.length >0) {
      // 更新数据  
      this.setData({
        cost1: 1 ,
      });
    }
    else{
      this.setData({
        cost1: 0,
      });
    }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function (){

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
    //页面转移
    turnPage: function(e) {
    this.setData({
      currentPage: e.currentTarget.dataset.index
    })
  },
  //菜单转移
  turnMenu: function (e) {
    var that=this;
    this.setData({
      selected: e.currentTarget.dataset.index
    }),
      wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/menuservlet',
      data: {
        shopid: this.data.shopid,
        kind: this.data.type[this.data.selected]
      },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          that.setData({
            menuContent: res.data
          });
        },
        fail: function (res) {
          console.log("失败！！！！！！");
        }
      })
  },
  //数量增加
  addToTrolley: function (e) {
    var shopid=this.data.shopid;
    var goods = this.data.menuContent[e.currentTarget.dataset.index];
    var info = this.data.menuContent;
    info[e.currentTarget.dataset.index].buynum++;
    this.setData({
      cost: this.data.cost + goods.goodprice,
      menuContent: info,
      cost1:1,
    })
    var arr = wx.getStorageSync('cart' + shopid) || [];
    if (arr.length > 0) 
      { 
        for (var j in arr) 
        {
          if (arr[j].goodid == goods.goodid) 
          {
            arr[j].buynum = arr[j].buynum + 1;
            wx.setStorageSync('cart' + shopid, arr);
            return;
          }
        } 
        arr.push(goods);
        wx.setStorageSync('cart' + shopid, arr);
      } 
      else {
           arr.push(goods);
           wx.setStorageSync('cart' + shopid, arr)
          }

  },
  //数量减少
  removeFromTrolley: function (e) {
    var shopid=this.data.shopid;
    var goods = this.data.menuContent[e.currentTarget.dataset.index];
    var info = this.data.menuContent;
    if (info[e.currentTarget.dataset.index].buynum!= 0) {
      info[e.currentTarget.dataset.index].buynum--;
      this.setData({
        cost: this.data.cost - goods.goodprice,
        menuContent: info,
      })
    }
    var arr = wx.getStorageSync('cart' + shopid) || [];
    if (arr.length > 0) {
      for (var j in arr) 
      {
        if (arr[j].goodid == goods.goodid) 
        {
          if(arr[j].buynum>1)
         {  arr[j].buynum = arr[j].buynum - 1;
            wx.setStorageSync('cart' + shopid, arr);
            return;
         }
         else{
             arr.pop(goods);
             wx.setStorageSync('cart' + shopid, arr);
         }
        }
      }
    }
  },
  go: function () {
    var shopid = this.data.shopid;
    var cost=this.data.cost;
    wx.navigateTo({
      url: 'cart1?shopid=' + shopid+'&sum='+cost,
    })
  }
})