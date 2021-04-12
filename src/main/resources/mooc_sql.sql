/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.18 : Database - mooc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mooc` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mooc`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `c_id` varchar(100) NOT NULL COMMENT '课程id',
  `t_id` varchar(100) NOT NULL,
  `c_name` varchar(50) NOT NULL COMMENT '课程名字',
  `c_content` varchar(400) NOT NULL COMMENT '课程简介',
  `c_img` varchar(200) NOT NULL COMMENT '课程封面图片路径',
  `c_mail` varchar(100) NOT NULL COMMENT '课程邮箱',
  PRIMARY KEY (`c_id`),
  KEY `FK_2_T_ID` (`t_id`),
  CONSTRAINT `FK_2_T_ID` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`c_id`,`t_id`,`c_name`,`c_content`,`c_img`,`c_mail`) values ('aaa001','10101011','中国近代史','本节课是大一学生的必修课，主要内容如下：xxxxxxx','',''),('aaa002','10101012','数据结构基础','本节课是数据结构的入门课','',''),('aaa003','10101013','数据库课程设计','该课程是数据库技术的应用课，需要先学习数据库系统原理这门课','',''),('aaa004','10101013','数据库系统原理','xxxxxxxx','',''),('bbb001','10101014','地理学导论','本节课是针对非地质专业开设的。欢迎有兴趣的同学报名','','');

/*Table structure for table `exercise` */

DROP TABLE IF EXISTS `exercise`;

CREATE TABLE `exercise` (
  `e_id` varchar(100) NOT NULL,
  `p_id` varchar(100) NOT NULL,
  `e_path` varchar(300) NOT NULL,
  PRIMARY KEY (`e_id`),
  KEY `FK_E_P` (`p_id`),
  CONSTRAINT `FK_E_P` FOREIGN KEY (`p_id`) REFERENCES `part` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exercise` */

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `f_id` varchar(100) NOT NULL,
  `f_path` varchar(500) NOT NULL,
  `f_name` varchar(100) NOT NULL,
  `p_id` varchar(100) NOT NULL,
  PRIMARY KEY (`f_id`),
  KEY `FK_F_P` (`p_id`),
  CONSTRAINT `FK_F_P` FOREIGN KEY (`p_id`) REFERENCES `part` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `file` */

/*Table structure for table `mail` */

DROP TABLE IF EXISTS `mail`;

CREATE TABLE `mail` (
  `m_id` varchar(100) NOT NULL,
  `c_id` varchar(100) NOT NULL,
  `m_path` varchar(300) NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `FK_1_C_ID` (`c_id`),
  CONSTRAINT `FK_1_C_ID` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mail` */

/*Table structure for table `part` */

DROP TABLE IF EXISTS `part`;

CREATE TABLE `part` (
  `p_id` varchar(100) NOT NULL,
  `p_index` int(20) NOT NULL,
  `p_name` varchar(100) NOT NULL,
  `c_id` varchar(100) NOT NULL,
  PRIMARY KEY (`p_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `part_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `part` */

insert  into `part`(`p_id`,`p_index`,`p_name`,`c_id`) values ('aaa003_1',1,'课程介绍','aaa003'),('aaa003_2',2,'课题选择（组队完成）','aaa003'),('aaa003_3',3,'根据需求进行数据库建模','aaa003'),('aaa003_4',4,'使用spring框架搭建后端','aaa003'),('aaa003_5',5,'前端框架介绍','aaa003'),('aaa003_6',6,'利用spring MVC将前后端集成','aaa003'),('aaa003_7',7,'轻量级框架spring Boot介绍','aaa003'),('aaa003_8',8,'实战开发','aaa003'),('aaa004_1',1,'绪论','aaa004'),('aaa004_2',2,'关系模型和运算理论','aaa004'),('aaa004_3',3,'SQL语言','aaa004'),('aaa004_4',4,'关系数据库的规范化设计','aaa004'),('aaa004_5',5,'数据库设计','aaa004'),('aaa004_6',6,'系统实现技术','aaa004');

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `c_id` varchar(100) NOT NULL COMMENT '课程id',
  `s_id` varchar(100) NOT NULL COMMENT '学生id',
  `score` int(100) DEFAULT '-1' COMMENT '课程成绩(如果没有成绩就是-1)',
  PRIMARY KEY (`c_id`,`s_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc` */

insert  into `sc`(`c_id`,`s_id`,`score`) values ('aaa001','1189360',-1),('aaa001','2084172',-1),('aaa001','2154445',-1),('aaa001 ','2155400',-1),('aaa001','2187932',-1),('aaa002','2071284',-1),('aaa002','2123181',-1),('aaa002','2187932',-1),('aaa003','2058218',-1),('aaa003','2154445',-1),('aaa003','2155400',-1),('aaa004','2058218',-1),('aaa004','2084172',-1),('aaa004','2123181',-1),('aaa004','2155400',-1),('bbb001','2058218',-1),('bbb001','2080453',85),('bbb001','2123181',80),('bbb001','2155400',91),('bbb001','2187932',97);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `s_id` varchar(100) NOT NULL COMMENT '学生id',
  `s_name` varchar(100) NOT NULL COMMENT '真实姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `gender` varchar(10) NOT NULL COMMENT '性别',
  `phone` varchar(12) NOT NULL COMMENT '手机号',
  `head_img_path` varchar(200) DEFAULT NULL COMMENT '头像的文件路径',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`s_id`,`s_name`,`password`,`gender`,`phone`,`head_img_path`) values ('1189360','张明','123456','male','14539270706',NULL),('2058218','衡体罚','123456','female','15333061275',NULL),('2071284','召炬','123456','female','13902148091',NULL),('2080453','祝佼','123456','male','17228256712',NULL),('2084172','赵勾','123456','male','13410779145',NULL),('2123181','殳核','123456','female','14952699804',NULL),('2154445','周洌彝','123456','male','17805447300',NULL),('2155400','沙瞀','123456','male','15626487442',NULL),('2187932','璩导兴','123456','female','18594243680',NULL);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `t_id` varchar(100) NOT NULL,
  `t_name` varchar(100) NOT NULL COMMENT '真实姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `gender` varchar(10) NOT NULL COMMENT '性别',
  `phone` varchar(12) NOT NULL COMMENT '手机号',
  `head_img_path` varchar(200) DEFAULT NULL COMMENT '头像的文件路径',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`t_id`,`t_name`,`password`,`gender`,`phone`,`head_img_path`) values ('10101011','张恒','123456','male','16923230124',NULL),('10101012','黄永锋','123456','male','17423252354',NULL),('10101013','孙国豪','123456','male','19281341485',NULL),('10101014','裘燕明','123456','female','15221312385',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
