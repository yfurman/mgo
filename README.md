mgo
===

webapp for mgo


 Technologies used:

 - MongoDB to store a list of users in json format. There are no foreign key constraints in this application, and Java provides
   Jackson library to map json to Java object easily. I used maven to build the project and generate war file, then deploy it to
   Tomcat and make rest calls. I used Spring MVC to set up Restful web service calls.
 
  - To handle versioning, the base path for Rest call should be changed in the web.xml file when doing servlet mapping. 
   In particular, I can add version number (i.e. v1, v2, e.t.c. from the properties file) to the servlet url pattern, such as:
    
    <servlet-mapping>
        <servlet-name>mgo</servlet-name>
        <url-pattern>/${version}</url-pattern>
    </servlet-mapping>
    
    The request mapping path in the controllers should be changed correspondingly to support newer version. The older controllers
    should be kept in the source too to still support the older version.
    
    
- For pagination, I would create Pagination that stores total number of items (users), current page number, items per page, 
  previous page, and next page. For each requested page to load, I would calculate the starting record number.
  The new method should be added to UserDao to retrieve a list of users starting from a specific record number, such as:
  
    userDao.listUsersByGender(String gender, Integer start, Integer limit), where limit is items per page.
    
    
- Running instructions:

  1. Please install Java 1.6, Tomcat 7, latest MongoDB, maven 3, and Eclipse.
  
  2. Download source code from the following github link:
  
    https://github.com/yfurman/mgo.git
    
 3. Create a new project by importing all the source in your Eclipse environment.
 
 4. Start mongoDB on your machine.
 
 4. Go to your project folder and build it. Issue the following commmand:
 
    mvn clean install -DskipTests
    
    Note: you don't have to skip the tests, however, you should change the values to your own before running them. For example,
    in the DirectoryServiceImplTest the path /Users/eugenefurman/Documents might not exist on your hard drive.
    
 5. The mgo database contains User collection. Please run UserDaoImplTest.testAddUser(), changing username, password, role, and gender
    to different values in order to insert unique users. My program does not enforce username to be unique since this is not a production
    application, however, it should handle attempts to insert duplicate users.
    
 6. Run the following command to deploy war file to your <tomcat_home>/webapps directory.
 
 7. Start tomcat.
 
 8. Here are the Rest calls for each different task.
 
 
    1) check status of running components (it is only able to test mongodb connection):  
    
       - http://localhost:8080/mgo/configuration/components
       
    2) list all users filtered by gender:
    
       - http://localhost:8080/mgo/user?gender=male
       
       grouping by does not seem to be relevant in this case, because we are not aggregating on anything, such as count, sum, date.
       
    3) list all files in the directory:
    
       - http://localhost:8080/mgo/configuration/files?path=<your_path>
       
       if the provided path is not valid, it will log the exception and return empty list
       
    4) authenticate user
    
       - http://localhost:8080/mgo/authenticate.jsp
       
       Please enter username and password in the text fields (left to right), then click authenticate. Clicking on authenticate button
       generates ajax post request that sends json data consisting of username/password. This json object is mapped to the
       AuthParams Java object annotated by RequestBody in the UserController.
       
