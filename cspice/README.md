# SPICE Toolkit for C Shared Library

## Building on Windows

Instructions for building <b>cspice.dll</b> shared library with MinGW-w64 compiler and CMake.
Tested with SPICE Toolkit version N66.

### Prerequisites
* MinGW-w64 compiler
* CMake

### Build
* Download <a href="http://naif.jpl.nasa.gov/pub/naif/toolkit/C/PC_Cygwin_GCC_64bit/packages/cspice.tar.gz"><b>cspice.tar.gz</b></a> 
file from NAIF web site (PC_Cygwin_GCC_64bit version).
* Extract <b>cspice.tar.gz</b> to a folder, such as <b>C:\tmp\cspice</b>.
* Copy <b>CMakeLists.txt</b> from this repo into <b>C:\tmp\cspice</b> folder.
* Create a build folder, such as <b>C:\tmp\build</b>.
* Run CMake from the build folder.
```
cmake -DUSE_MINGW=ON -G "MinGW Makefiles" ..\cspice
```
* Make sure there were no errors and <b>Makefile</b> was generated.
* Run MinGW make
```
mingw32-make.exe -j4
```
* If there are no errors, <b>cspice.dll</b> shared library will be created in the build (current) folder.


## Building on Linux

Instructions for building <b>libcspice.so</b> shared library with gcc compiler and CMake.
Tested with SPICE Toolkit version N66.

### Prerequisites
* gcc compiler
* make
* CMake

### Build
* Download <a href="http://naif.jpl.nasa.gov/pub/naif/toolkit/C/PC_Linux_GCC_64bit/packages/cspice.tar.Z"><b>cspice.tar.Z</b></a> 
file from NAIF web site (PC_Linux_GCC_64bit version).
* Extract <b>cspice.tar.Z</b> to a folder, such as <b>/tmp/cspice</b>.
* Copy <b>CMakeLists.txt</b> from this repo into <b>/tmp/cspice</b> folder.
* Create a build folder, such as <b>/tmp/build</b>.
* Run CMake from the build folder.
```
cmake ../cspice
```
* Make sure there were no errors and <b>Makefile</b> was generated.
* Run make
```
make -j4
```
* If there are no errors, <b>libcspice.so</b> shared library will be created in the build (current) folder.
