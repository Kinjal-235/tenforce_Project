@echo off
@echo off
echo ========================================
echo   Tenforce Automation Test Runner
echo ========================================
echo.

echo Checking Maven installation...
mvn --version
if %errorlevel% neq 0 (
    echo ERROR: Maven is not installed or not in PATH
    echo Please install Maven first
    pause
    exit /b 1
)

echo.
echo Starting test execution...
echo.

mvn clean test

echo.
echo ========================================
echo   Test Execution Complete
echo ========================================
echo.

if %errorlevel% equ 0 (
    echo [SUCCESS] All tests passed!
    echo.
    echo Opening test report...
    start target\surefire-reports\index.html
) else (
    echo [FAILED] Some tests failed. Check the output above.
    echo.
    echo Opening test report...
    if exist target\surefire-reports\index.html (
        start target\surefire-reports\index.html
    )
)

echo.
pause