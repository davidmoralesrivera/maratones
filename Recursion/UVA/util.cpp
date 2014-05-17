#include<iostream>
#include<string>
#include<cstring>
#include<sstream>

using namespace std;

const int MAX = 100;
long long triangle[MAX +1][MAX +1];

string int_to_str(int n) {
    stringstream ss;
    ss << n;
    return ss.str();
}

int array_length(int* _array) {
    return sizeof(_array)/sizeof(*_array);
}

int nCr(int n, int r) {
    memset(triangle, -1, sizeof triangle);
    if (n<r) return 0;
    if (triangle[n][r]>=0) return triangle[n][r];
    if (n==0 || n==1 || n==r || r==0) {
        triangle[n][r] = 1;
    }else{
        triangle[n][r] = nCr(n-1, r-1) + nCr(n-1, r);
    }
    return triangle[n][r];
}

int main() {
    cout<<nCr(4,3)<<endl;
    return 0;
}

