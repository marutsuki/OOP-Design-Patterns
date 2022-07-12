# Visitor pattern

### Problem
How do we perform operations over a set of differently typed objects while requiring the distinct properties of the classes?

How do we achieve this without bloating the classes themselves with unnecessary complication?

### Scenario
You are tasked with designing a GUI engine, which will enable your users to create their own
windowed applications through your vast library of GUI components.

The main problem you need to solve is to make the components interactable. 
To solve this, you came up with an event driven system where various "Event" objects are passed around
and the components can decide what to do with them.

For example, there can be an Event object for keypresses.

However, you soon realize that you can't just pass the generic Event interface to the components.
Reason being that each unique Event contains particular properties that need to be accessed.

For example:
A Keypress Event would contain the key value
A mouse click Event would contain the location of the click

You come up with two approaches:
- A massive switch block in each event handler to check the instance of the particular event
  - However, this would be very ugly and cause repetitive code in each handler
- Implementing the functionality inside the Event
  - However, you're bloating the Event classes with irrelevant logic - In-cohesiveness

### Solution
The Visitor pattern suggests that we extract the behaviour away from the subject class into a separate
**visitor** class(s). The visitor(s) is/are a hierarchy of classes that has a method for interacting with each
subject it wishes to interact with.

For example, we will create an EventVisitor interface that exposes a method visit() for each particular event.

Eg.
```
default void visit(KeyPressEvent event);
default void visit(MouseClickEvent event);
default void visit(WindowLoadedEvent event);
```
Then, we enforce each subject to be visitable by making them implement an acceptVisitor method.
This way, once a subject wants to be processed, the subject itself will accept the visitor object:

```subject.accept(visitor);```

Which would then in turn call:

```visitor.visit(this);```

This way, each subject can be handled differently based on its type and visitor.

Furthermore, we can use polymorphism to create a generic visitor interface that would allow an infinite set of operations that work on the subject classes without changing the subject classes themselves.

#### But

The first question that often arises is _Why do we need to make it so complex? Isn't this just normal method
overloading? Why does the subject need to **accept** the visitors?_

The reason is that method overloading would not help us in solving this problem.

**Why?**

That's because, method overloading relies on the knowledge of what type the parameter is **in advance**.

We don't want the rest of our system checking and typecasting each Event object to its particular class
as it would tightly couple the controllers to each particular implementation of Event. Furthermore, it would
violates the dependency inversion principle.

That all being said, how do we pass a generic ```Event event``` variable into handlers
and allow them to determine the type of Event without drawn out and potentially duplicated switch statements?

**Double dispatch**

That is what is being done by the subject classes.

To the external controller, it doesn't and shouldn't be aware of what type the subjects are. So who should?

The answer is the subject classes themselves!

The Event classes themselves know better than anyone what type they are.

So if they call:

```visitor.visit(this)```

Essentially, it will allow the visitor to correctly dispatch the call to the correct
method because ```this``` refers to the calling object, which will never be a generic Event class.

### Discussion

#### Advantages
- Single responsibility principle/cohesion - as the functionalities are delegated to a separate class, the subjects become more aligned with it's own logic
- Open/Closed principle - If we need a new set of functionalities to deal with the set of subjects, we can simply extend the Visitor

#### Disadvantages
- Tight coupling - The generic Visitor interface is tightly coupled to the set of subjects, if new subjects come, then the visitor interface needs to be updated - 
furthermore, all visitor implementations may need to update themselves too. However this disadvantage is partially alleviated by the concept of default methods and abstract classes, allowing implementations to simply not worry about them
- Reliance on access given - As the Visitor classes are external to the subject, access to some properties can be problematic