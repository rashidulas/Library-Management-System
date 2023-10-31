#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>

bool naturalCompare(const std::string& a, const std::string& b) {
    return a < b;
}

bool lengthCompare(const std::string& a, const std::string& b) {
    if (a.length() == b.length()) {
        return naturalCompare(a, b);
    }
    return a.length() < b.length();
}

int main(int argc, char* argv[]) {
    std::vector<std::string> caps;   
    std::vector<std::string> no_caps; 

    for (int i = 1; i < argc; i++) {
        std::string arg = argv[i];

        if (!arg.empty() && std::isupper(arg[0])) {
            caps.push_back(arg);
        } else {
            no_caps.push_back(arg);
        }
    }

    std::sort(caps.begin(), caps.end(), naturalCompare);

    std::sort(no_caps.begin(), no_caps.end(), lengthCompare);

    std::cout << "Capitalized:" << std::endl;
    for (const std::string& word : caps) {
        std::cout << word << std::endl;
    }

    std::cout << "Lower Case:" << std::endl;
    for (const std::string& word : no_caps) {
        std::cout << word << std::endl;
    }

    return 0;
}
