package com.sujay.ecs.dao;

import com.sujay.ecs.entity.Admin;

public interface AdminDao {

	boolean loginAdmin(String username, String password);

	boolean updateAdmin(Admin admin);

}
