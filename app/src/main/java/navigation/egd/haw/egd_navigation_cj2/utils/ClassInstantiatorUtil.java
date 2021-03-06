package navigation.egd.haw.egd_navigation_cj2.utils;

/**
 * @author Prannoy
 * This is a generic class which takes in the package name and the class name as a String and using Java reflection finds the Instantiates the class dynamically
 * <a href=https://docs.oracle.com/javase/tutorial/reflect /> Contains pros and cons of Java reflection
 * <a href=http://tutorials.jenkov.com/java-reflection/index.html /> Reflection Examples
 */

//TODO: If a better way found without using Reflection to dynamically instantiate a class, it is not very performant

/**
 * A generic Class is created (ClassInstantiatorUtil<T>) so that a type check can be done before returning the instatiated class
 * @param <T>
 */
public class ClassInstantiatorUtil<T> {
    public ClassInstantiatorUtil() {

    }


    public T instantiateClass(String packageName) {
        try {
            return (T)Class.forName(packageName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
