// pages/index/seachpage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  name:"",
  array5:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      name: options.name,
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
    var that = this;
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Shopbyname_servlet',
      method: 'GET',
      data: {
        name: this.data.name,
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          array5: res.data
        });
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

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
  lookgoods5: function (e) {
    var shop = parseInt(e.currentTarget.dataset.index);
    var shopid = this.data.array5[shop].shopid;
    wx.navigateTo({
      url: 'shopdetail?shopid=' + shopid,
    })
  }
})