rem run java code

rem required jdk 11, 17 version

javac -version

java -version

javac -encoding UTF-8 .\src\module-info.java ^
  .\src\com\test\Test1.java ^
  .\src\com\test\PictureBean.java ^
  .\src\com\test\StringFilterVo.java ^
  .\src\com\test\StringFilter.java ^
  -d .\bin

java --module-path .\bin -m TestJavaData_2_/com.test.Test1

::java -classpath .\bin com.test.Test1

pause