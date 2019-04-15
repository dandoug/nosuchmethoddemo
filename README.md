# nosuchmethoddemo

This project demonstrates a **NoSuchMethodError** I encountered recently.

It's somewhat vexing because at a source level, the code will work no matter whether it is run with the `oldlib` or the `newlib`.  The problem is if the `main` class is compiled with the `oldlib` and then run with the `newlib` (or vice versa) then the call to `get` will fail.

The `get` method is defined in a super class of `AppGroup` no matter which version is run.  The specific issue is that the compiled bytecodes will create an `invokespecial` instruction that references a specific class and method name for the `get` invocation.  If the `old` and `new` libs are mixed, then the specific reference refers to a class that is not in the calling classes parent hierarchy or to a method that does not existing in the specifically referenced class.  This genenerates the **NoSuchMethodError**.

To read more details about method dispatch in a JVM, refer to [this excelent article](https://www.lohika.com/methods-invocation-inside-of-a-java-virtual-machine/) by [Alexander Dukhno](https://www.linkedin.com/in/alex-dukhno-41181723/).

To reproduce an example of **NoSuchMethodError** , run this script from this repo after cloning 
```
  ./demoNoSuchMethodError.sh
```

This will

* run the build using `oldlib` and save `main.jar`,
* run the build using `newlib` and save `lib.jar`
* try to execute `main.jar` with `lib.jar` on the classpath

This is the expected output

```
$ ./demoNoSuchMethodError.sh 

Building main .jar with old library....

Building new library....

Trying to run main built with old lib, using new lib. Will generate NoSuchMethodError...

Exception in thread "main" java.lang.NoSuchMethodError: com.ebay.demo.AppGroup.get(Ljava/lang/Object;)Ljava/lang/Object;
	at com.ebay.demo.AppGroup.main(AppGroup.java:20)

```

## Prerequisites

* bash
* maven on PATH
* java 8 on PATH
