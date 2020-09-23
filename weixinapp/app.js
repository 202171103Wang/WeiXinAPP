//app.js
App({

  onLaunch: function () {
    // 展示本地存储能力
   var that = this;
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        // console.log(res)
        var appid = 'wx515c47483651fda5'; //填写微信小程序appid 
        var secret = '0f99a625c3df610d67b3176384d05a67'; //填写微信小程序secret 
        //调用request请求api转换登录凭证 
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appid + '&secret=' + secret + '&grant_type=authorization_code&js_code=' + res.code,
          header: {
            'content-type': 'application/json'
          },
          success: function (res) {
            var obj = {};
            obj.openid = res.data.openid;
            //console.log(obj);
            wx.setStorageSync('user', obj);//存储openid 
          }
        })
        wx.request({
          url: 'http://192.168.43.29:8080/Online_shop/Person_add_servlet',
          data: {
            openid : wx.getStorageSync('user').openid,
            img: wx.getStorageSync('info').img,
            name: wx.getStorageSync('info').name,
          },
          method: 'GET',
          header: {
            'content-type': 'application/json' // 默认值
          },
          success: function (res) {
            console.log(res);
          },
          fail: function (res) {
            console.log("失败！！！！！！");
          }
        })
      }

    })
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: res => {
              this.globalData.userInfo = res.userInfo
              var obj = {};
              obj.img = res.userInfo.avatarUrl;
              obj.name=res.userInfo.nickName;
              wx.setStorageSync('info', obj);
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null,
  }
})
