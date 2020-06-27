package dao;


import PO.Admin;

import java.util.List;

/**
 * 持久层接口
 *
 *
 * **/
public interface IAdminDao {

    List<Admin> findAllAdmin();

    //查询一个
    Admin findAdminByName(String admin_name,String admin_password);

    //保存
    void saveAdmin(Admin admin);

    //更新
    void updateAdmin(Admin admin);

    //删除
    void deleteAdmin(int adminID);
}
