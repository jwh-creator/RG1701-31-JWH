package service.impl;

import PO.Admin;
import dao.IAdminDao;
import service.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {

    private IAdminDao adminDao;

    public void setAdminDao(IAdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminDao.findAllAdmin();
    }

    @Override
    public Admin findAdminByName(String admin_name, String admin_password) {
        return adminDao.findAdminByName(admin_name, admin_password);
    }



    @Override
    public void saveAdmin(Admin admin) {
        adminDao.saveAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);

    }

    @Override
    public void deleteAdmin(int adminID) {
        adminDao.deleteAdmin(adminID);

    }
}
