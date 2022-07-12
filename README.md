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
[What is a Design Pattern?](#what-is-a-design-pattern)  
[What is this Project?](#what-is-this-project)  
[Progress](#progress)  
[Getting Started](#getting-started)

## Introduction
When I wrote my first Java application in 2018, I had no experience nor was I aware of the fundamentals of object-oriented programming/design.

The code was written with the narrow mindset of "getting it done for now". You can imagine, it wasn't very pretty, classes intertwined with each other as if they
were glued with epoxy and forming a dependency graph like a Tangela from Pokemon.

My approach was fundamentally flawed and sometimes you're lucky and you get away with bad code - you don't "pay" for it.

However, I actually received the brunt of my code smells.
Looking through my codebase, trying to fix a bug, I discovered incorrect logic in my duplicated code. However, this wasn't the "forgot to implement hashCode()" type of bug - it was a bug that influenced the interaction between various components of the system.

With no other workaround in mind, I crunched out the bug fixing grind and by the time the issue was fixed, it's about time for me to have dinner. Yep, there goes like 1.5 hours of my time, fixing something I wrote up in maybe 1.5 hours. Should've just started from scratch to be honest.

Had I actually known some techniques for writing maintainable code, those 1.5 hours could've easily been reduced to at most 10 minutes.

Fast forward a year or so and I am taking an object-oriented design subject at university in 2020, intrigued by the idea of design patterns, I went nerd mode and spent my spare time during the next few months reading up design patterns and OOP techniques. 

Ever since, I have actually seen improvement in the speed taken to write and refactor code, and as much as I hate to admit it, object-oriented design has become my favourite topic in my studies.

That being said, I feel like I haven't had the opportunity to exercise all these design patterns to a fulfilling extent. So I thought to myself, let's write up sample code for every famously known design pattern and combine these all into a single Java project.

At the same time I am benefitting from this project by spending time practicing my object oriented programming techniques, I hope that there will be some individuals who may benefit from this project as well, whether as a reference for their own work or overcoming a hurdle.

Finally, I am not a hardcore Java enthusiast, it just happens that this is my most knowledgable programming language. Admittingly though, Java has seen great improvement over the years (this project using Java 18). Many excuses for not using or avoiding Java such as too much boilerplate has been given their own abstractions and workarounds. (eg. Lombok, Java 15 Records).

And to those that disagree with OOP - OOP isn't a solution to every problem, there are some scenarios where a different paradigm may be better suited to the task. However, OOP is good at a particular set of problems and is probably here to stay despite it's so-called "drawbacks".

## What is a Design Pattern?

Have you ever came across a mind fuzz while writing code? That is, you need to achieve a particular task and you have a few ideas on how to design your system
so that it can work, but you are unsure of which path to take, you don't see the full picture and worried whether or not your solution is actually good or even implementable?

As a programmer, it is almost certain you will come across similar situations and problems millions of other programmers encounter every year. Despite many of these
problems belonging to entirely different domains (perhaps a banking app, or an online shopping web app), if we abstract away the context, many of these issues are almost identical in structure and nature.

To combat these reoccuring problems, so-called design patterns are invented so that they can be reused and adapted by a troubled programmer to find a way around his design roadblock.

By definition, a design pattern is a solution to a reoccuring common problem.

Object-oriented design patterns are solutions to reoccuring problems in the context of object-oriented programming.

## What is this Project?

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
| Adaptor | Done |
| Bridge | Done |
| Composite | Done |
| Decorator | Done |
| Facade | Done |
| Flyweight | Done |
| Proxy | Done |
| **Behavioural** | |
| Chain of Responsibility | Done |
| Command/Visitor | Done |
| Observer | Done |
| State | Done |
| Strategy | Done |
| Template method | Done |
| Mediator | Done |
| Memento | Not started |

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
