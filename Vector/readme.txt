The Vector program I have written is a data structure that acts similarly to an ArrayList but has a dynamic size. In order to run the program, you simply have to download the files and run the VectorRunner.java program. It contains methods to add elements, remove elements, get elements at particular positions, increase the capacity of the vector, set certain positions, calculate the size, clear the vector, check if it is empty, check if it contains something, check the index of a particular element, and turning the vector into string form.

Why can you not have an array of type E?
	Java's arrays at runtime contain information about its component type. Since you do not know what E is at runtime, you cannot create an array of type E.

Explain the difference between Errors and Exceptions.
	There are several key differences between errors and exceptions. It is not possible to recover from an error as you must terminate execution. You can recover from exceptions by using tools such as try-catch blocks. Errors are only unchecked while exceptions can be checked or unchecked. Errors happen at runtime and are not known to the compiler while checked exceptions are known to the compiler. Errors are mostly caused by the environment the application is running in. On the other hand, exceptions are mostly caused by the application instead.
	
What’s the value in having a copy constructor?
	If there is a complex object with many attributes, it is much simpler to use a copy constructor. Also, if you add a new attribute to a class, you can just change the copy constructor to take it into account rather than changing every occurence of the other constructor.

What would the run-times of your various methods be? How does initial capacity impact run time?
	Adding to the end of the vector, the get method, the set method, the size method and the isEmpty method run at O(1). All other methods run at O(n). It is more efficient to specify the initial capacity because if it is not set, the internal array must be repeatedly reallocated as the list grows.
