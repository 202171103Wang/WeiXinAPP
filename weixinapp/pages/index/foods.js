var app = getApp()
Page({
  // 导航切换监听
  navbarTap: function (e) {
    console.debug(e);
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
  },
  mask2Cancel: function () {
    this.setData({
      mask2Hidden: false
    })
  },
  finish: function () {
    var ch = [false, false, false, false, false, false, false];
    this.setData({
      mask2Hidden: true,
      characteristicSelected: ch,
    })
  },
  cSelected: function (e) {
    var info = this.data.characteristicSelected;
    info[e.currentTarget.dataset.index] = !info[e.currentTarget.dataset.index];
    if (e.currentTarget.dataset.index == 0) {
      var d1 = false;
      var d2 = true;
      var b1 = true;
      var b2 = true;
    }
    if (e.currentTarget.dataset.index == 1) {
      var d1 = true;
      var d2 = false;
      var b1 = true;
      var b2 = true;
    }
    if (e.currentTarget.dataset.index == 2) {
      var d1 = true;
      var d2 = true;
      var b1 = false;
      var b2 = true;
    }
    if (e.currentTarget.dataset.index == 3) {
      var d1 = true;
      var d2 = true;
      var b1 = true;
      var b2 = false;
    }
    if (e.currentTarget.dataset.index == 4) {
      var d1 = false;
      var d2 = false;
      var b1 = false;
      var b2 = false;
    }
    this.setData({
      characteristicSelected: info,
      hiddenD1: d1,
      hiddenD2: d2,
      hiddenB1: b1,
      hiddenB2: b2,
    })
    console.log(e.currentTarget.dataset.index);
  },
  data: {
    shopname:'',
    mask2Hidden: true,
    hiddenD1: false,
    hiddenD2: false,
    hiddenB1: false,
    hiddenB2: false,
    resu: '食堂',
    navbar: ['菜品推荐'],
    currentTab: 0,
    indicatorDots: true, //设置是否显示面板指示点
    autoplay: true, //设置是否自动切换
    interval: 3000, //设置自动切换时间间隔,3s
    duration: 1000, //  设置滑动动画时长1s
    imgUrls: [
      'http://pic.5tu.cn/uploads/allimg/1905/pic_5tu_big_201904301207062945.jpg',
      'http://pic.5tu.cn/uploads/allimg/1901/pic_5tu_big_201901141723047702.jpg',
      'http://pic.5tu.cn/uploads/allimg/1905/pic_5tu_big_201904291404537832.jpg'
    ],
    characteristicSelected: [false, false, false, false, false, false, false],
    placeList: [{
      text: "东一食堂",
    },
    {
      text: "东二食堂",
    },
    {
      text: "北一食堂",
    },
    {
      text: "北二食堂",
    },
    {
      text: "全部",
    }
    ]
  },
   /**
     * 生命周期函数--监听页面加载
     */
  onLoad: function (options) {
    var that=this;
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Shop1servlet',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          array1: res.data
        });
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    })
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Shop2servlet',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          array2: res.data
        });
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    })
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Shop3servlet',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          array3: res.data
        });
      },
      fail: function (res) {
        console.log("失败！！！！！！");
      }
    })
    wx.request({
      url: 'http://192.168.43.29:8080/Online_shop/Shop4servlet',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          array4: res.data
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
         // 有数据的话，就遍历数据，计算总金额 和 总数量  
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
    wxSearchInput:function(e){
      this.setData({
        shopname: e.detail.value
      })

    },
    searchname:function(){
      var shopname=this.data.shopname;
      wx.navigateTo({
        url: 'seachpage?name='+shopname,
      })
    
    },
    lookgoods1: function (e) {
      var shop = parseInt(e.currentTarget.dataset.index);
      var shopid = this.data.array1[shop].shopid;
      wx.navigateTo({
        url: 'shopdetail?shopid=' + shopid,
      })
    },
     lookgoods2: function (e) {
    var shop = parseInt(e.currentTarget.dataset.index);
    var shopid = this.data.array2[shop].shopid;
    wx.navigateTo({
      url: 'shopdetail?shopid=' + shopid,
    })
  },
   lookgoods3: function (e) {
    var shop = parseInt(e.currentTarget.dataset.index);
    var shopid = this.data.array3[shop].shopid;
    wx.navigateTo({
      url: 'shopdetail?shopid=' + shopid,
    })
  },
   lookgoods4: function (e) {
    var shop = parseInt(e.currentTarget.dataset.index);
    var shopid = this.data.array4[shop].shopid;
    wx.navigateTo({
      url: 'shopdetail?shopid=' + shopid,
    })
  }
})