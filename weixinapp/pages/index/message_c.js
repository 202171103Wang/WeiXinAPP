// pages/index/o1.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    personid: 1,
    orderlist: [],
    iscart3: true,
    isnull3: false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var personid1 = wx.getStorageSync('user').openid;
    that.setData({
      personid: personid1,
    })
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/orderservlet2',
      data: {
        personid: this.data.personid,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          orderlist: res.data
        });
        if (that.data.orderlist.length <= 0) {
          that.setData({
            iscart3: false,
            isnull3: true
          })
        }
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
    // 页面渲染完成
  },
  /*
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
  looklist: function (e) {
    var info = this.data.orderlist;
    var orderid = info[e.currentTarget.dataset.index].orderid;
    wx.navigateTo({
      url: 'message_co?orderid=' + orderid,
    })
  },
})