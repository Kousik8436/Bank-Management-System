@echo off
cd /d "E:\Java Project\Bank Managment System"
javac -cp ".;lib\jcalendar-1.4.jar" Signup.java
if %errorlevel% equ 0 (
    java -cp ".;lib\jcalendar-1.4.jar" Signup
) else (
    echo.
    echo ❌ Compilation failed.
)
pause