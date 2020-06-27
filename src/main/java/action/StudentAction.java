package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import PO.Admin;
import PO.Student;
import dao.HbnUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentAction extends ActionSupport {

    private Student student;

    private int stuid;//删除学生学号；

    private String name;
    private String pass;


/*    private int studentID;//修改学生学号
    private String password;
    private String name;
    private String sex;
    private String birthday;
    private String university;
    private String grade;
    private String department;
    private String major;//修改学生专业*/


    private String find;//查找学生
    private String findDep;//查找学院


    private Session hbnsession;
    private Map<String, Object> session;
    private List<Student> stuList = new ArrayList<Student>();
    private List<Student> findstuList = new ArrayList<Student>();


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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getFindDep() {
        return findDep;
    }

    public void setFindDep(String findDep) {
        this.findDep = findDep;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

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



    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }
    //更新session
    public List<Student> UpdateSessin(){
        hbnsession = HbnUtils.getSession();
        hbnsession.beginTransaction();
        ActionContext ac=ActionContext.getContext();
        session=ac.getSession();

        String hql="from Student";
        stuList=hbnsession.createQuery(hql).list();
        session.put("stuList",stuList);
        hbnsession.getTransaction().commit();
        return stuList;
    }
    //学生遍历
    public String findAll(){
        stuList=UpdateSessin();
        if (stuList!=null){
            if (session.get("adminType").equals("超级管理员")){
                return "success_f";
            }else {
                return "success_s";
            }
        } else
            return  "error";
    }

    //根据姓名查找学生
    public String findStudent(){
        hbnsession = HbnUtils.getSession();
        hbnsession.beginTransaction();
        ActionContext ac=ActionContext.getContext();
        session=ac.getSession();

        String hql="from Student where name like ?1";
        find="%"+find+"%";
        System.out.println("find"+find);
        stuList=hbnsession.createQuery(hql)
                .setParameter(1, find)
                .list();
        session.put("findstuList",stuList);
        hbnsession.getTransaction().commit();
        if (findstuList!=null)
            return "success";
        else
            return "error";

    }

    //根据学院查找学生
    public String findDep(){
        hbnsession = HbnUtils.getSession();
        hbnsession.beginTransaction();
        ActionContext ac=ActionContext.getContext();
        session=ac.getSession();

        String hql="from Student where department = ?1";
        findDep=findDep+"学院";
        System.out.println("findDep"+findDep);
        stuList=hbnsession.createQuery(hql)
                .setParameter(1, findDep)
                .list();
        session.put("findstuList",stuList);
        hbnsession.getTransaction().commit();
        if (findstuList!=null)
            return "success";
        else
            return "error";
    }

    //删除
    public String delete(){
        System.out.println("传递的id:"+stuid);
        hbnsession = HbnUtils.getSession();
        hbnsession.beginTransaction();
        ActionContext ac=ActionContext.getContext();
        session=ac.getSession();
        String hql="Delete Student where studentID = ?1";
        Query query=hbnsession.createQuery(hql)
                .setParameter(1, stuid);

        int flag=query.executeUpdate();
        System.out.println(flag);
        hbnsession.getTransaction().commit();
        if (flag>0){
            stuList=UpdateSessin();
            return "success";
        }

        else
            return  "error";

    }

    //添加学生
    public String insertStudent(){
        try{
            hbnsession = HbnUtils.getSession();
            hbnsession.beginTransaction();
            hbnsession.save(student);
            hbnsession.getTransaction().commit();
            stuList=UpdateSessin();
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            return  "error";
        }
    }

    //更新信息
    public String updateStudent(){
        try{
            hbnsession = HbnUtils.getSession();
            hbnsession.beginTransaction();
            hbnsession.update(student);
            hbnsession.getTransaction().commit();
            ActionContext ac=ActionContext.getContext();
            session=ac.getSession();


            System.out.println("adminType"+session.get("adminType"));
            if (session.get("adminType").equals("学生")){
                hbnsession = HbnUtils.getSession();
                hbnsession.beginTransaction();
                String hql="from Student where name = ?1";

                stuList=hbnsession.createQuery(hql)
                        .setParameter(1, session.get("StuUsername"))
                        .list();
                session.put("stuList", stuList);
                hbnsession.getTransaction().commit();
                return "success_stu";
            }else{
                stuList=UpdateSessin();
                return "success_admin";
            }

        }catch(Exception e){
            e.printStackTrace();
            return  "error";
        }

    }

    //学生登陆
    public String login(){
        hbnsession = HbnUtils.getSession();
        hbnsession.beginTransaction();
        ActionContext ac=ActionContext.getContext();
        session=ac.getSession();


        System.out.println("输入名字"+this.getName());
        String hql = "from Student where name=?1 and password=?2";
        Student stu = (Student) hbnsession.createQuery(hql)
                .setParameter(1, this.getName())
                .setParameter(2, this.getPass())
                .uniqueResult();
        System.out.println(stu);

/*        stuList=hbnsession.createQuery(hql)
                .setParameter(1, this.getName())
                .setParameter(2, this.getPass())
                .list();*/
        session.put("stuList", stu);
//        System.out.println("session的id："+session);
        hbnsession.getTransaction().commit();

        if(stu == null) {
            return "login";
        } else {
            session.put("StuUsername",name);
            session.put("adminType","学生");
            System.out.println("传递信息："+session.get("StuUsername"));
            System.out.println("StuUsername is :"+stu.getName());
            return "success";

        }
    }

    }







