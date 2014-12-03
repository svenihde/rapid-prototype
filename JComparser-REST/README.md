JComparser REST based
===============

The JComparser is a rapid prototype to get a better understanding of implementing a BPMN REST Interface and preparing it for DB usage

Setup
============

* place jsp in <tomcat home dir>\webapps\ROOT\
* place classes in <tomcat home dir>\webapps\ROOT\WEB-INF\classes\

Maven libraries
============

* net.sf.m-m-m:mmm-util-backport-java.util.function:1.0.12
* mysql:mysql-connector-java:5.1.332
* javax.xml.parsers:jaxp-api:1.4.52
* javax.ws.rs:javax.ws.rs-api:2.0-m012
* javax.servlet.jsp:javax.servlet.jsp-api:2.3.02
* com.sun.jersey.glassfish.v3.osgi:jersey-gf-bundle:1.0.32
* com.liferay:org.apache.commons.fileupload:1.2.2.LIFERAY-PATCHED-12

Example Values
============

for FileUpload:
pcm = [name=null, StoreLocation=c:\xampp\tomcat\temp\upload_d0264de5_1bb3_4ec0_8716_62c7eaceb809_00000000.tmp, size=2 bytes, isFormField=true, FieldName=hiddenfield1, name=PCM.xml, StoreLocation=c:\xampp\tomcat\temp\upload_d0264de5_1bb3_4ec0_8716_62c7eaceb809_00000001.tmp, size=2414 bytes, isFormField=false, FieldName=file1]
