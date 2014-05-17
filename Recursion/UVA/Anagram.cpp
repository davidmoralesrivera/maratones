/*
    UVA Problem 195 - Anagram.
    Recursive Problem.
    Find the possible permutations sorted alphabetically (A <a).
*/
#include<algorithm>
#include<iostream>
#include<string>

using namespace std;

int n;
string in;

bool compare (char a, char b) {
    bool lowerA = true, lowerB = true;
    if (a >= 'A' && a <= 'Z')
        lowerA = false;
    if (b >= 'A' && b <= 'Z')
        lowerB = false;
    if (lowerA == lowerB)
        return a < b;
    if (lowerA) {
        a -= ('a'-'A');
        return a < b;
    } else {
        b -= ('a'-'A');
        return a <= b;
    }
}

int main() {
    cin>>n;
    while(n-->0) {
        cin>>in;
        sort(in.begin(), in.end(), compare);
        do{
            cout<<in<<endl;
        }while(next_permutation(in.begin(), in.end(), compare));
    }
    return 0;
}
