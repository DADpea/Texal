# Texal

Texal is a programming language that takes two forms, minecraft block coding and text coding. 
Both forms compile to an intermediate file that can be interpreted standalone.


Due to not having a great notation for minecraft blocks, this file will only cover the text aspect of the language for the time being.


## Design Goals:
- Object Oriented
- Compile to intermediate language along with block-based form
- Statically Typed with Implicity
- Classes
- C-Like Syntax
- Event Driven
- Heavy null-safety


## Basic Code:
When Texal files are compiled, all files are compiled together as if they were one. 
You could have one giant file, or split a program up into tons of small programs, it's up to the user.

The top-level of a Texal program contains events, functions, and classes.

Here is an example of a function definition. Line comments are started with a //
```
fun myFunction() {
  // Function statements here
}
```

Here is an example event, events will be explained in more detail later.
```
event(JoinEvent e) {
  // Event code
}
```

Here is an example class. It should be fairly simple to understand what is going on.
Classes will be gone into in detail later.
```
class Person {
  fun MyClass(string myName, int age) {
    .name = a     // .name is shorthand for this.name
    .age = b
    .id = generateID()
  }

  fun ~generateID() {
    return randInt(0,99999999) // randInt returns int.
  }
}
```


## Statements:
While the program and classes contain functions and events, functions and events contain statements.

The basic statement types are:
- If (If/Else)
- For loops
- While loops
- Try/Catch (Try/Catch/Finally)
- Assignments
- Function calls
- return, break, continue, assert.

...
