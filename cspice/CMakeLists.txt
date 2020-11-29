cmake_minimum_required(VERSION 3.10)

project(cspice C)

option(USE_MINGW "MinGW build on Windows" OFF)
if(USE_MINGW)
  add_definitions(-DMSDOS)
  set(CMAKE_SHARED_LIBRARY_PREFIX "")
endif()

if(NOT CMAKE_BUILD_TYPE)
  message(STATUS "No build type selected, default to Release")
  set(CMAKE_BUILD_TYPE Release)
endif()

include_directories(
  ${PROJECT_SOURCE_DIR}/include
)

file(GLOB CSPICE_SRC 
  src/cspice/*.c
)

add_library(cspice SHARED ${CSPICE_SRC})
