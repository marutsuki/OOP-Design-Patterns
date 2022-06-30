<h1 align="center">
  <img alt="logo" src="/misc/logo.png"><br>
  OOP-Design-Patterns
</h1>
  
<p align="center">This is an ongoing project to demonstrate my enthusiasm for Object Oriented design. 
  Through this repository, you can find sample code of some of the many design patterns dominant in the object oriented paradigm.
  Feel free to reference the code in your own works at your own benefit.
</p>

<p align="center">
  <img alt="license badge" src="https://img.shields.io/github/license/lucien7789/OOP-Design-Patterns">
  <img alt="last commit" src="https://img.shields.io/github/last-commit/lucien7789/OOP-Design-Patterns">
  <img alt="commit activity" src="https://img.shields.io/github/commit-activity/m/lucien7789/OOP-Design-Patterns">
  <img alt="code size" src="https://img.shields.io/github/languages/code-size/lucien7789/OOP-Design-Patterns">
</p>

## Table of Contents  

[Introduction](#introduction)  
[What Is This Project?](#what-is-this-project)  
[Progress](#progress)  
[Getting Started](#getting-started)

## Introduction
When I decided to write my first Java app, I had no experience nor foundation in the fundamentals of object-oriented programming.
Unaware of visibility modifiers, all my variables were of default visibility and accessed directly (I honestly do not hold too much against direct access
nor am I hardcore "Okay, ALL THESE PROPERTIES MUST BE PRIVATE AND ACCESSED ONLY THROUGH GETTERS AND SETTERS", I like JavaScript (roast me now) and I don't mind
not sticking to the Java standard norm of information hiding, I am just trying to express my incompetence). Anyways, I had very jumbled and extremely redundant code and the worst part was when
I found out that I had been using the wrong logic in my duplicated code. Yep, there goes like 1 hour of my time, fixing everything.
Had I actually known the rules for writing maintainable code, that 1 hour could've easily been reduced to like only 10 minutes.

Fast forward a year or so and I am taking an object-oriented design subject at university, intrigued by the idea of patterns, I did the biggest nerd move and spent my spare time
reading up design patterns, specifically GoF. Ever since, I have actually seen improvement in the speed taken to write and refactor code, and as much as I hate to admit it, 
object-oriented design has become my favourite topic in all my studies.

That being said, I feel like I haven't had the opportunity to exercise all these design patterns. So why not just do it on your very own? Yep, so that's my motivation for this project.

Okay, I am not a hardcore Java enthusiast, just putting it out there in case you're one of those anti-Javas, it just happens that this is my most knowledgable programming language due to university
and industry.

And to those that disagree with OOP. I'm not against you, some of your arguments I totally can get. However, OOP is probably here to stay and object-oriented design is the best way we cope with it.

## What Is This Project?

**What is this project in one sentence?**

This project is a collection of sample Java code demonstrating the many design patterns prevelant in the object-oriented paradigm.

**So is this not an application?**

This repository is not an application according to the definition. This project has been designed to be viewed rather than run. Although there are test suites which demonstrate the sample code written.

**What can I get out of it?**

The sample code has been grouped into subpackages based on their pattern, available through _/oopDesignPatterns/src/main/java_. Each set of sample classes contains an explanation (either through an explicit text file or as code comments). You can use this as a refresher on your object-oriented design skills as well as see an actual implementation of the many patterns.

**Why Java?**

I do not particularly have a special thing for Java. It's simply a language I am very familiar with so I chose it. The many patterns you see here can be done in almost any other object-oriented language.

## Progress
##### GoF
| Pattern | Status |
| --- | --- |
| **Creational** | |
| Factory family | In progress |
| Builder | Done |
| Singleton | Done |
| Prototype | Done |
| **Structural** | |
| Adaptor | Done (Can be improved) |
| Bridge | Done |
| Composite | Done |
| Decorator | Done |
| Facade | Done |
| Flyweight | Done |
| Proxy | Done |
| **Behavioural** | |
| Chain of Responsibility | Done |
| Command/Visitor | Not started |
| Observer | Not started |
| State | Not started |
| Strategy | Not started |
| Template method | Not started |
| Mediator | Not started |

## Getting Started
This codebase is not designed with the intention of being run, but rather to be observed and looked at. As such, there is no application class with the main() entrypoint as you would expect in a Java application.

However, the project does come with several test suites made to demonstrate the sample code that can be run.

**Downloading JDK 18 or a Java-catered IDE**

You will need JDK 18 to run the test suites, which you can get here:

<a href="https://www.oracle.com/java/technologies/downloads">Get JDK 18</a>

Otherwise, you can install JDK 18 as part of a Java-catered IDE such as Eclipse or IntelliJ:

<a href="https://www.eclipse.org/downloads/">Get Eclipse</a>

<a href="https://www.jetbrains.com/idea/download/">Get IntelliJ</a>

**Cloning the repository**

Next, you will need to get the files onto your local computer:

You can do this by selecting the _Code_ dropdown at the top of the GitHub repository page.

Then select your preferred way of getting the files.

**Installing the dependencies**

If you just want to read the code, then you can skip this part.
Otherwise, to run the test suites you will need to install the dependencies from the maven remote.

In your command line interface:
```
mvn clean && mvn compile
```
**Running the test suites**

To run all the test suites:
```
mvn test
```

Or if you want to run a specific test suite:
```
mvn -Dtest=<TestClassName> test
```
