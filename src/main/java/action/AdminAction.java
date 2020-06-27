package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import PO.Admin;
import dao.HbnUtils;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAdminService;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Map;

public class AdminAction extends ActionSupport {

    private String name;
    private String pass;
    private Session hbnsession;
    private Map<String, Object> session;
    private ArrayList<Admin> adminArrayList = new ArrayList<Admin>();

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

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
    public String execute() throws Exception {
        hbnsession = HbnUtils.getSession();
        hbnsession.beginTransaction();
        ActionContext ac=ActionContext.getContext();
        session=ac.getSession();


        System.out.println("输入名字"+this.getName());
        String hql = "from Admin where admin_name=?1 and admin_password=?2";
        Admin admin = (Admin)hbnsession.createQuery(hql)
                .setParameter(1, this.getName())
                .setParameter(2, this.getPass())
                .uniqueResult();
        System.out.println(admin);
        System.out.println("管理权限："+admin.getAdmin_rolename());
        hbnsession.getTransaction().commit();


      /*  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAdminService as = ac.getBean("adminService", IAdminService.class);
        Admin admin=as.findAdminByName(name,pass);
        System.out.println(admin);*/

        if(admin == null) {
            return "login";
        } else {
            session.put("adminUsername",name);
            session.put("adminType", admin.getAdmin_rolename());
            System.out.println("传递信息："+session.get("adminUsername"));
            System.out.println("adminUsername is :"+admin.getAdmin_name());
            return "success";

        }
    }
}
