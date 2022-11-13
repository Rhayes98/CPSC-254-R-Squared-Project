echo "echo: Compiling program"
echo "javac *.java"

javac Image_Processor.java
javac GUI.java
javac BatchImageProcessor.java

echo "...done"

echo
echo "echo: Running Program"
echo "java driver"
echo

java BatchImageProcessor

echo
echo "... done"
echo "echo: removing added files"

rm *.class
#rmdir Processed

echo
echo "... done"
echo "echo: removed all .class files" 
