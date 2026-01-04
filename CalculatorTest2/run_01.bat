REM Windos OS
REM 必須是 英文 ASCII資料夾 路徑
REM 中文路徑會出錯

::chcp 65001
::chcp 950

chcp 65001 && javac -version && java -version



rmdir /q /s .\bin\

REM compile
::REM Prepare a temporary file
SET filelist=%cd%\filelist_%random%.txt
::SET filelist=%temp%\filelist-%random%.txt
::echo %filelist%

::REM Use dir /s /b to get the list of *.java files in the src directory (including subdirectories)
dir /s /b .\src\*.java > %filelist%

type %filelist%

::REM Compile all Java source files directly through javac @filename usage and specify the output path (*.class) through -d
javac -encoding UTF-8 @%filelist% -sourcepath .\src\ -classpath . -d .\bin\

::REM Delete temporary files
del %filelist%

::REM Delete the temporary file name variable
SET filelist=

REM Execute

java.exe ^
  -Dfile.encoding=UTF-8 ^
  -Dstdout.encoding=UTF-8 ^
  -Dstderr.encoding=UTF-8 ^
  -classpath .\bin\ com.hsiangyu.CalculatorTest2

