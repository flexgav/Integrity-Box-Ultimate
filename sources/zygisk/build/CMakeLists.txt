cmake_minimum_required(VERSION 3.22.1)

project(playintegrityfix)

add_library(${CMAKE_PROJECT_NAME} SHARED main.cpp local_cxa_atexit_finalize_impl/atexit.cpp)

add_subdirectory(Dobby)

SET_OPTION(Plugin.Android.BionicLinkerUtil ON)

target_link_libraries(${CMAKE_PROJECT_NAME} PRIVATE log dobby_static)

# --- Release: размер/стелс/надёжность (C1-C4) -------------------------------
# -Oz + dead-strip уменьшают .so (меньше поверхность детекта), exclude-libs
# прячет символы Dobby из динамической таблицы, relro/now/stack-protector —
# дешёвое усиление целостности.
if(CMAKE_BUILD_TYPE STREQUAL "Release")
    target_compile_options(${CMAKE_PROJECT_NAME} PRIVATE
        -Oz
        -ffunction-sections -fdata-sections
        -fno-unwind-tables -fno-asynchronous-unwind-tables
        -fstack-protector-strong
        -flto=thin)
    target_link_options(${CMAKE_PROJECT_NAME} PRIVATE
        -flto=thin
        -Wl,--gc-sections
        -Wl,--exclude-libs,ALL
        -Wl,-z,relro -Wl,-z,now
        -Wl,--strip-all)
endif()