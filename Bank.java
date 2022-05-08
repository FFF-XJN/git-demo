package banks;

import house.room1.Person;

public class Bank {
    public void doBusiness(Person person){
        System.out.println("银行办理业务：");
        //你的年龄
        //person.age 不行，因为age是无修饰符，只能在同一个包中被使用
        //可以通过public方法获取年龄
        System.out.println("请你告诉我你的年龄：" + person.getAge());
        //多少钱
        //money是私有的，只能在类内部被访问
        //可以通过public方法获取钱
        System.out.println("你大概的资产：" + person.getMoney());
    }

}
