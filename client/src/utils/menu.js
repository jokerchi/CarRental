const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "client"
                }], "menu": "用户管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "普通管理员",
                    "menuJump": "列表",
                    "tableName": "ordinaryadministrator"
                }], "menu": "普通管理员管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "汽车信息",
                    "menuJump": "列表",
                    "tableName": "carinfo"
                }], "menu": "汽车信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["查看", "删除"],
                    "menu": "租车订单",
                    "menuJump": "列表",
                    "tableName": "carrentalorder"
                }], "menu": "租车订单管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["查看", "删除"],
                    "menu": "取消订单",
                    "menuJump": "列表",
                    "tableName": "cancelorder"
                }], "menu": "取消订单管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "删除"],
                    "menu": "还车信息",
                    "menuJump": "列表",
                    "tableName": "returncarinfo"
                }], "menu": "还车信息管理"
            },  {
                "child": [{
                    "appFrontIcon": "cuIcon-group",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "汽车论坛",
                    "tableName": "forum"
                }], "menu": "汽车论坛"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-camera",
                    "buttons": ["查看", "修改"],
                    "menu": "关于我们",
                    "tableName": "aboutus"
                }, {
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "精彩活动",
                    "tableName": "excitingactivities"
                }], "menu": "系统管理"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-rank",
                    "buttons": ["查看", "租赁汽车"],
                    "menu": "汽车信息列表",
                    "menuJump": "列表",
                    "tableName": "carinfo"
                }], "menu": "汽车信息模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "superadministrator"
        }, {
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["查看", "删除", "支付", "归还汽车", "取消订单"],
                    "menu": "租车订单",
                    "menuJump": "列表",
                    "tableName": "carrentalorder"
                }], "menu": "租车订单管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["查看", "删除"],
                    "menu": "取消订单",
                    "menuJump": "列表",
                    "tableName": "cancelorder"
                }], "menu": "取消订单管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["删除", "查看"],
                    "menu": "还车信息",
                    "menuJump": "列表",
                    "tableName": "returncarinfo"
                }], "menu": "还车信息管理"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-rank",
                    "buttons": ["查看", "租赁汽车"],
                    "menu": "汽车信息列表",
                    "menuJump": "列表",
                    "tableName": "carinfo"
                }], "menu": "汽车信息模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "client"
        }, {
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "汽车信息",
                    "menuJump": "列表",
                    "tableName": "carinfo"
                }], "menu": "汽车信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["查看", "删除", "审核"],
                    "menu": "租车订单",
                    "menuJump": "列表",
                    "tableName": "carrentalorder"
                }], "menu": "租车订单管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["查看", "删除", "审核", "支付"],
                    "menu": "取消订单",
                    "menuJump": "列表",
                    "tableName": "cancelorder"
                }], "menu": "取消订单管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "删除", "审核"],
                    "menu": "还车信息",
                    "menuJump": "列表",
                    "tableName": "returncarinfo"
                }], "menu": "还车信息管理"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-rank",
                    "buttons": ["查看", "租赁汽车"],
                    "menu": "汽车信息列表",
                    "menuJump": "列表",
                    "tableName": "carinfo"
                }], "menu": "汽车信息模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "是",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "普通管理员",
            "tableName": "ordinaryadministrator"
        }]
    }
}
export default menu;
