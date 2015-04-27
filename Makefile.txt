md build\classes
javac -sourcepath src -d build\classes src\main\Main.java
java -cp build\classes main.Main
timeout /t -1