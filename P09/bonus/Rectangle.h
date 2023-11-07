#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"
#include <string>

class Rectangle : public Shape {
private:
    double width;
    double height;

public:
    Rectangle(double width, double height);

    std::string name() const override;
    double area() const override;
};

#endif
