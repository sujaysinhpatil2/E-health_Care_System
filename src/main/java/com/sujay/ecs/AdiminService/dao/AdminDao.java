package com.sujay.ecs.AdiminService.dao;

import com.sujay.ecs.AdiminService.entity.Admin;

public interface AdminDao {

	boolean loginAdmin(String username, String password);

	boolean updateAdmin(Admin admin);

}
