/*
Navicat SQL Server Data Transfer

Source Server         : SQLServer_238
Source Server Version : 90000
Source Host           : 192.168.1.238:1433
Source Database       : train
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 90000
File Encoding         : 65001

Date: 2016-05-13 11:35:34
*/


-- ----------------------------
-- Table structure for dtproperties
-- ----------------------------
DROP TABLE [dbo].[dtproperties]
GO
CREATE TABLE [dbo].[dtproperties] (
[id] int NOT NULL IDENTITY(1,1) ,
[objectid] int NULL ,
[property] varchar(64) NOT NULL ,
[value] varchar(255) NULL ,
[uvalue] nvarchar(255) NULL ,
[lvalue] image NULL ,
[version] int NOT NULL DEFAULT ((0)) 
)


GO

-- ----------------------------
-- Records of dtproperties
-- ----------------------------
SET IDENTITY_INSERT [dbo].[dtproperties] ON
GO
SET IDENTITY_INSERT [dbo].[dtproperties] OFF
GO

-- ----------------------------
-- Table structure for TrainInfo
-- ----------------------------
DROP TABLE [dbo].[TrainInfo]
GO
CREATE TABLE [dbo].[TrainInfo] (
[checi] char(10) NOT NULL ,
[qidian] nvarchar(8) NOT NULL ,
[zhongdian] nvarchar(8) NOT NULL ,
[shijian] datetime NOT NULL ,
[piaojia] int NULL ,
[shengyu] int NULL 
)


GO

-- ----------------------------
-- Records of TrainInfo
-- ----------------------------
INSERT INTO [dbo].[TrainInfo] ([checi], [qidian], [zhongdian], [shijian], [piaojia], [shengyu]) VALUES (N'K234      ', N'上海', N'郑州', N'2016-11-12 00:00:00.000', N'110', N'80')
GO
GO

-- ----------------------------
-- Table structure for User_
-- ----------------------------
DROP TABLE [dbo].[User_]
GO
CREATE TABLE [dbo].[User_] (
[userName] varchar(16) NOT NULL ,
[password] varchar(14) NOT NULL ,
[repassword] varchar(14) NOT NULL ,
[realName] nchar(10) NOT NULL ,
[gender] nchar(4) NOT NULL ,
[tel] varchar(15) NOT NULL ,
[email] varchar(50) NULL ,
[admin] int NOT NULL 
)


GO

-- ----------------------------
-- Records of User_
-- ----------------------------
INSERT INTO [dbo].[User_] ([userName], [password], [repassword], [realName], [gender], [tel], [email], [admin]) VALUES (N'123456789', N'123456789', N'123456789', N'郭凯天       ', N'男   ', N'12312345678', N'', N'0')
GO
GO
INSERT INTO [dbo].[User_] ([userName], [password], [repassword], [realName], [gender], [tel], [email], [admin]) VALUES (N'987654321', N'987654321', N'987654321', N'薛佳楠       ', N'男   ', N'15971407776', N'', N'0')
GO
GO
INSERT INTO [dbo].[User_] ([userName], [password], [repassword], [realName], [gender], [tel], [email], [admin]) VALUES (N'system', N'admin', N'123456789', N'邹家伟       ', N'男   ', N'15974107410', null, N'1')
GO
GO

-- ----------------------------
-- Indexes structure for table dtproperties
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table dtproperties
-- ----------------------------
ALTER TABLE [dbo].[dtproperties] ADD PRIMARY KEY ([id], [property])
GO

-- ----------------------------
-- Indexes structure for table TrainInfo
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table TrainInfo
-- ----------------------------
ALTER TABLE [dbo].[TrainInfo] ADD PRIMARY KEY ([checi], [qidian], [zhongdian], [shijian])
GO

-- ----------------------------
-- Indexes structure for table User_
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table User_
-- ----------------------------
ALTER TABLE [dbo].[User_] ADD PRIMARY KEY ([userName])
GO
