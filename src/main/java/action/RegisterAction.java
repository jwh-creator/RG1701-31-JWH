package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import dao.HbnUtils;
import org.hibernate.Session;

public class RegisterAction extends ActionSupport {
    private String num;
    private String pass;
    private String name;
    private String sex;
    private String bir;
    private String un;
    private String grade;
    private String dep;
    private String major;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    private Session hbnsession;

    @Before
    public void init(){//初始化方法
        hbnsession = HbnUtils.getSession();

    }

    @Override
    public String execute() throws Exception {
        try {
            hbnsession = HbnUtils.getSession();
            hbnsession.beginTransaction();
            String hql="insert into student_MS(studentID,password,name,sex,birthday,university,grade,department,major) values ('" + num + "','" + pass + "','" + name + "','" + sex + "','" + bir + "','" + un + "','"+ grade +"','"+ dep+"','"+ major +"')";
            int flag= hbnsession.createSQLQuery(hql).executeUpdate();
            hbnsession.getTransaction().commit();
            if (flag!=0)
                return "success";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
