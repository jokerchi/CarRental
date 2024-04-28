import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import ExcitingActivities from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import clientList from '../pages/client/list'
import clientDetail from '../pages/client/detail'
import clientAdd from '../pages/client/add'
import putongguanliyuanList from '../pages/putongguanliyuan/list'
import putongguanliyuanDetail from '../pages/putongguanliyuan/detail'
import putongguanliyuanAdd from '../pages/putongguanliyuan/add'
import carinfoList from '../pages/qichexinxi/list'
import carinfoDetail from '../pages/qichexinxi/detail'
import carinfoAdd from '../pages/qichexinxi/add'
import zuchedingdanList from '../pages/zuchedingdan/list'
import zuchedingdanDetail from '../pages/zuchedingdan/detail'
import zuchedingdanAdd from '../pages/zuchedingdan/add'
import quxiaodingdanList from '../pages/quxiaodingdan/list'
import quxiaodingdanDetail from '../pages/quxiaodingdan/detail'
import quxiaodingdanAdd from '../pages/quxiaodingdan/add'
import haichexinxiList from '../pages/haichexinxi/list'
import haichexinxiDetail from '../pages/haichexinxi/detail'
import haichexinxiAdd from '../pages/haichexinxi/add'
import qichezixunList from '../pages/qichezixun/list'
import qichezixunDetail from '../pages/qichezixun/detail'
import qichezixunAdd from '../pages/qichezixun/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'excitingActivities',
					component: ExcitingActivities
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'client',
					component: clientList
				},
				{
					path: 'clientDetail',
					component: clientDetail
				},
				{
					path: 'clientAdd',
					component: clientAdd
				},
				{
					path: 'putongguanliyuan',
					component: putongguanliyuanList
				},
				{
					path: 'putongguanliyuanDetail',
					component: putongguanliyuanDetail
				},
				{
					path: 'putongguanliyuanAdd',
					component: putongguanliyuanAdd
				},

				{
					path: 'carinfo',
					component: carinfoList
				},
				{
					path: 'carinfoDetail',
					component: carinfoDetail
				},
				{
					path: 'carinfoAdd',
					component: carinfoAdd
				},
				{
					path: 'zuchedingdan',
					component: zuchedingdanList
				},
				{
					path: 'zuchedingdanDetail',
					component: zuchedingdanDetail
				},
				{
					path: 'zuchedingdanAdd',
					component: zuchedingdanAdd
				},
				{
					path: 'quxiaodingdan',
					component: quxiaodingdanList
				},
				{
					path: 'quxiaodingdanDetail',
					component: quxiaodingdanDetail
				},
				{
					path: 'quxiaodingdanAdd',
					component: quxiaodingdanAdd
				},
				{
					path: 'haichexinxi',
					component: haichexinxiList
				},
				{
					path: 'haichexinxiDetail',
					component: haichexinxiDetail
				},
				{
					path: 'haichexinxiAdd',
					component: haichexinxiAdd
				},
				{
					path: 'qichezixun',
					component: qichezixunList
				},
				{
					path: 'qichezixunDetail',
					component: qichezixunDetail
				},
				{
					path: 'qichezixunAdd',
					component: qichezixunAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
