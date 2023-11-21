#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

class Location {
public:
    Location(const std::string& filename, int line);

    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator<(const Location& rhs) const;

    friend std::ostream& operator<<(std::ostream& os, const Location& location);

private:
    std::string _filename;
    int _line;
    int compare(const Location& rhs) const;
};

#endif
