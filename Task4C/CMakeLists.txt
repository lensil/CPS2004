cmake_minimum_required(VERSION 3.0.0)
project(task4_c VERSION 0.1.0 LANGUAGES C CXX)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(Protobuf REQUIRED)
find_package(PkgConfig REQUIRED)
pkg_search_module(gRPC REQUIRED grpc++)
include_directories(${CMAKE_CURRENT_BINARY_DIR} ${PROTOBUF_INCLUDE_DIRS} $
{GRPC_INCLUDE_DIRS})
set(SOURCE_FILES1 main.cpp shipment_service.pb.cc shipment_service.grpc.pb.cc)
add_executable(shipment_service ${SOURCE_FILES1} )
target_link_libraries(shipment_service ${PROTOBUF_LIBRARIES} ${GRPC_LIBRARIES} grpc++)

add_executable(task4_c main.cpp)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
