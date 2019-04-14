#!/bin/bash

echo
echo Building main .jar with old library....
mvn -q -Poldlib clean install
rm main.jar 2>/dev/null
cp nosuchmethod-main/target/nosuchmethod-main-1.0-SNAPSHOT.jar main.jar
echo

echo Building new library....
mvn -q -Pnewlib clean install
rm lib.jar 2>/dev/null
cp nosuchmethod-newLib/target/nosuchmethod-newLib-1.0-SNAPSHOT.jar  lib.jar
echo

echo Trying to run main built with old lib, using new lib.  Will generate NoSuchMethodError...
echo
java -cp main.jar:lib.jar com.ebay.demo.AppGroup
echo