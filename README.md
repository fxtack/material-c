# material-c
Material-c is the first completely project I created with spring boot. And it also is the works for computer application ability competition

This project is very rough because I do it while learning and lack of overall design. But this is a very successful project for me. It can not only be successfully deployed and run on the cloud server, but also I still use it as my private cloud disk.

I integrated a lot of my enthusiasm for technology into it.
This is my whole stack of works. The front end of the project is very chaotic and completely unmaintainable. Moreover, the UI is modified with a randomly found template. The back end also has many disadvantages. I am trying to improve these problems and launch a new version to revive this project.

Although this project is very bad, but I put it on GitHub to encourage myself and remind myself to avoid these problems in the future development of this project.

Thank you for reading this and wish you a good day. 😃

--------------

![U{NA5HVN8_BR Y~BK8UW@ 2](https://user-images.githubusercontent.com/59989422/129043028-c760007b-a0e1-4a37-9b5f-e2ca60ba6c2a.png)

-----------------

## ⚙️ How to deploy material-c

#### 1. Install java runtime environment.

* You can use jre or jdk, version must be 8 or above.

#### 2. Prepare MySQL service

* Material-c requires MySQL service, and version must be 8.0.20 or above.
* Material-c default artifact use MySQL service on localhost:3306 and username is "root" password "1244875112", if you are going to running it you need to create root user and set password.
* Execute the SQL script in project `sql/material-c`.

### 3. Modify configuration

* If you're not going to use the default artifact, you pack .jar package by youself. You need the modify the material-c configuration file `application.yaml`.

* The `port` field defines the port on which material listens.  The `url` field defines the MySQL service provider url, `username` and `password` defines MySQL connection's user name and password.

  ```yaml
   ...
  server:
    port: 8005
    
   ...
    
  spring: 
    datasource:
      type: com.alibaba.druid.pool.DruidDataSource
      url: jdbc:mysql://localhost:3306/material_c?useUnicode=true&amp&characterEncoding=UTF-8&amp&userSSL=false&amp&serverTimezone=GMT%2B8
      username: root
      password: 1244875112
      driver-class-name: com.mysql.cj.jdbc.Driver
      
   ...
  ```

#### 4. Run material-c service

* You can run default artifact in project.

  ```bash
  $ java -jar material-c.jar
  ```

* If you have made changes to the project, you need to compile, package and run it yourself.

## 📝 How to use material-c

* Material-c default login user name is "Achar" nad password is "123456".
* You can see the You can watch the project demo video: https://www.bilibili.com/video/BV1JN411X7QD