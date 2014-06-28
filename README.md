groovy-template-engine
======================

A Groovy Renderer for [Magnolia CMS](http://www.magnolia-cms.com) using the excellent 
[MarkupTemplateEngine](http://groovy-lang.org/docs/groovy-2.3.2/html/documentation/markup-template-engine.html)

## But why, oh why?
[Groovy](http://groovy-lang.org) is an excellent language for the jvm. [Magnolia CMS](http://www.magnolia-cms.com) is a 
very cool open source CMS for the jvm. Let's explore how to combine those two technologies. Both are two of my prefered 
technologies, by the way...

### What are the advantages over other templating languages?
The Groovy [MarkupTemplateEngine](http://groovy-lang.org/docs/groovy-2.3.2/html/documentation/markup-template-engine.html) is 
consisting of plain Groovy code. This means that it

* can be compiled (even type checked)
* can be debugged (yes, set a breakpoint in that template)
* easily extended
* has a great syntax
* can be developed in one language

Or put another way: it would be a shame to not combine such cool technologies :)

## Prerequisites
* [git](http://git-scm.com/)
* [java](http://java.com)
* [Maven](http://maven.apache.org)
* has been tested and devloped against [Magnolia](http://www.magnolia-cms) version 5.2.3

## Quickstart
```shell
git clone https://github.com/kindofwhat/groovy-template-engine.git groovy-template-engine
cd groovy-template-engine
mvn clean package
java -jar groovy-template-engine-webapp/target/groovy-template-engine.jar
```
Then open up a browser onto [http://localhost:8080/gte](http://localhost:8080/gte), install magnolia, 
and find an example under [http://localhost:8080/gte/.magnolia/admincentral#app:pages:detail;/grhome:edit](http://localhost:8080/gte/.magnolia/admincentral#app:pages:detail;/grhome:edit)

## Development Workflow
* it is strongly suggested to create your own magnolia module with the Magnolia [maven archetype](https://wiki.magnolia-cms.com/display/WIKI/Module+QuickStart)
* add the following dependency to your project pom: 
```xml
   <dependency>
          <groupId>info.magnolia</groupId>
          <artifactId>module-groovy-template-engine</artifactId>
          <version>1.0-SNAPSHOT</version>
      </dependency>
```
* create your pages with definitions, areas, components as usual (more details in the Magnolia docu)


## Current state
It is more a proof of concept at the moment. You can create pages, areas and components.

### Missing Stuff
* template scripts are beeing server from the filesystem
* no additional arguments to cmsArea and cmsComponent

