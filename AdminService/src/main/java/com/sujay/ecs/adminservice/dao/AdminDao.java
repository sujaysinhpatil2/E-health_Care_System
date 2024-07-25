package com.sujay.ecs.adminservice.dao;

import com.sujay.ecs.adminservice.entity.Admin;

public interface AdminDao {

	boolean loginAdmin(String username, String password);

	boolean updateAdmin(Admin admin);

}
