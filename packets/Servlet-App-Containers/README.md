Application & Servlet Containers
A brief introduction to the basic components and concepts behind application containers, why we use containers, and some specifics around the architecture of JBoss EAP, Red Hat’s flagship middleware product.

What is Application Container?
An application server or container, is a software framework that provides both facilities to create web applications and a server environment to run them.
Most Application Server Frameworks contain a comprehensive service layer model. An application server acts as a set of components accessible to the software developer through an API defined by the platform itself. For Web applications, these components are usually performed in the same running environment as its web server(s), and their main job is to support the construction of dynamic pages. However, many application servers target much more than just Web page generation: they implement services like clustering, failover, and load-balancing, so developers can focus on implementing the business logic.
In the case of Java application servers, the server behaves like an extended virtual machine for running applications, transparently handling connections to the database on one side, and, often, connections to the Web client on the other.
Commonly Used Implementations: WebLogic Application Server by Oracle, WebSphere Application Server from IBM and the open source JBoss Enterprise Application Platform (JBoss EAP) by Red Hat.
What is Servlet Container?
A Servlet container is the component of a web server that interacts with Java servlets.  Most if not all modern application containers will contain some kind of internal servlet container.  JBoss uses Apache Tomcat as it’s servlet container. A servlet container is responsible for managing the lifecycle of servlets, mapping a URL to a particular servlet and ensuring that the URL requester has the correct access rights.
A web container handles client requests for servlets, JavaServer Pages (JSP) files, Java and other types of files that include server-side code. The Web container creates servlet instances, loads and unloads servlets, creates and manages request and response objects, and performs other servlet management tasks.
A web container implements the web component contract of the Java EE architecture, specifying a runtime environment for web components that includes security, concurrency, lifecycle management, transaction, deployment, and other services.
Commonly Used Implementations: Tomcat by Apache, Jetty by Eclipse

Web Server and Application Server Interaction 1
When dealing with Web-based requests, before tunneling through to our application server, a client (think a person using a web browser) will always hit a Web server first. An application server does not replace the need for a Web server, but most modern application servers come with a web server packaged with them (JBoss actually uses Tomcat as both its web server and Servlet container). A Web server remains as pivotal a part of the application server architecture as ever.
Web servers are great at doing one thing: serving up files. A Web server takes requests from clients, maps that request to a file on the file system, and then sends that file back to the client.
If you want an HTML file, a Web server can efficiently and reliably find that file and send it back to you. If you need an image, a Web server can serve it up to you as well. You want to download a .zip file or a .pdf file quickly and efficiently? A Web server can make that happen.
Unfortunately though, your Web server is about as intelligent as a male model. A Web server can serve up static files until the cows come home, but ask your Web server to add ‘one plus one’ and you’ll be waiting there for a very, very long time.
If our applications use any images, HTML, .pdf or .zip files, we like to keep all of those static files on the Web server. If we need some logic or dynamic content in our applications, we will delegate to our Servlets, JSPs, EJBs and JavaBeans that are running on our application server.
From Web Server to Application Server
When a client makes a request for a JSP or a Servlet, the request initially goes to the Web server. The Web server reads the special XML file the application server provides, and realizes that the request that came in should be sent to the application server for processing.
The special XML file also provides the IP address/port combination of listening application servers. The Web server, using the http protocol, then sends the request to the Application server JVM.
The JVM listening on the appropriate port represents our application server, and the port the JVM listens on can be configured through that JVM’s Web container.
The Web server handles the incoming request, and matches that request to the application server set up to handle the given Servlet or JSP.
Inside the Web Container
If the Servlet hasn’t been called before, the JVM loads the Servlet and then generates a thread to handle the request.
Servlets are shy little creatures. They sit on the hard drive just minding their own business, and don’t bother anyone until they've been invoked. However, feed a few drinks to those Servlets – get them loaded – and they remain resident in memory until the party ends, which happens when someone pulls the plug on the application server.
So, the request gets sent from the client, to the Web server, and the Web server passes the request to the application server, who in turn invokes and threads the appropriate Servlet.
What does our Servlet do?
Well, the Servlet can do pretty much anything the developer wants it to do. When programming Servlets, a developer is only limited by their creativity, and more likely, their Java programming skills.
Typically, a Servlet implements some control logic. For example, a Servlet might figure out what a user typed into some text fields in a web-based form. It might then take that information and save it to a database.
Servlets are intended to be controllers. While Servlets can interact directly with a database, they’re not really supposed to. Instead, Servlets are supposed to delegate to a JavaBean or an EJB to do such things. Let’s say, for the sake of argument, our Servlet calls an EJB.
1 This section’s content was borrowed from here and modified to fit better within the context of this packet

JBoss EAP Overview



More Related Links
JBoss EAP / Wildfly Overview (video)
Slightly Dated Introduction to Application Servers
Difference between JSF and JSP
Middleware - Wikipedia
JBoss EAP Documentation
Java EE 6 Spec

Quiz

