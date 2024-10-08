# 图像识别与价格监控系统

**项目描述**：用户拍照，项目任务为识别图像中烟价标签，种类。将识别结果上传数据库，对价格异常，标签缺失的进行警示。需要将店铺已有品牌烟草的近期价格变动进行归纳线性显示。

## 项目特点

- **图像识别**：利用深度学习模型自动识别烟草价格标签。
- **数据库监控**：设计本地数据库，监控并分析价格异常。
- **微服务架构**：采用微服务架构，实现烟草信息的查询与分析。
- **前端集成**：微信小程序前端与Java后端的无缝集成。

## 技术栈

- 后端：Java, Spring Boot，MybatisPlus，分布式事务
- 数据库：MySQL, 设计了本地数据库
- 深度学习模型：调用现有深度学习模型接口
- 前端：微信小程序

## 系统设计

1. **数据库设计**：考虑到企业数据库的规模和操作限制，本项目设计了本地数据库以存储和分析数据。

2. **深度模型接口调用**：项目调用现有的深度学习模型接口，用于从图像中提取并分析烟草价格标签。

3. **微服务使用**：通过微服务架构，项目能够获取烟草局的烟草信息和人员信息，并进行深入分析。

4. **前端与后端接口文档**：设计了详细的接口文档，确保微信小程序前端与Java后端的有效连接和数据交互。

## 安装与部署

1. **环境准备**：确保系统已安装Java环境和MySQL数据库。
2. **数据库配置**：根据项目提供的数据库设计文档配置本地数据库。
3. **后端部署**：运行Spring Boot应用程序，启动后端服务。
4. **Python识别端口**：启动百度OCR识别服务。
5. **前端部署**：部署微信小程序前端，连接后端API。

## 使用说明
- 由于某些问题不能将小程序页面显示，并且已将对数据库的操作全部删除，前端也不是本人写的。
- 用户通过微信小程序拍照上传烟草图片。
- 系统自动识别烟草价格标签和种类。
- 识别结果将存储在本地数据库，并进行价格异常分析。
- 用户可查询烟草价格变化情况。

## 项目架构
- **项目结构图**：
![image](https://github.com/SunLi2/YanCao/blob/master/structure.png)

## 许可证

本项目采用 [MIT许可证](LICENSE)。

## 联系方式

- 电子邮件：不告诉你
