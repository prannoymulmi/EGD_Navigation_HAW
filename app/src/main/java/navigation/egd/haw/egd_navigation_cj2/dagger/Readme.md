 # Inversion of control (IoC) principles[1]
    1) The modules of top levels shouldn’t depend on modules of the lower levels. The modules of all levels should depend on abstractions.
    2) The abstractions shouldn’t depend on details. The details should depend on abstractions.

 # Design disadvantages to be eliminated with IoC[1]
    1) Rigidity. If we change one module the other modules are changed too.
    2) Fragility. If we change one part of program the other parts will have got uncontrolled errors.
    3) Immobility. The single module can be hardly separated from the rest part of the application to be used again.

 # Dependency Injection 
    In software engineering, dependency injection is a technique whereby one object supplies the dependencies of another object. A dependency is an object that 
    can be used (a service). An injection is the passing of a dependency to a dependent object (a client) that would use it. The service is made part of the client's state.[4]
    
    # Advantages
       1 Dependency injection allows a client to remove all knowledge of a concrete implementation that it needs to use. This helps isolate the client from 
         the impact of design changes and defects. It promotes reusability, testability and maintainability[5]
       2 Reduction of boilerplate code in the application objects, since all work to initialize or set up dependencies is handled by a provider component.[5]
       3 Dependency Injection decreases coupling between a class and its dependency.[6] 
       
    # Disadvantaages
       1 Dependency injection creates clients that demand configuration details be supplied by construction code.
       2 Dependency injection can make code difficult to trace (read) because it separates behavior from construction. 
         This means developers must refer to more files to follow how a system performs.
       3 Dependency injection forces complexity to move out of classes and into the linkages between classes which might not always be desirable or easily managed.[7]  
 # Dagger Framework details
    //TODO: write the three question expalin about the annotations etc
    // If you have the hex error cleanBuild -> Rebuild the solution
    
  # Examples
      <a href = https://github.com/slidenerd/Vivz_Dagger_2_Demo/>
      <a href = http://slidenerd.com/2015/09/11/android-dependency-injection-frameworks />
      <a href = https://github.com/peter-tackage/dagger2-examples/blob/master/build.gradle />   
 # References:
    1 https://android.jlelse.eu/dagger-2-part-i-basic-principles-graph-dependencies-scopes-3dfd032ccd82
    2 https://blog.davidmedenjak.com/android/2017/04/28/dagger-providing-different-implementations.html
    3 https://blog.davidmedenjak.com/android/2016/05/04/dagger-2-introduction.html //dagger2 Intro
    4 I.T., Titanium. "James Shore: Dependency Injection Demystified". www.jamesshore.com. Retrieved 2015-07-18.
    5 "The Java Community Process(SM) Program - JSRs: Java Specification Requests - detail JSR# 330". jcp.org. Retrieved 2015-07-18.
    6 "The Dependency Injection Design Pattern". msdn.microsoft.com. Retrieved 2015-07-18
    7  "What are the downsides to using Dependency Injection?". stackoverflow.com. Retrieved 2015-07-18.