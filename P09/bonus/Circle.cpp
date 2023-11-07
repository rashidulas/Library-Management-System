#include "Circle.h"
#include <cmath> 

Circle::Circle(double radius) : radius(radius) {
    
}

std::string Circle::name() const {
    return "Circle with radius " + std::to_string(radius);
}

double Circle::area() const {
    return M_PI * radius * radius; 
}
