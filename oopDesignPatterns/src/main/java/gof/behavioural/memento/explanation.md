# Memento

### Problem
How do we enable a system where users can restore the previous state of an object whether the
internals are exposed completely or not?

### Scenario
You are tasked with designing a drawing board application where the user can drag shapse and images
onto a white board, beyond the board display itself the user can modify the name, size and description of the drawing canvas.

As most modern editors, your drawing board application is required to support undoing and redoing.

This seems simple at first, so you create a class representing a snapshot of the drawing board state.

However, your mentor tells you that she doesn't want you to expose any access to any of the drawing board internal properties.

You're at a loss, the construction of your snapshot class involves accessing the state of the drawing board.

### Solution
The Memento pattern suggests that our approach is making classes do things they are not the expert of.

**What does this mean?**

Simply, we're getting an external module to create a snapshot of the subject state. They are not the most knowledgable
component when it comes to the subject state.

**So who's the most knowledgeable component?**

The answer is the subject itself.

In this case, the drawing board.

Therefore, it should be the class that holds the state of the drawing board, the drawing board class itself that should create the historical snapshots.

We do this through the method:

```
public Memento save();
```

Which creates an instance of the Memento class (snapshot class).

**However, now there is another issue:**

_If we don't have full access to the internal state of the subject, we shouldn't expose it through the Memento class either._ So how do we access the historical state of the Momento to restore it to the subject?

**How we do it**

The Memento pattern suggests that we don't expose the state of the Momento either,
keeping it completely hidden from users. Instead, we expose a restore() method and compose the Memento object of the original subject itself upon creation.

```
public void restore();
```

When we call this restore method, the Memento will set the state of the contained subject to that of itself.
Without ever exposing the current or past states of the subject to the external user.

### Discussion

#### Advantages
- Encapsulation/Information hiding - The state of the subject is contained in the Memento and not exposed or shared to the outside world.

#### Disadvantages
- Single responsibility principle/In-cohesiveness - The subject class is now responsible for an extra task beyond maintaining its own state and functionalities.
- Requires access modifiers - This pattern is dependent on the technology as a programming language which doesn't allow access restriction can expose
state to the user and even let them modify it.
- Nested state - Although the subject has complete access to its own state, it might not have access to the state of nested objects that it composes of to clone.