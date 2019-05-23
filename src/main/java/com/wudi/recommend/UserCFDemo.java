package com.wudi.recommend;

import com.wudi.mapper.RateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wudi
 * @date ${date} - ${time}
 */

public class UserCFDemo {
    @Autowired
    RateMapper rateMapper;

    //计算用户相似度
    public double calcTwoUserSimilarity(int userid1,int userid2){
        int samebook=rateMapper.sameBookByUserid(userid1,userid2);
        int ubook1=rateMapper.rateSizeByUserid(userid1);
        int ubook2=rateMapper.rateSizeByUserid(userid2);
        double result=samebook/Math.pow(ubook1*ubook2,0.5);
        return result;
    }
}
