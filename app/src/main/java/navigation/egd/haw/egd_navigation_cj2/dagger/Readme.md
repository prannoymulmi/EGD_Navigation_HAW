 # Examples
     <a href = https://github.com/slidenerd/Vivz_Dagger_2_Demo/>
     <a href = http://slidenerd.com/2015/09/11/android-dependency-injection-frameworks />
     <a href = https://github.com/peter-tackage/dagger2-examples/blob/master/build.gradle />


 # Inversion of control (IoC) principles[1]
    1) The modules of top levels shouldn’t depend on modules of the lower levels. The modules of all levels should depend on abstractions.
    2) The abstractions shouldn’t depend on details. The details should depend on abstractions.

 # Design disadvantages to be eliminated with IoC[1]
    1) Rigidity. If we change one module the other modules are changed too.
    2) Fragility. If we change one part of program the other parts will have got uncontrolled errors.
    3) Immobility. The single module can be hardly separated from the rest part of the application to be used again.

 # Dagger Framework details
    //TODO: write the three question expalin about the annotations etc
    // If you have the hex error cleanBuild -> Rebuild the solution
 # References:
    1 https://android.jlelse.eu/dagger-2-part-i-basic-principles-graph-dependencies-scopes-3dfd032ccd82
    2 https://blog.davidmedenjak.com/android/2017/04/28/dagger-providing-different-implementations.html
    3 https://blog.davidmedenjak.com/android/2016/05/04/dagger-2-introduction.html //dagger2 Intro