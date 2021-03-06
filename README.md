<p align="center">
  <a href="https://github.com/Seanforfun/SeanForFunBlog">
    <img src="https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/logo.png"></img>
  </a>
</p>

# SeanForFunBlog

Overview
======================================
This is the source code of project **SeanforfunBlog**. This is a java web based technology blog.

I always write some conclusion files and append them into my different repositories. However, it is difficult when I was going to read them. By the way, I want to design this blog completely by myself and test the knowledge I've learnt from Sept, 2017.

I named this blog as Seanforfun which is my nickname of Github and I hope this blog will publish soon :)

Technical selections
======================================
* JDK: 1.8
* Front: BootStrap, JQuery, HTML5, thymeleaf
* Backend: SpringBoot, Spring, SpringMVC and MyBatis.
* Spring Cache, may use Redis
* DataBase: MySQL
* Server: Tomcat 8.5.29
* Editor: Markdown, [editor.md](https://github.com/pandao/editor.md)
* Log: Commons Logging
* Url style: Restful
* Connection pool: [Druid](https://github.com/alibaba/druid)
* Markdown to HTML converter: [showdown](https://github.com/showdownjs/showdown)
* Comment plugin: [GITTALK](https://github.com/gitalk/gitalk)

Interfaces demos
======================================
* index page:
![index](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/index.png)
* article page:
![article](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/article.png)
* login page:
![login](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/login.png)
* Terminal page:
![terminal](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/admin_terminal.png)
* Writing page:
![writing](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/write.png)
* Blog management:
![Blog management](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/blogmanage.png)
* Link management:
![Link management](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/resources/static/images/readme/link.png)

DataBase design
======================================
* [User table](https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/User.java)
* [Category table](https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/Category.java)
* [Article table](https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/Article.java)
* [Badge table](https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/Badge.java)
* [Image table](https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/Image.java)
* [Album table](https://github.com/Seanforfun/SeanForFunBlog/tree/master/src/main/java/ca/seanforfun/blog/model/entity/entity/Album.java)

Controller design
======================================
* [IndexController](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/java/ca/seanforfun/blog/controller/IndexController.java)
>1. Get admin user information.
>2. Get user avatar and carousel pictures from third party database.
>3. Get categories and sub-categories from database.
>4. Get pagination Inforamtion and get 5 new blogs from database.
>5. Blog access statistic update.
>6. Get friend's link from database.
>7. Load 3 new blogs with images.

* [ArticleController](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/java/ca/seanforfun/blog/controller/ArticleController.java)
>Ajax response:
>>1. ajaxGetArticle
>>2. ajaxGetArticleByPageindex
>Non-Ajax response:
>>1. Load articles with given category id.
>>2. Load articles for carousel in index.html.

* [LoginController](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/java/ca/seanforfun/blog/controller/LoginController.java)
>Load User information from session
>>1. If user information is saved, we skip the login page and go to admin controller directly.
>>2. If no user remember information provided, go to login page to login.
>Login process.
>>1. Check if current user is existing.
>>2. Check if current user has activated his/her e-mail.
>>3. Update user information and current Ip address and save that into database for future use.
>>4. Save user information into session scope.
>>5. Get blog statistic for admin representation.
>>6. Go to Admin controller.

* [AdminController](https://github.com/Seanforfun/SeanForFunBlog/blob/master/src/main/java/ca/seanforfun/blog/controller/AdminController.java)
>1. Get blog today's access data.
>2. Get blog articles infromation.
>3. Get comments information.
>4. Get Friend's link information.
>5. Get Blog & Server information.

