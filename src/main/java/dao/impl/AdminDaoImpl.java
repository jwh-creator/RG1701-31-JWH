package dao.impl;

import PO.Admin;
import dao.IAdminDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.sql.Select;

import javax.persistence.criteria.From;
import java.sql.SQLException;
import java.util.List;
/**
 * 持久层实现类
 * **/
public class AdminDaoImpl implements IAdminDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Admin> findAllAdmin() {
        try {
            return runner.query("select * from admin_ms",new BeanListHandler<>(Admin.class));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Admin findAdminByName(String admin_name,String admin_password) {
        try {
            return runner.query("select * from admin_ms where admin_name = ? and admin_password=?",new BeanHandler<>(Admin.class),admin_name,admin_password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveAdmin(Admin admin) {

        try {
            runner.update("insert into admin_ms(admin_name,admin_password,admin_roleid,admin_rolename)values(?,?,?,?)"
                    ,admin.getAdmin_name(),admin.getAdmin_password(),admin.getAdmin_roleid(),admin.getAdmin_rolename());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        try {
            runner.update("update admin_ms set admin_name=?,admin_password=?,admin_roleid=?,admin_rolename=? where adminID=?"
                    ,admin.getAdmin_name(),admin.getAdmin_password(),admin.getAdmin_roleid(),admin.getAdmin_rolename(),admin.getAdminID());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAdmin(int adminID) {

        try {
            runner.update("delete from admin_ms where adminID=?",adminID);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
