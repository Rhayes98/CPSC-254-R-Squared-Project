echo "echo: Compiling program"
echo "javac *.java"

javac *.java

echo "...done"

echo
echo "echo: Running Program"
echo "java driver"
echo

java Driver

echo
echo "... done"
echo "echo: removing added files"

rm *.class

echo
echo "... done"
echo "echo: removed all .class files" 
