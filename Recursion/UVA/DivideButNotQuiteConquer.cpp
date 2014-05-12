/** 10190 - Divide, But Not Quite Conquer!. Dividir y mostrar divisores(solo si es divisible exacto hasta 1 */
#include<iostream>
#include<string>
#include<sstream>

using namespace std;

int n, m;
string out;

string int_to_str(int n) {
    stringstream ss;
    ss << n;
    return ss.str();
}

void solve() {
    if (n>1) {
        if (n%m!=0) {
            out="Boring!";
            return;
        }else{
            n/=m;
            out += " "+int_to_str(n);
            solve();
        }
    }
}

int main() {
    while(cin>>n>>m) {
        if ( n < 2 || m < 2 || m > n ) {
            out="Boring!";
            cout<<out<<endl;
            continue;
        }
        out = int_to_str(n);
        solve();
        cout<<out<<endl;
    }
    return 0;
}
