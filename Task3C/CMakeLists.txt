cmake_minimum_required(VERSION 3.25)
project(untitled2)
set(CMAKE_CXX_STANDARD 20)

set(SOURCE_FILES 
        customer.h customer.cpp shipment.h shipment.cpp package.h package.cpp product.h product.cpp transport.h transport.cpp
        supplier.h supplier.cpp stockitem.h stockitem.cpp textbook.h textbook.cpp book.h book.cpp fictionbook.h fictionbook.cpp
        laptop.h laptop.cpp camera.h camera.cpp electronics.h electronics.cpp
        tshirt.h tshirt.cpp clothes.h clothes.cpp pants.h pants.cpp
        videogame.h videogame.cpp rpg.h rpg.cpp action.h action.cpp
        furniture.h furniture.cpp table.h table.cpp chair.h chair.cpp
        food.h food.cpp fruit.h fruit.cpp premadelunch.h premadelunch.cpp
        stock.h stock.cpp
        ship.h ship.cpp truck.h truck.cpp plane.h plane.cpp
        shipmentitem.h shipmentitem.cpp
        main.cpp CLI.h CLI.cpp
)

add_executable(Task1_B ${SOURCE_FILES})


set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
