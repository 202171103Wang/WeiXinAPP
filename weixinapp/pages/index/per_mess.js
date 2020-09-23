const app = getApp()
Page({
  data: {
    personid: 1,
    call:"",
  },
  onLoad: function() {
    var that = this;
    var personid1 = wx.getStorageSync('user').openid;
    that.setData({
      personid: personid1,
    })
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }

  },
  onShow: function () {
    var that = this;
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Person_select_servlet',
      data: {
        personid: this.data.personid,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          call:res.data,
        });
        if(that.data.call==null)
        {
          that.setData({
            call:"暂无号码"
          })
        }
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    })
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})