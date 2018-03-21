
package com.zcchock.provideruser.controller;

import com.zcchock.provideruser.dao.UserEntityDao;
import com.zcchock.provideruser.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class UserController {

    @Resource
    private UserEntityDao userEntityDao;

    @GetMapping("/findUser")
    public UserEntity findOne(@RequestParam String id) {
        UserEntity user;
        user = userEntityDao.findUserEntityById(id);
        return user;
    }

    @GetMapping("/test")
    public Date test() {
        return new Date();
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
