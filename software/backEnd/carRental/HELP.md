# Getting Started

引入了Mybatisplus和Swagger2的依赖

数据库使用Mysql

- 约定大于配置
- 项目结构
Springboot
- Config
  - 配置类
- Controller
   - 编写api的
   - login register
   - 接收前端传过来的数据并进行处理 将一些需要做判断以及CRUD操作任务交给Service来处理调用Service将处理结果(Sevice返回给Controller的结果返回给前端)
- Service
  - 处理一些逻辑算法层面的事情
  - 调用DAO、Mapper来对数据进行增剖改查
  - .一些复杂的计算以及格式化操作保存图片。。计算
- Mapper/DAO(持久层)
  - 什么是持久层?什么是持久化
  - 内存!断电即失的那么我们想要永久的进行保存数据那么就需要用的硬盘也就说将数据储存在硬盘里这个就是持久化的一个过程
  - 通俗来说Mapper就是用来做持久化的也就是对数据库进行一个增删改查
  - MyBatis持久层框架帮助我们很好的管理数据进行crud datasoure JDBC交给
  - mybatis管理了
- Entity实体类(domain、pojo. vo、dto、JavaBean)
- Interceptor拦截器
- Utils工具类