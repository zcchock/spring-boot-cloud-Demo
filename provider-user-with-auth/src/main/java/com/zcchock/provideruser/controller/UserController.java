
package com.zcchock.provideruser.controller;

import com.zcchock.provideruser.dao.UserEntityDao;
import com.zcchock.provideruser.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserEntityDao userEntityDao;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public UserEntity findOne(@PathVariable String id) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();

            for (GrantedAuthority c : collection) {
                UserController.logger.info("当前用户是{},角色是{}", userDetails.getUsername(), c.getAuthority());
            }
        } else {
            System.out.println("我是其他的条件输出");
        }

        UserEntity user;
        user = userEntityDao.findUserEntityById(id);
        return user;
    }

    @GetMapping("/user")
    public UserEntity findUserById(@RequestParam String id) {
        UserEntity user;
        user = userEntityDao.findUserEntityById(id);
        return user;
    }

    @PostMapping("/save")
    public String save(@RequestBody UserEntity user) {
        user.setBirthday(new Date());

        userEntityDao.save(user);//保存数据.
        return "ok";

    }

    @GetMapping("/pageUser")
    public Page<UserEntity> getUserPage(
            @PageableDefault(value = 8, sort = {"tall"}, direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return userEntityDao.findAll(pageable);
    }

}
