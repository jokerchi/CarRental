package org.example.carrental.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.carrental.entity.ClientEntity;

public interface ClientService extends IService<ClientEntity> {

    //实现登录判断账户以及密码是否正确
    boolean login(String account, String password);

    boolean register(ClientEntity client);

    boolean update(ClientEntity client);

    boolean logout();
}
