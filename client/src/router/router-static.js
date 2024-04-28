import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import excitingactivities from '@/views/modules/excitingactivities/list'
import qichezixun from '@/views/modules/qichezixun/list'
import aboutus from '@/views/modules/aboutus/list'
import ordinaryadministrator from '@/views/modules/ordinaryadministrator/list'
import returncarinfo from '@/views/modules/returncarinfo/list'
import forum from '@/views/modules/forum/list'
import cancelorder from '@/views/modules/cancelorder/list'
import client from '@/views/modules/client/list'
import carinfo from '@/views/modules/carinfo/list'
import carrentalorder from '@/views/modules/carrentalorder/list'
import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/excitingactivities',
        name: '公告信息',
        component: excitingactivities
      }
      ,{
	path: '/qichezixun',
        name: '汽车资讯',
        component: qichezixun
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/ordinaryadministrator',
        name: '普通管理员',
        component: ordinaryadministrator
      }
      ,{
	path: '/returncarinfo',
        name: '还车信息',
        component: returncarinfo
      }
      ,{
	path: '/forum',
        name: '汽车论坛',
        component: forum
      }
      ,{
	path: '/cancelorder',
        name: '取消订单',
        component: cancelorder
      }
      ,{
	path: '/client',
        name: '用户',
        component: client
      }
      ,{
	path: '/carinfo',
        name: '汽车信息',
        component: carinfo
      }
      ,{
	path: '/carrentalorder',
        name: '租车订单',
        component: carrentalorder
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
