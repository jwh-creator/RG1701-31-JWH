package action;

import PO.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import PO.Admin;
import dao.HbnUtils;
import org.hibernate.Session;

import java.util.List;

public class LoginAction extends ActionSupport  {
    private String name;
    private String pass;
    private Session hbnsession;

    public Session getHbnsession() {
        return hbnsession;
    }

    public void setHbnsession(Session hbnsession) {
        this.hbnsession = hbnsession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




    @Override

    public String execute() throws Exception{
        try {
            hbnsession = HbnUtils.getSession();
            hbnsession.beginTransaction();
            String hql="from Admin";
            List<Admin> adminList = hbnsession.createQuery(hql).list();
            System.out.println("输入密码为："+pass);
            System.out.println("输入姓名为："+name);
            for (Admin admin:adminList){
                System.out.println(admin.getAdmin_name()+admin.getAdmin_password());
                if(admin.getAdmin_name().equals(name)&&admin.getAdmin_password().equals(pass))
                    return "success";
            }
            hbnsession.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
