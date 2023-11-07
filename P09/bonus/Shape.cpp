#include "Shape.h"

//name() method 
std::string Shape::name() const {
    return "Shape";
}

//area() method 
double Shape::area() const {
    return 0.0;
}

//to_string() method 
std::string Shape::to_string() const {
    return name() + " with area " + std::to_string(area());
}
