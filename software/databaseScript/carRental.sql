/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.18-log : Database - db_qczl
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_qczl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `carRental`;

/*Table structure for table `aboutus` */

DROP TABLE IF EXISTS `aboutus`;

CREATE TABLE `aboutus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '副标题',
  `content` longtext NOT NULL COMMENT '内容',
  `picture1` longtext COMMENT '图片1',
  `picture2` longtext COMMENT '图片2',
  `picture3` longtext COMMENT '图片3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关于我们';

/*Data for the table `aboutus` */

insert  into `aboutus`(`id`,`addtime`,`title`,`subtitle`,`content`,`picture1`,`picture2`,`picture3`) values (1,'2023-03-08 10:33:51','关于我们','ABOUT US','不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?\n你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。','upload/aboutus_picture1.jpg','upload/aboutus_picture2.jpg','upload/aboutus_picture3.jpg');

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`value`) values (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');

/*Table structure for table `forum` */

DROP TABLE IF EXISTS `forum`;

CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='汽车论坛';

/*Data for the table `forum` */

insert  into `forum`(`id`,`addtime`,`title`,`content`,`parentid`,`userid`,`username`,`avatarurl`,`isdone`) values (91,'2023-03-08 10:33:51','帖子标题1','帖子内容1',0,1,'用户名1','upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg','开放'),(92,'2023-03-08 10:33:51','帖子标题2','帖子内容2',0,2,'用户名2','upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg','开放'),(93,'2023-03-08 10:33:51','帖子标题3','帖子内容3',0,3,'用户名3','upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg','开放'),(94,'2023-03-08 10:33:51','帖子标题4','帖子内容4',0,4,'用户名4','upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg','开放'),(95,'2023-03-08 10:33:51','帖子标题5','帖子内容5',0,5,'用户名5','upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg','开放'),(96,'2023-03-08 10:33:51','帖子标题6','帖子内容6',0,6,'用户名6','upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg','开放'),(97,'2023-03-08 10:33:51','帖子标题7','帖子内容7',0,7,'用户名7','upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg,upload/forum_avatarurl9.jpg','开放'),(98,'2023-03-08 10:33:51','帖子标题8','帖子内容8',0,8,'用户名8','upload/forum_avatarurl8.jpg,upload/forum_avatarurl9.jpg,upload/forum_avatarurl10.jpg','开放');

/*Table structure for table `haichexinxi` */

DROP TABLE IF EXISTS `haichexinxi`;

CREATE TABLE `haichexinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangpinpai` varchar(200) DEFAULT NULL COMMENT '车辆品牌',
  `qicheleibie` varchar(200) DEFAULT NULL COMMENT '汽车类别',
  `haicheriqi` date DEFAULT NULL COMMENT '还车日期',
  `haichebeizhu` longtext COMMENT '还车备注',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `guanlizhanghao` varchar(200) DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(200) DEFAULT NULL COMMENT '管理姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1709201219728 DEFAULT CHARSET=utf8 COMMENT='还车信息';

/*Data for the table `haichexinxi` */

insert  into `haichexinxi`(`id`,`addtime`,`dingdanbianhao`,`chepaihao`,`cheliangpinpai`,`qicheleibie`,`haicheriqi`,`haichebeizhu`,`zhanghao`,`xingming`,`shouji`,`shenfenzheng`,`guanlizhanghao`,`guanlixingming`,`crossuserid`,`crossrefid`,`sfsh`,`shhf`) values (71,'2023-03-08 10:33:51','订单编号1','车牌号1','车辆品牌1','汽车类别1','2023-03-08','还车备注1','账号1','姓名1','13823888881','身份证1','管理账号1','管理姓名1',1,1,'是',''),(72,'2023-03-08 10:33:51','订单编号2','车牌号2','车辆品牌2','汽车类别2','2023-03-08','还车备注2','账号2','姓名2','13823888882','身份证2','管理账号2','管理姓名2',2,2,'是',''),(73,'2023-03-08 10:33:51','订单编号3','车牌号3','车辆品牌3','汽车类别3','2023-03-08','还车备注3','账号3','姓名3','13823888883','身份证3','管理账号3','管理姓名3',3,3,'是',''),(74,'2023-03-08 10:33:51','订单编号4','车牌号4','车辆品牌4','汽车类别4','2023-03-08','还车备注4','账号4','姓名4','13823888884','身份证4','管理账号4','管理姓名4',4,4,'是',''),(75,'2023-03-08 10:33:51','订单编号5','车牌号5','车辆品牌5','汽车类别5','2023-03-08','还车备注5','账号5','姓名5','13823888885','身份证5','管理账号5','管理姓名5',5,5,'是',''),(76,'2023-03-08 10:33:51','订单编号6','车牌号6','车辆品牌6','汽车类别6','2023-03-08','还车备注6','账号6','姓名6','13823888886','身份证6','管理账号6','管理姓名6',6,6,'是',''),(77,'2023-03-08 10:33:51','订单编号7','车牌号7','车辆品牌7','汽车类别7','2023-03-08','还车备注7','账号7','姓名7','13823888887','身份证7','管理账号7','管理姓名7',7,7,'是',''),(78,'2023-03-08 10:33:51','订单编号8','车牌号8','车辆品牌8','汽车类别8','2023-03-08','还车备注8','账号8','姓名8','13823888888','身份证8','管理账号8','管理姓名8',8,8,'是',''),(1709200834335,'2024-02-29 18:00:33','1111111111','车牌号1','车辆品牌1','汽车类别1','2024-02-29','111','账号1','姓名1','13823888881','440300199101010001','管理账号1','管理姓名1',11,51,'是',''),(1709201219727,'2024-02-29 18:06:58','1709201101690','车牌号1','车辆品牌1','汽车类别1','2024-02-29','不要了','账号1','姓名1','13823888881','440300199101010001','管理账号1','管理姓名1',11,1709201124697,'是','haode ');

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '留言人id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `content` longtext NOT NULL COMMENT '留言内容',
  `cpicture` longtext COMMENT '留言图片',
  `reply` longtext COMMENT '回复内容',
  `rpicture` longtext COMMENT '回复图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COMMENT='留言板';

/*Data for the table `messages` */

insert  into `messages`(`id`,`addtime`,`userid`,`username`,`avatarurl`,`content`,`cpicture`,`reply`,`rpicture`) values (141,'2023-03-08 10:33:51',1,'用户名1','upload/messages_avatarurl1.jpg','留言内容1','upload/messages_cpicture1.jpg','回复内容1','upload/messages_rpicture1.jpg'),(142,'2023-03-08 10:33:51',2,'用户名2','upload/messages_avatarurl2.jpg','留言内容2','upload/messages_cpicture2.jpg','回复内容2','upload/messages_rpicture2.jpg'),(143,'2023-03-08 10:33:51',3,'用户名3','upload/messages_avatarurl3.jpg','留言内容3','upload/messages_cpicture3.jpg','回复内容3','upload/messages_rpicture3.jpg'),(144,'2023-03-08 10:33:51',4,'用户名4','upload/messages_avatarurl4.jpg','留言内容4','upload/messages_cpicture4.jpg','回复内容4','upload/messages_rpicture4.jpg'),(145,'2023-03-08 10:33:51',5,'用户名5','upload/messages_avatarurl5.jpg','留言内容5','upload/messages_cpicture5.jpg','回复内容5','upload/messages_rpicture5.jpg'),(146,'2023-03-08 10:33:51',6,'用户名6','upload/messages_avatarurl6.jpg','留言内容6','upload/messages_cpicture6.jpg','回复内容6','upload/messages_rpicture6.jpg'),(147,'2023-03-08 10:33:51',7,'用户名7','upload/messages_avatarurl7.jpg','留言内容7','upload/messages_cpicture7.jpg','回复内容7','upload/messages_rpicture7.jpg'),(148,'2023-03-08 10:33:51',8,'用户名8','upload/messages_avatarurl8.jpg','留言内容8','upload/messages_cpicture8.jpg','回复内容8','upload/messages_rpicture8.jpg');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COMMENT='公告信息';

/*Data for the table `news` */

insert  into `news`(`id`,`addtime`,`title`,`introduction`,`picture`,`content`) values (111,'2023-03-08 10:33:51','有梦想，就要努力去实现','不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。','upload/news_picture1.jpg','<p>不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?</p><p>你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。</p><p>真正有行动力的人不需要别人告诉他如何做，因为他已经在做了。就算碰到问题，他也会自己想办法，自己动手去解决或者主动寻求可以帮助他的人，而不是等着别人为自己解决问题。</p><p>首先要学习独立思考。花一点时间想一下自己喜欢什么，梦想是什么，不要别人说想环游世界，你就说你的梦想是环游世界。</p><p>很多人说现实束缚了自己，其实在这个世界上，我们一直都可以有很多选择，生活的决定权也—直都在自己手上，只是我们缺乏行动力而已。</p><p>如果你觉得安于现状是你想要的，那选择安于现状就会让你幸福和满足;如果你不甘平庸，选择一条改变、进取和奋斗的道路，在这个追求的过程中，你也一样会感到快乐。所谓的成功，即是按照自己想要的生活方式生活。最糟糕的状态，莫过于当你想要选择一条不甘平庸、改变、进取和奋斗的道路时，却以一种安于现状的方式生活，最后抱怨自己没有得到想要的人生。</p><p>因为喜欢，你不是在苦苦坚持，也因为喜欢，你愿意投入时间、精力，长久以往，获得成功就是自然而然的事情。</p>'),(112,'2023-03-08 10:33:51','又是一年毕业季','又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。','upload/news_picture2.jpg','<p>又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。</p><p>过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。一直都是晚会的忠实参与者，无论是台前还是幕后，忽然间，角色转变，那种感觉确实难以用语言表达。</p><p>	过去的三年，总是默默地期盼着这个好雨时节，因为这时候，会有灿烂的阳光，会有满目的百花争艳，会有香甜的冰激凌，这是个毕业的季节，当时不经世事的我们会殷切地期待学校那一大堆的活动，期待穿上绚丽的演出服或者礼仪服，站在大礼堂镁光灯下尽情挥洒我们的澎拜的激情。</p><p>百感交集，隔岸观火与身临其境的感觉竟是如此不同。从来没想过一场晚会送走的是我们自己的时候会是怎样的感情，毕业就真的意味着结束吗?倔强的我们不愿意承认，谢谢学弟学妹们慷慨的将这次的主题定为“我们在这里”。我知道，这可能是他们对我们这些过来人的尊敬和施舍。</p><p>没有为这场晚会排练、奔波，没有为班级、学生会、文学院出点力，还真有点不习惯，百般无奈中，用“工作忙”个万能的借口来搪塞自己，欺骗别人。其实自己心里明白，那只是在逃避，只是不愿面对繁华落幕后的萧条和落寞。大四了，大家各奔东西，想凑齐班上的人真的是难上加难，敏燕从越南回来，刚落地就匆匆回了学校，那么恋家的人也启程回来了，睿睿学姐也是从家赶来跟我们团圆。大家—如既往的寒暄、打趣、调侃对方，似乎一切又回到了当初的单纯美好。</p><p>看着舞台上活泼可爱的学弟学妹们，如同一群机灵的小精灵，清澈的眼神，稚嫩的肢体，轻快地步伐，用他们那热情洋溢的舞姿渲染着在场的每一个人，我知道，我不应该羡慕嫉妒他们，不应该顾自怜惜逝去的青春，不应该感叹夕阳无限好，曾经，我们也拥有过，曾经，我们也年轻过，曾经，我们也灿烂过。我深深地告诉自己，人生的每个阶段都是美的，年轻有年轻的活力，成熟也有成熟的魅力。多—份稳重、淡然、优雅，也是漫漫时光掠影遗留下的.珍贵赏赐。</p>'),(113,'2023-03-08 10:33:51','挫折路上，坚持常在心间','回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。','upload/news_picture3.jpg','<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>'),(114,'2023-03-08 10:33:51','挫折是另一个生命的开端','当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。','upload/news_picture4.jpg','<p>当遇到挫折或失败，你是看见失败还是看见机会?</p><p>挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。</p><p>人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。</p><p>大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。</p><p>	“塞翁失马，焉知非福。”人生的道路，并不是每一步都迈向成功，这就是追求的意义。我们还要认识到一点，挫折作为一种情绪状态和一种个人体验，各人的耐受性是大不相同的，有的人经历了一次次挫折，就能够坚忍不拔，百折不挠;有的人稍遇挫折便意志消沉，一蹶不振。所以，挫折感是一种主观感受，因为人的目的和需要不同，成功标准不同，所以同一种活动对于不同的人可能会造成不同的挫折感受。</p><p>凡事皆以平常心来看待，对于生命顺逆不要太执著。能够“破我执”是很高层的人生境界。</p><p>人事的艰难就是一种考验。就像—支剑要有磨刀来磨，剑才会利:一块璞玉要有粗石来磨，才会发出耀眼的光芒。我们能够做到的，只是如何减少、避免那些由于自身的原因所造成的挫折，而在遇到痛苦和挫折之后，则力求化解痛苦，争取幸福。我们要知道，痛苦和挫折是双重性的，它既是我们人生中难以完全避免的，也是我们在争取成功时，不可缺少的一种动力。因为我认为，推动我们奋斗的力量，不仅仅是对成功的渴望，还有为摆脱痛苦和挫折而进行的奋斗。</p>'),(115,'2023-03-08 10:33:51','你要去相信，没有到不了的明天','有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。','upload/news_picture5.jpg','<p>有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。</p><p>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。</p><p>	不管你现在是在图书馆里背着怎么也看不进去的英语单词，还是你现在迷茫地看不清未来的方向不知道要往哪走。</p><p>不管你现在是在努力着去实现梦想却没能拉近与梦想的距离，还是你已经慢慢地找不到自己的梦想了。</p><p>你都要去相信，没有到不了的明天。</p><p>	有的时候你的梦想太大，别人说你的梦想根本不可能实现;有的时候你的梦想又太小，又有人说你胸无大志;有的时候你对死党说着将来要去环游世界的梦想，却换来他的不屑一顾，于是你再也不提自己的梦想;有的时候你突然说起将来要开个小店的愿望，却发现你讲述的那个人，并没有听到你在说什么。</p><p>不过又能怎么样呢，未来始终是自己的，梦想始终是自己的，没有人会来帮你实现它。</p><p>也许很多时候我们只是需要朋友的一句鼓励，一句安慰，却也得不到。但是相信我，世界上还有很多人，只是想要和你说说话。</p><p>因为我们都一样。一样的被人说成固执，一样的在追逐他们眼里根本不在意的东西。</p><p>所以，又有什么关系呢，别人始终不是你、不能懂你的心情，你又何必多去解释呢。这个世界会来阻止你，困难也会接踵而至，其实真正关键的只有自己，有没有那个倔强。</p><p>这个世界上没有不带伤的人，真正能治愈自己的，只有自己。</p>'),(116,'2023-03-08 10:33:51','离开是一种痛苦，是一种勇气，但同样也是一个考验，是一个新的开端','无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。','upload/news_picture6.jpg','<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>'),(117,'2023-03-08 10:33:51','Leave未必是一种痛苦','无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。','upload/news_picture7.jpg','<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>'),(118,'2023-03-08 10:33:51','坚持才会成功','回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。','upload/news_picture8.jpg','<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>');

/*Table structure for table `putongguanliyuan` */

DROP TABLE IF EXISTS `putongguanliyuan`;

CREATE TABLE `putongguanliyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `guanlizhanghao` varchar(200) NOT NULL COMMENT '管理账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `guanlixingming` varchar(200) NOT NULL COMMENT '管理姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) NOT NULL COMMENT '年龄',
  `lianxidianhua` varchar(200) NOT NULL COMMENT '联系电话',
  `touxiang` longtext COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `guanlizhanghao` (`guanlizhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='普通管理员';

/*Data for the table `putongguanliyuan` */

insert  into `putongguanliyuan`(`id`,`addtime`,`guanlizhanghao`,`mima`,`guanlixingming`,`xingbie`,`nianling`,`lianxidianhua`,`touxiang`) values (21,'2023-03-08 10:33:51','管理账号1','123456','管理姓名1','男','年龄1','13823888881','upload/putongguanliyuan_touxiang1.jpg'),(22,'2023-03-08 10:33:51','管理账号2','123456','管理姓名2','男','年龄2','13823888882','upload/putongguanliyuan_touxiang2.jpg'),(23,'2023-03-08 10:33:51','管理账号3','123456','管理姓名3','男','年龄3','13823888883','upload/putongguanliyuan_touxiang3.jpg'),(24,'2023-03-08 10:33:51','管理账号4','123456','管理姓名4','男','年龄4','13823888884','upload/putongguanliyuan_touxiang4.jpg'),(25,'2023-03-08 10:33:51','管理账号5','123456','管理姓名5','男','年龄5','13823888885','upload/putongguanliyuan_touxiang5.jpg'),(26,'2023-03-08 10:33:51','管理账号6','123456','管理姓名6','男','年龄6','13823888886','upload/putongguanliyuan_touxiang6.jpg'),(27,'2023-03-08 10:33:51','管理账号7','123456','管理姓名7','男','年龄7','13823888887','upload/putongguanliyuan_touxiang7.jpg'),(28,'2023-03-08 10:33:51','管理账号8','123456','管理姓名8','男','年龄8','13823888888','upload/putongguanliyuan_touxiang8.jpg');

/*Table structure for table `qicheleibie` */

DROP TABLE IF EXISTS `qicheleibie`;

CREATE TABLE `qicheleibie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qicheleibie` varchar(200) DEFAULT NULL COMMENT '汽车类别',
  PRIMARY KEY (`id`),
  UNIQUE KEY `qicheleibie` (`qicheleibie`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='汽车类别';

/*Data for the table `qicheleibie` */

insert  into `qicheleibie`(`id`,`addtime`,`qicheleibie`) values (31,'2023-03-08 10:33:51','汽车类别1'),(32,'2023-03-08 10:33:51','汽车类别2'),(33,'2023-03-08 10:33:51','汽车类别3'),(34,'2023-03-08 10:33:51','汽车类别4'),(35,'2023-03-08 10:33:51','汽车类别5'),(36,'2023-03-08 10:33:51','汽车类别6'),(37,'2023-03-08 10:33:51','汽车类别7'),(38,'2023-03-08 10:33:51','汽车类别8');

/*Table structure for table `qichexinxi` */

DROP TABLE IF EXISTS `qichexinxi`;

CREATE TABLE `qichexinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chepaihao` varchar(200) NOT NULL COMMENT '车牌号',
  `cheliangxinghao` varchar(200) DEFAULT NULL COMMENT '车辆型号',
  `qicheleibie` varchar(200) DEFAULT NULL COMMENT '汽车类别',
  `cheliangpinpai` varchar(200) NOT NULL COMMENT '车辆品牌',
  `jiage` float DEFAULT NULL COMMENT '价格',
  `yanse` varchar(200) DEFAULT NULL COMMENT '颜色',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  `huandangfangshi` varchar(200) DEFAULT NULL COMMENT '换挡方式',
  `cheliangzhaopian` longtext COMMENT '车辆照片',
  `zuoweishu` int(11) DEFAULT NULL COMMENT '座位数',
  `qichepailiang` varchar(200) DEFAULT NULL COMMENT '汽车排量',
  `qichejiage` float DEFAULT NULL COMMENT '汽车价格',
  `chuchangnianfen` varchar(200) DEFAULT NULL COMMENT '出厂年份',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `qichejianjie` longtext COMMENT '汽车简介',
  `guanlizhanghao` varchar(200) DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(200) DEFAULT NULL COMMENT '管理姓名',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `chepaihao` (`chepaihao`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='汽车信息';

/*Data for the table `qichexinxi` */

insert  into `qichexinxi`(`id`,`addtime`,`chepaihao`,`cheliangxinghao`,`qicheleibie`,`cheliangpinpai`,`jiage`,`yanse`,`zhuangtai`,`huandangfangshi`,`cheliangzhaopian`,`zuoweishu`,`qichepailiang`,`qichejiage`,`chuchangnianfen`,`dengjiriqi`,`qichejianjie`,`guanlizhanghao`,`guanlixingming`,`clicktime`,`clicknum`) values (41,'2023-03-08 10:33:51','车牌号1','车辆型号1','汽车类别1','车辆品牌1',1,'颜色1','已出租','手动挡','upload/qichexinxi_cheliangzhaopian1.jpg,upload/qichexinxi_cheliangzhaopian2.jpg,upload/qichexinxi_cheliangzhaopian3.jpg',1,'汽车排量1',1,'出厂年份1','2023-03-08','<p>汽车简介1</p>','管理账号1','管理姓名1','2024-02-29 18:05:26',10),(42,'2023-03-08 10:33:51','车牌号2','车辆型号2','汽车类别2','车辆品牌2',2,'颜色2','已出租','手动挡','upload/qichexinxi_cheliangzhaopian2.jpg,upload/qichexinxi_cheliangzhaopian3.jpg,upload/qichexinxi_cheliangzhaopian4.jpg',2,'汽车排量2',2,'出厂年份2','2023-03-08','汽车简介2','管理账号2','管理姓名2','2023-03-08 18:33:51',2),(43,'2023-03-08 10:33:51','车牌号3','车辆型号3','汽车类别3','车辆品牌3',3,'颜色3','已出租','手动挡','upload/qichexinxi_cheliangzhaopian3.jpg,upload/qichexinxi_cheliangzhaopian4.jpg,upload/qichexinxi_cheliangzhaopian5.jpg',3,'汽车排量3',3,'出厂年份3','2023-03-08','汽车简介3','管理账号3','管理姓名3','2023-03-08 18:33:51',3),(44,'2023-03-08 10:33:51','车牌号4','车辆型号4','汽车类别4','车辆品牌4',4,'颜色4','已出租','手动挡','upload/qichexinxi_cheliangzhaopian4.jpg,upload/qichexinxi_cheliangzhaopian5.jpg,upload/qichexinxi_cheliangzhaopian6.jpg',4,'汽车排量4',4,'出厂年份4','2023-03-08','汽车简介4','管理账号4','管理姓名4','2023-03-08 18:33:51',4),(45,'2023-03-08 10:33:51','车牌号5','车辆型号5','汽车类别5','车辆品牌5',5,'颜色5','已出租','手动挡','upload/qichexinxi_cheliangzhaopian5.jpg,upload/qichexinxi_cheliangzhaopian6.jpg,upload/qichexinxi_cheliangzhaopian7.jpg',5,'汽车排量5',5,'出厂年份5','2023-03-08','汽车简介5','管理账号5','管理姓名5','2023-03-08 18:33:51',5),(46,'2023-03-08 10:33:51','车牌号6','车辆型号6','汽车类别6','车辆品牌6',6,'颜色6','已出租','手动挡','upload/qichexinxi_cheliangzhaopian6.jpg,upload/qichexinxi_cheliangzhaopian7.jpg,upload/qichexinxi_cheliangzhaopian8.jpg',6,'汽车排量6',6,'出厂年份6','2023-03-08','汽车简介6','管理账号6','管理姓名6','2023-03-08 18:33:51',6),(47,'2023-03-08 10:33:51','车牌号7','车辆型号7','汽车类别7','车辆品牌7',7,'颜色7','已出租','手动挡','upload/qichexinxi_cheliangzhaopian7.jpg,upload/qichexinxi_cheliangzhaopian8.jpg,upload/qichexinxi_cheliangzhaopian9.jpg',7,'汽车排量7',7,'出厂年份7','2023-03-08','汽车简介7','管理账号7','管理姓名7','2024-02-29 17:59:28',9),(48,'2023-03-08 10:33:51','车牌号8','车辆型号8','汽车类别8','车辆品牌8',8,'颜色8','已出租','手动挡','upload/qichexinxi_cheliangzhaopian8.jpg,upload/qichexinxi_cheliangzhaopian9.jpg,upload/qichexinxi_cheliangzhaopian10.jpg',8,'汽车排量8',8,'出厂年份8','2023-03-08','汽车简介8','管理账号8','管理姓名8','2023-03-08 18:33:51',8);

/*Table structure for table `qichezixun` */

DROP TABLE IF EXISTS `qichezixun`;

CREATE TABLE `qichezixun` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `jianjie` longtext COMMENT '简介',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `neirong` longtext COMMENT '内容',
  `faburen` varchar(200) NOT NULL COMMENT '发布人',
  `fengmian` longtext COMMENT '封面',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='汽车资讯';

/*Data for the table `qichezixun` */

insert  into `qichezixun`(`id`,`addtime`,`biaoti`,`jianjie`,`fabushijian`,`neirong`,`faburen`,`fengmian`,`clicktime`,`clicknum`,`userid`) values (81,'2023-03-08 10:33:51','标题1','简介1','2023-03-08','内容1','发布人1','upload/qichezixun_fengmian1.jpg,upload/qichezixun_fengmian2.jpg,upload/qichezixun_fengmian3.jpg','2023-03-08 18:33:51',1,1),(82,'2023-03-08 10:33:51','标题2','简介2','2023-03-08','内容2','发布人2','upload/qichezixun_fengmian2.jpg,upload/qichezixun_fengmian3.jpg,upload/qichezixun_fengmian4.jpg','2024-02-29 17:45:49',3,2),(83,'2023-03-08 10:33:51','标题3','简介3','2023-03-08','内容3','发布人3','upload/qichezixun_fengmian3.jpg,upload/qichezixun_fengmian4.jpg,upload/qichezixun_fengmian5.jpg','2023-03-08 18:33:51',3,3),(84,'2023-03-08 10:33:51','标题4','简介4','2023-03-08','内容4','发布人4','upload/qichezixun_fengmian4.jpg,upload/qichezixun_fengmian5.jpg,upload/qichezixun_fengmian6.jpg','2023-03-08 18:33:51',4,4),(85,'2023-03-08 10:33:51','标题5','简介5','2023-03-08','内容5','发布人5','upload/qichezixun_fengmian5.jpg,upload/qichezixun_fengmian6.jpg,upload/qichezixun_fengmian7.jpg','2023-03-08 18:33:51',5,5),(86,'2023-03-08 10:33:51','标题6','简介6','2023-03-08','内容6','发布人6','upload/qichezixun_fengmian6.jpg,upload/qichezixun_fengmian7.jpg,upload/qichezixun_fengmian8.jpg','2023-03-08 18:33:51',6,6),(87,'2023-03-08 10:33:51','标题7','简介7','2023-03-08','内容7','发布人7','upload/qichezixun_fengmian7.jpg,upload/qichezixun_fengmian8.jpg,upload/qichezixun_fengmian9.jpg','2023-03-08 18:33:51',7,7),(88,'2023-03-08 10:33:51','标题8','简介8','2023-03-08','内容8','发布人8','upload/qichezixun_fengmian8.jpg,upload/qichezixun_fengmian9.jpg,upload/qichezixun_fengmian10.jpg','2023-03-08 18:33:51',8,8);

/*Table structure for table `quxiaodingdan` */

DROP TABLE IF EXISTS `quxiaodingdan`;

CREATE TABLE `quxiaodingdan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangpinpai` varchar(200) DEFAULT NULL COMMENT '车辆品牌',
  `qicheleibie` varchar(200) DEFAULT NULL COMMENT '汽车类别',
  `jiage` float DEFAULT NULL COMMENT '价格',
  `zuqi` int(11) DEFAULT NULL COMMENT '租期',
  `zongjia` float DEFAULT NULL COMMENT '总价',
  `quxiaoriqi` date DEFAULT NULL COMMENT '取消日期',
  `quxiaoyuanyin` longtext COMMENT '取消原因',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `guanlizhanghao` varchar(200) DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(200) DEFAULT NULL COMMENT '管理姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='取消订单';

/*Data for the table `quxiaodingdan` */

insert  into `quxiaodingdan`(`id`,`addtime`,`dingdanbianhao`,`chepaihao`,`cheliangpinpai`,`qicheleibie`,`jiage`,`zuqi`,`zongjia`,`quxiaoriqi`,`quxiaoyuanyin`,`zhanghao`,`xingming`,`shouji`,`shenfenzheng`,`guanlizhanghao`,`guanlixingming`,`crossuserid`,`crossrefid`,`sfsh`,`shhf`,`ispay`) values (61,'2023-03-08 10:33:51','订单编号1','车牌号1','车辆品牌1','汽车类别1',1,1,1,'2023-03-08','取消原因1','账号1','姓名1','13823888881','身份证1','管理账号1','管理姓名1',1,1,'是','','未支付'),(62,'2023-03-08 10:33:51','订单编号2','车牌号2','车辆品牌2','汽车类别2',2,2,2,'2023-03-08','取消原因2','账号2','姓名2','13823888882','身份证2','管理账号2','管理姓名2',2,2,'是','','未支付'),(63,'2023-03-08 10:33:51','订单编号3','车牌号3','车辆品牌3','汽车类别3',3,3,3,'2023-03-08','取消原因3','账号3','姓名3','13823888883','身份证3','管理账号3','管理姓名3',3,3,'是','','未支付'),(64,'2023-03-08 10:33:51','订单编号4','车牌号4','车辆品牌4','汽车类别4',4,4,4,'2023-03-08','取消原因4','账号4','姓名4','13823888884','身份证4','管理账号4','管理姓名4',4,4,'是','','未支付'),(65,'2023-03-08 10:33:51','订单编号5','车牌号5','车辆品牌5','汽车类别5',5,5,5,'2023-03-08','取消原因5','账号5','姓名5','13823888885','身份证5','管理账号5','管理姓名5',5,5,'是','','未支付'),(66,'2023-03-08 10:33:51','订单编号6','车牌号6','车辆品牌6','汽车类别6',6,6,6,'2023-03-08','取消原因6','账号6','姓名6','13823888886','身份证6','管理账号6','管理姓名6',6,6,'是','','未支付'),(67,'2023-03-08 10:33:51','订单编号7','车牌号7','车辆品牌7','汽车类别7',7,7,7,'2023-03-08','取消原因7','账号7','姓名7','13823888887','身份证7','管理账号7','管理姓名7',7,7,'是','','未支付'),(68,'2023-03-08 10:33:51','订单编号8','车牌号8','车辆品牌8','汽车类别8',8,8,8,'2023-03-08','取消原因8','账号8','姓名8','13823888888','身份证8','管理账号8','管理姓名8',8,8,'是','','未支付');

/*Table structure for table `storeup` */

DROP TABLE IF EXISTS `storeup`;

CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

/*Data for the table `storeup` */

/*Table structure for table `systemintro` */

DROP TABLE IF EXISTS `systemintro`;

CREATE TABLE `systemintro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '副标题',
  `content` longtext NOT NULL COMMENT '内容',
  `picture1` longtext COMMENT '图片1',
  `picture2` longtext COMMENT '图片2',
  `picture3` longtext COMMENT '图片3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关于我们';

/*Data for the table `systemintro` */

insert  into `systemintro`(`id`,`addtime`,`title`,`subtitle`,`content`,`picture1`,`picture2`,`picture3`) values (1,'2023-03-08 10:33:51','系统简介','SYSTEM INTRODUCTION','当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。','upload/systemintro_picture1.jpg','upload/systemintro_picture2.jpg','upload/systemintro_picture3.jpg');

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values (1,1,'java1234','users','管理员','93txoesuakizr9femoo3iy8yjj4n5tth','2024-02-29 15:52:16','2024-02-29 19:03:44'),(2,11,'账号1','yonghu','用户','di6v3z5z7qb9w5bwppplyndbf72x7jy1','2024-02-29 17:54:40','2024-02-29 19:06:31'),(3,21,'管理账号1','putongguanliyuan','普通管理员','1dbtjim92xf0t7t5tjsl90i3pa949x42','2024-02-29 18:02:03','2024-02-29 19:05:54');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`,`addtime`) values (1,'java1234','123456','管理员','2023-03-08 10:33:51');

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shenfenzheng` varchar(200) NOT NULL COMMENT '身份证',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `touxiang` longtext COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `yonghu` */

insert  into `yonghu`(`id`,`addtime`,`zhanghao`,`mima`,`xingming`,`nianling`,`xingbie`,`shenfenzheng`,`shouji`,`touxiang`) values (11,'2023-03-08 10:33:50','账号1','123456','姓名1',1,'男','440300199101010001','13823888881','upload/yonghu_touxiang1.jpg'),(12,'2023-03-08 10:33:50','账号2','123456','姓名2',2,'男','440300199202020002','13823888882','upload/yonghu_touxiang2.jpg'),(13,'2023-03-08 10:33:50','账号3','123456','姓名3',3,'男','440300199303030003','13823888883','upload/yonghu_touxiang3.jpg'),(14,'2023-03-08 10:33:50','账号4','123456','姓名4',4,'男','440300199404040004','13823888884','upload/yonghu_touxiang4.jpg'),(15,'2023-03-08 10:33:50','账号5','123456','姓名5',5,'男','440300199505050005','13823888885','upload/yonghu_touxiang5.jpg'),(16,'2023-03-08 10:33:50','账号6','123456','姓名6',6,'男','440300199606060006','13823888886','upload/yonghu_touxiang6.jpg'),(17,'2023-03-08 10:33:50','账号7','123456','姓名7',7,'男','440300199707070007','13823888887','upload/yonghu_touxiang7.jpg'),(18,'2023-03-08 10:33:51','账号8','123456','姓名8',8,'男','440300199808080008','13823888888','upload/yonghu_touxiang8.jpg');

/*Table structure for table `zuchedingdan` */

DROP TABLE IF EXISTS `zuchedingdan`;

CREATE TABLE `zuchedingdan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangpinpai` varchar(200) DEFAULT NULL COMMENT '车辆品牌',
  `qicheleibie` varchar(200) DEFAULT NULL COMMENT '汽车类别',
  `jiage` float DEFAULT NULL COMMENT '价格',
  `zuqi` int(11) NOT NULL COMMENT '租期',
  `zongjia` float DEFAULT NULL COMMENT '总价',
  `chuzuriqi` date DEFAULT NULL COMMENT '出租日期',
  `beizhu` longtext COMMENT '备注',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `guanlizhanghao` varchar(200) DEFAULT NULL COMMENT '管理账号',
  `guanlixingming` varchar(200) DEFAULT NULL COMMENT '管理姓名',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1709201124698 DEFAULT CHARSET=utf8 COMMENT='租车订单';

/*Data for the table `zuchedingdan` */

insert  into `zuchedingdan`(`id`,`addtime`,`dingdanbianhao`,`chepaihao`,`cheliangpinpai`,`qicheleibie`,`jiage`,`zuqi`,`zongjia`,`chuzuriqi`,`beizhu`,`zhanghao`,`xingming`,`shouji`,`shenfenzheng`,`guanlizhanghao`,`guanlixingming`,`sfsh`,`shhf`,`ispay`) values (51,'2023-03-08 10:33:51','1111111111','车牌号1','车辆品牌1','汽车类别1',1,1,1,'2023-03-08','备注1','账号1','姓名1','13823888881','身份证1','管理账号1','管理姓名1','是','','未支付'),(52,'2023-03-08 10:33:51','2222222222','车牌号2','车辆品牌2','汽车类别2',2,2,2,'2023-03-08','备注2','账号2','姓名2','13823888882','身份证2','管理账号2','管理姓名2','是','','未支付'),(53,'2023-03-08 10:33:51','3333333333','车牌号3','车辆品牌3','汽车类别3',3,3,3,'2023-03-08','备注3','账号3','姓名3','13823888883','身份证3','管理账号3','管理姓名3','是','','未支付'),(54,'2023-03-08 10:33:51','4444444444','车牌号4','车辆品牌4','汽车类别4',4,4,4,'2023-03-08','备注4','账号4','姓名4','13823888884','身份证4','管理账号4','管理姓名4','是','','未支付'),(55,'2023-03-08 10:33:51','5555555555','车牌号5','车辆品牌5','汽车类别5',5,5,5,'2023-03-08','备注5','账号5','姓名5','13823888885','身份证5','管理账号5','管理姓名5','是','','未支付'),(56,'2023-03-08 10:33:51','6666666666','车牌号6','车辆品牌6','汽车类别6',6,6,6,'2023-03-08','备注6','账号6','姓名6','13823888886','身份证6','管理账号6','管理姓名6','是','','未支付'),(57,'2023-03-08 10:33:51','7777777777','车牌号7','车辆品牌7','汽车类别7',7,7,7,'2023-03-08','备注7','账号7','姓名7','13823888887','身份证7','管理账号7','管理姓名7','是','','未支付'),(58,'2023-03-08 10:33:51','8888888888','车牌号8','车辆品牌8','汽车类别8',8,8,8,'2023-03-08','备注8','账号8','姓名8','13823888888','身份证8','管理账号8','管理姓名8','是','','未支付'),(1709201124697,'2024-02-29 18:05:24','1709201101690','车牌号1','车辆品牌1','汽车类别1',1,20,20,'2024-02-29','<p>11</p>','账号1','姓名1','13823888881','440300199101010001','管理账号1','管理姓名1','是',NULL,'已支付');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
