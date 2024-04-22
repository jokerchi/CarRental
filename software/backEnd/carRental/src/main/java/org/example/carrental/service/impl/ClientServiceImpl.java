package org.example.carrental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.carrental.dao.ClientDao;
import org.example.carrental.entity.ClientEntity;
import org.example.carrental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl extends ServiceImpl<ClientDao, ClientEntity> implements ClientService {

    @Autowired
    private ClientDao clientDao;

        @Override
        public boolean login(String account, String password) {
            //判断账户以及密码是否正确
//            ClientEntity clientEntity = clientDao.select
//            使用mybatisplus进行查询，根据account查询
            ClientEntity clientEntity = clientDao.selectOne(new QueryWrapper<ClientEntity>().eq("account", account));
            if (clientEntity != null && clientEntity.getPassword().equals(password)) {
                return true;
            }
            return false;
        }

        @Override
        public boolean register(ClientEntity client) {
            //注册账户
            if (clientDao.selectOne(new QueryWrapper<ClientEntity>().eq("account", client.getAccount())) == null) {
                clientDao.insert(client);
                return true;
            }
            return false;
        }

        @Override
        public boolean update(ClientEntity client) {
            //更新账户信息
            if (clientDao.selectById(client.getAccount()) != null) {
                clientDao.updateById(client);
                return true;
            }
            return false;
        }

        @Override
        public boolean logout() {
            //退出登录
            return true;
        }
}
