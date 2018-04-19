<p align="center">
  <a href="https://github.com/Seanforfun/SeanForFunBlog">
    <img src="https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/logo.png"></img>
  </a>
</p>

# SeanForFunBlog

Overview
======================================
<p>This is the source code of project SeanforfunBlog. This is a java web based technology blog.</p>
<p>I always write some conclusion files and append them into my different repositories. However, it is difficult when I was going to read them. By the way, I want to design this blog completely by myself and test the knowledge I've learnt from Sept, 2017.</p>
<p>I named this blog as Seanforfun which is my nickname of Github and I hope this blog will publish soon :)</p>

Technical selections
======================================
* JDK: 1.8
* Front: BootStrap, JQuery, HTML5, thymeleaf
* Backend: SpringBoot, Spring, SpringMVC and MyBatis.
* Spring Cache, may use Redis
* DataBase: MySQL
* Server: Tomcat 8.5.29
* Editor: Markdown
* Log: Commons Logging
* Url style: Restful
* Connection pool: Druid -from Alibaba, China

Interfaces demos
======================================
index.html:
<p align="center">
  <a href="tbd">
    <img src="https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/index.png"></img>
  </a>
</p>

DataBase design
======================================
* <a href="https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/User.java">User table</a>
* <a href="https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/Category.java">Category table</a>
Controller design
======================================
* <a href="https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/java/ca/seanforfun/blog/controller/IndexController.java">IndexController</a>
1. Get blog owner's information according to access url.
2. Get user avatar and carousel pictures from third party database.
3. Get categories and sub-categories from database.
4. Get 10 new blogs from database.
5. Blog access statistic update.


