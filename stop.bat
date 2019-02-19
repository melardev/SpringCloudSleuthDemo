@echo off
REM -a to show all, -o to show owner(PID in the 5th column of output), -n because it does not get stuck .... bug?
REM ^ to escape the pipe which has a special, findstr is a grep like in Windows. /pid to kill based on pid and /f to force
for /L %%N IN (1,1,4) DO (
(for /f "tokens=5" %%p IN ('netstat -a -o -n ^| findstr :808%%N') DO (taskkill.exe /pid %%p /f ))
)