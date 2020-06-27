package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUtils {
    private static SessionFactory sessionFactory;

    public static  Session getSession(){
        //2.创建session工厂,session不是会话，而是一个数据库连接对象conn
//        SessionFactory sf = getSessionFactory();

        //3.打开一个连接session
        //3.1创建一个新的session
//        Session session=sf.openSession();

        //3.2打开当前线程的一个session,无需手动关闭，需要注册绑定环境，查询要在事务内执行
//        Session session=sessionFactory.getCurrentSession();//是单例模式

        return getSessionFactory().getCurrentSession();
    }

    //单例模式设置
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null || sessionFactory.isClosed()){
            sessionFactory=new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }


}
