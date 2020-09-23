// pages/index/login.js
var app = getApp(); 
Page({
  
  data: {
   showTopTips: false,
   errorMsg: "",
    personid: 1,
   },
  onLoad: function () {
    var that = this;
    var personid1 = wx.getStorageSync('user').openid;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          windowHeight: res.windowHeight,
          windowWidth: res.windowWidth,
          personid: personid1,
        })
      }
    });
  },
  formSubmit: function (e) {
    // form 表单取值，格式 e.detail.value.name(name为input中自定义name值) ；使用条件：需通过<form bindsubmit="formSubmit">与<button formType="submit">一起使用    
    var account = e.detail.value.account;
    var that = this;
    // 判断账号是否为空和判断该账号名是否被注册    
    if (account=="")
     {
        // 显示消息提示框       
        wx.showToast({
          title: '手机号不能为空',
          duration: 2000
        })
      }
      else{
      wx.request({
        url: 'http://192.168.43.29:8080/Online_shop/Person_addcall_servlet',
        data: {
          personid: this.data.personid,
          call:account,
        },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res);
          wx.showToast({
            title: '手机号绑定成功！',
            duration: 2000
          })
        },
        fail: function (res) {
          console.log("失败！！！！！！");
        }
      })
          
      }
  }
})