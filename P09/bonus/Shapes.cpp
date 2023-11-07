#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>

int main() {
    std::vector<Shape*> shapes; 

    Rectangle rectangle(5.0, 3.0);
    Circle circle(2.0);
    
    shapes.push_back(new Rectangle(3.0, 5.0));
    shapes.push_back(new Circle(2.0));

    for (const Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    for (Shape* shape : shapes) {
        delete shape;
    }

    return 0;
}
