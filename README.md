groovy-template-engine
======================

A Groovy Renderer for Magnolia CMS

Can be installed as Magnolia Module, together with some sample content.

## Prerequisites
* [git](http://git-scm.com/)
* [java](java.com)
* [Maven](maven.apache.org)

## Quickstart
```shell
git clone https://github.com/kindofwhat/groovy-template-engine.git groovy-template-engine
cd groovy-template-engine
mvn clean package
java -jar groovy-template-engine-webapp/target/groovy-template-engine.jar
```
Then open up a browser onto http://http://localhost:8080/gte, install magnolia, and find an example under http://localhost:8080/gte/.magnolia/admincentral#app:pages:detail;/grhome:edit