package com.sujay.ecs.UserService.DTO;

import java.util.List;

import com.sujay.ecs.UserService.model.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponce {

    private List<Admin> adminList;
    
}
