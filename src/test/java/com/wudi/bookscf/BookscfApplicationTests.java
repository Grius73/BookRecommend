package com.wudi.bookscf;

import com.wudi.mapper.AccountMapper;
import com.wudi.mapper.ClickMapper;
import com.wudi.mapper.HistoryMapper;
import com.wudi.mapper.RateMapper;
import com.wudi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookscfApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    RateMapper rateMapper;
    @Autowired
    HistoryService historyService;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    ClickMapper clickMapper;
    @Autowired
    BookService bookService;
    @Autowired
    ClickService clickService;
    @Autowired
    RateService rateService;

    private String test="sadasdasda";
    private String test1="lisi";
    //test userService
//    @Test
//    public void userTests() {
//        if (userService.isUserExist(test))
//        {System.out.println("用户存在");}
//        else{System.out.println("用户不存在");}
//        if (userService.isUserExist(test1))
//        {System.out.println("用户存在");}
//        else{System.out.println("用户不存在");}
//        if (userService.queryByUsername(test1).getPassword().equals("test"))
//        {System.out.println("密码正确");}
//        else{System.out.println("密码错误");}
//    }
//    @Test
//    public void accountTests(){
//        accountMapper.deleteByPrimaryKey(3);
//    }
//    @Test
//    public void rateTests(){
//        List<Rate> rates =rateMapper.selectByUserid(8);
//        for(int i=0;i<rates.size();i++)
//        {
//            System.out.println(rates.get(i));
//        }
//    }
//    @Test
//    public void historyTests(){
//        List<Book> books =historyService.queryBookByHistory(8);
//        for(int i=0;i<books.size();i++){
//            System.out.println(books.get(i));
//        }
////        List<Integer> bookids=historyMapper.queryBookidByUserid(8);
////        for(int i=0;i<bookids.size();i++){
////            System.out.println(bookids.get(i));
////        }
//    }
//    @Test
//    public void clickTests(){
//        List<Integer> bookids =clickMapper.returnHotBookid();
//        for(int i=0;i<bookids.size();i++){
//            System.out.println(bookids.get(i));
//        }
//    }
//    @Test
//    public void testCF(){
//        List<Integer>users=rateMapper.getRelateUserid(8);
//        List<Integer>books=rateMapper.getRelatedBookid(users);
//        for(int i=0;i<books.size();i++){
//            System.out.println(books.get(i));
//        }
//    }
//    @Test
//    public void testCF2(){
////        UserCFDemo user =new UserCFDemo();
//////        double test=user.calcTwoUserSimilarity(8,638);
//////        System.out.println(test);
////        System.out.println(rateMapper.sameBookByUserid(8,638));
//        List<Book> books=bookService.recommendBooksBasedItem(882,10);
//    //  List<Book> books= bookService.recommendBooksBasedUser(10,10);
//      for(int i=0;i<books.size();i++){
//          System.out.println(books.get(i));
//      }
//    }
//    @Test
//    public void testa(){
//        for(int i=0;i<books.size();i++){
//            System.out.println(books.get(i).getNum());
//            System.out.println(books.get(i).getTitle());
//        }
//    }
//    @Test
//    public void testb(){
//        HistoryKey historyKey=new HistoryKey();
//        historyKey.setBookid(4);
//        historyKey.setUserid(8);
//        RateKey rateKey=new RateKey();
//        rateKey.setUserid(8);
//        rateKey.setBookid(4);
//        int test1= rateService.isRecordExist(8,74);
//        Integer test=historyMapper.countByPrimaryKey(historyKey);
//        if(test==null)
//        {System.out.println("不存在000");}
//        if(test!=null)
//        {System.out.println(test);}
//        System.out.println(test1);
//    }
    @Test
    public void testClicks(){
//        Click click=new Click();
//        click.setBookid(38742);
//        click.setSize(clickMapper.selectByPrimaryKey(38742).getSize());
        LocalDate today=LocalDate.now();
        System.out.println(today);
    }
}
