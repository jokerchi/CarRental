create table aboutus
(
    id       bigint auto_increment comment '主键'
        primary key,
    addtime  timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    title    varchar(200)                        not null comment '标题',
    subtitle varchar(200)                        null comment '副标题',
    content  longtext                            not null comment '内容',
    picture1 longtext                            null comment '图片1',
    picture2 longtext                            null comment '图片2',
    picture3 longtext                            null comment '图片3'
)
    comment '关于我们';

create table config
(
    id    bigint auto_increment comment '主键'
        primary key,
    name  varchar(100) not null comment '配置参数名称',
    value varchar(100) null comment '配置参数值'
)
    comment '配置文件';

create table forum
(
    id        bigint auto_increment comment '主键'
        primary key,
    addtime   timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    title     varchar(200)                        null comment '帖子标题',
    content   longtext                            not null comment '帖子内容',
    parentid  bigint                              null comment '父节点id',
    userid    bigint                              not null comment '用户id',
    username  varchar(200)                        null comment '用户名',
    avatarurl longtext                            null comment '头像',
    isdone    varchar(200)                        null comment '状态'
)
    comment '汽车论坛';

create table haichexinxi
(
    id             bigint auto_increment comment '主键'
        primary key,
    addtime        timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    dingdanbianhao varchar(200)                           null comment '订单编号',
    chepaihao      varchar(200)                           null comment '车牌号',
    cheliangpinpai varchar(200)                           null comment '车辆品牌',
    qicheleibie    varchar(200)                           null comment '汽车类别',
    haicheriqi     date                                   null comment '还车日期',
    haichebeizhu   longtext                               null comment '还车备注',
    zhanghao       varchar(200)                           null comment '账号',
    xingming       varchar(200)                           null comment '姓名',
    shouji         varchar(200)                           null comment '手机',
    shenfenzheng   varchar(200)                           null comment '身份证',
    guanlizhanghao varchar(200)                           null comment '管理账号',
    guanlixingming varchar(200)                           null comment '管理姓名',
    crossuserid    bigint                                 null comment '跨表用户id',
    crossrefid     bigint                                 null comment '跨表主键id',
    sfsh           varchar(200) default '待审核'          null comment '是否审核',
    shhf           longtext                               null comment '审核回复'
)
    comment '还车信息';

create table messages
(
    id        bigint auto_increment comment '主键'
        primary key,
    addtime   timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    userid    bigint                              not null comment '留言人id',
    username  varchar(200)                        null comment '用户名',
    avatarurl longtext                            null comment '头像',
    content   longtext                            not null comment '留言内容',
    cpicture  longtext                            null comment '留言图片',
    reply     longtext                            null comment '回复内容',
    rpicture  longtext                            null comment '回复图片'
)
    comment '留言板';

create table news
(
    id           bigint auto_increment comment '主键'
        primary key,
    addtime      timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    title        varchar(200)                        not null comment '标题',
    introduction longtext                            null comment '简介',
    picture      longtext                            not null comment '图片',
    content      longtext                            not null comment '内容'
)
    comment '公告信息';

create table putongguanliyuan
(
    id             bigint auto_increment comment '主键'
        primary key,
    addtime        timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    guanlizhanghao varchar(200)                        not null comment '管理账号',
    mima           varchar(200)                        not null comment '密码',
    guanlixingming varchar(200)                        not null comment '管理姓名',
    xingbie        varchar(200)                        null comment '性别',
    nianling       varchar(200)                        not null comment '年龄',
    lianxidianhua  varchar(200)                        not null comment '联系电话',
    touxiang       longtext                            null comment '头像',
    constraint guanlizhanghao
        unique (guanlizhanghao)
)
    comment '普通管理员';

create table qicheleibie
(
    id          bigint auto_increment comment '主键'
        primary key,
    addtime     timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    qicheleibie varchar(200)                        null comment '汽车类别',
    constraint qicheleibie
        unique (qicheleibie)
)
    comment '汽车类别';

create table qichexinxi
(
    id               bigint auto_increment comment '主键'
        primary key,
    addtime          timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    chepaihao        varchar(200)                        not null comment '车牌号',
    cheliangxinghao  varchar(200)                        null comment '车辆型号',
    qicheleibie      varchar(200)                        null comment '汽车类别',
    cheliangpinpai   varchar(200)                        not null comment '车辆品牌',
    jiage            float                               null comment '价格',
    yanse            varchar(200)                        null comment '颜色',
    zhuangtai        varchar(200)                        null comment '状态',
    huandangfangshi  varchar(200)                        null comment '换挡方式',
    cheliangzhaopian longtext                            null comment '车辆照片',
    zuoweishu        int                                 null comment '座位数',
    qichepailiang    varchar(200)                        null comment '汽车排量',
    qichejiage       float                               null comment '汽车价格',
    chuchangnianfen  varchar(200)                        null comment '出厂年份',
    dengjiriqi       date                                null comment '登记日期',
    qichejianjie     longtext                            null comment '汽车简介',
    guanlizhanghao   varchar(200)                        null comment '管理账号',
    guanlixingming   varchar(200)                        null comment '管理姓名',
    clicktime        datetime                            null comment '最近点击时间',
    clicknum         int       default 0                 null comment '点击次数',
    constraint chepaihao
        unique (chepaihao)
)
    comment '汽车信息';

create table qichezixun
(
    id          bigint auto_increment comment '主键'
        primary key,
    addtime     timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    biaoti      varchar(200)                        not null comment '标题',
    jianjie     longtext                            null comment '简介',
    fabushijian date                                null comment '发布时间',
    neirong     longtext                            null comment '内容',
    faburen     varchar(200)                        not null comment '发布人',
    fengmian    longtext                            null comment '封面',
    clicktime   datetime                            null comment '最近点击时间',
    clicknum    int       default 0                 null comment '点击次数',
    userid      bigint                              null comment '用户id'
)
    comment '汽车资讯';

create table quxiaodingdan
(
    id             bigint auto_increment comment '主键'
        primary key,
    addtime        timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    dingdanbianhao varchar(200)                           null comment '订单编号',
    chepaihao      varchar(200)                           null comment '车牌号',
    cheliangpinpai varchar(200)                           null comment '车辆品牌',
    qicheleibie    varchar(200)                           null comment '汽车类别',
    jiage          float                                  null comment '价格',
    zuqi           int                                    null comment '租期',
    zongjia        float                                  null comment '总价',
    quxiaoriqi     date                                   null comment '取消日期',
    quxiaoyuanyin  longtext                               null comment '取消原因',
    zhanghao       varchar(200)                           null comment '账号',
    xingming       varchar(200)                           null comment '姓名',
    shouji         varchar(200)                           null comment '手机',
    shenfenzheng   varchar(200)                           null comment '身份证',
    guanlizhanghao varchar(200)                           null comment '管理账号',
    guanlixingming varchar(200)                           null comment '管理姓名',
    crossuserid    bigint                                 null comment '跨表用户id',
    crossrefid     bigint                                 null comment '跨表主键id',
    sfsh           varchar(200) default '待审核'          null comment '是否审核',
    shhf           longtext                               null comment '审核回复',
    ispay          varchar(200) default '未支付'          null comment '是否支付'
)
    comment '取消订单';

create table storeup
(
    id        bigint auto_increment comment '主键'
        primary key,
    addtime   timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    userid    bigint                                 not null comment '用户id',
    refid     bigint                                 null comment '商品id',
    tablename varchar(200)                           null comment '表名',
    name      varchar(200)                           not null comment '名称',
    picture   longtext                               not null comment '图片',
    type      varchar(200) default '1'               null comment '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
    inteltype varchar(200)                           null comment '推荐类型',
    remark    varchar(200)                           null comment '备注'
)
    comment '收藏表';

create table systemintro
(
    id       bigint auto_increment comment '主键'
        primary key,
    addtime  timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    title    varchar(200)                        not null comment '标题',
    subtitle varchar(200)                        null comment '副标题',
    content  longtext                            not null comment '内容',
    picture1 longtext                            null comment '图片1',
    picture2 longtext                            null comment '图片2',
    picture3 longtext                            null comment '图片3'
)
    comment '关于我们';

create table token
(
    id            bigint auto_increment comment '主键'
        primary key,
    userid        bigint                              not null comment '用户id',
    username      varchar(100)                        not null comment '用户名',
    tablename     varchar(100)                        null comment '表名',
    role          varchar(100)                        null comment '角色',
    token         varchar(200)                        not null comment '密码',
    addtime       timestamp default CURRENT_TIMESTAMP not null comment '新增时间',
    expiratedtime timestamp default CURRENT_TIMESTAMP not null comment '过期时间'
)
    comment 'token表';

create table users
(
    id       bigint auto_increment comment '主键'
        primary key,
    username varchar(100)                           not null comment '用户名',
    password varchar(100)                           not null comment '密码',
    role     varchar(100) default '管理员'          null comment '角色',
    addtime  timestamp    default CURRENT_TIMESTAMP not null comment '新增时间'
)
    comment '用户表';

create table yonghu
(
    id           bigint auto_increment comment '主键'
        primary key,
    addtime      timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    zhanghao     varchar(200)                        not null comment '账号',
    mima         varchar(200)                        not null comment '密码',
    xingming     varchar(200)                        not null comment '姓名',
    nianling     int                                 null comment '年龄',
    xingbie      varchar(200)                        null comment '性别',
    shenfenzheng varchar(200)                        not null comment '身份证',
    shouji       varchar(200)                        null comment '手机',
    touxiang     longtext                            null comment '头像',
    constraint zhanghao
        unique (zhanghao)
)
    comment '用户';

create table zuchedingdan
(
    id             bigint auto_increment comment '主键'
        primary key,
    addtime        timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    dingdanbianhao varchar(200)                           null comment '订单编号',
    chepaihao      varchar(200)                           null comment '车牌号',
    cheliangpinpai varchar(200)                           null comment '车辆品牌',
    qicheleibie    varchar(200)                           null comment '汽车类别',
    jiage          float                                  null comment '价格',
    zuqi           int                                    not null comment '租期',
    zongjia        float                                  null comment '总价',
    chuzuriqi      date                                   null comment '出租日期',
    beizhu         longtext                               null comment '备注',
    zhanghao       varchar(200)                           null comment '账号',
    xingming       varchar(200)                           null comment '姓名',
    shouji         varchar(200)                           null comment '手机',
    shenfenzheng   varchar(200)                           null comment '身份证',
    guanlizhanghao varchar(200)                           null comment '管理账号',
    guanlixingming varchar(200)                           null comment '管理姓名',
    sfsh           varchar(200) default '待审核'          null comment '是否审核',
    shhf           longtext                               null comment '审核回复',
    ispay          varchar(200) default '未支付'          null comment '是否支付',
    constraint dingdanbianhao
        unique (dingdanbianhao)
)
    comment '租车订单';


