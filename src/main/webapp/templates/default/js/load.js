var LoadFramge={   
    'loadEle':$(),
    'loadTipEle':$('<div class="bLoad_i">aa<div>'),
    'errorTipEle':$('<div class="bLoad_e"><span style="font-size: 17px;">bb<span><br/><span style="color:#FF6100;">cc</span></div>'),
    'conFailTipEle': $('<div class="bLoad_e"><span style="font-size: 17px;">ee</span><br/><span style="color:#FF6100;">dd</span></div>'),
    'isErrorHappened':false,     
    'childMarginTop': 0,
    'init':function(){ 
        var obj = $(".js_lHei"),
            mHeight = window.screen.height - obj.offset().top+20;
            this.childMarginTop = mHeight/2-70;
            alert(mHeight)
        obj.height(mHeight);  
        obj.children().css("margin-top",this.childMarginTop);
        this.loadTipEle.css("margin-top",this.childMarginTop);
        this.loadEle = obj;
    },
    'setChildStyle': function($eleTip){
        $eleTip.css("margin-top",this.childMarginTop-20);
        $eleTip.click(function(){
            location.reload(true);
        });
    },
    'errorShow':function(){   
       this.setChildStyle(this.errorTipEle);
       this.loadEle.html(this.errorTipEle);
       this.isErrorHappened = true;
    },
    'failedShow':function(){   
       this.setChildStyle(this.conFailTipEle);
       this.loadEle.html(this.conFailTipEle);
       this.isErrorHappened = true;
    },
    'moreShow':function(wantShowStr){ 
        if(this.isErrorHappened){
            this.loadEle.html(this.loadTipEle);
            this.isErrorHappened = false;
        }
        if(wantShowStr)
            this.loadTipEle.text(wantShowStr);
        this.loadEle.show();
    },
    'hide':function(){
        this.loadEle.hide();
    }
};


    
    
    

