/** 628 - Passwords(Combinaciones en base a reglas) - Problema de Recursividad. */
#include<iostream>
#include<vector>

using namespace std;

int n, m;
string numbers[] = {"0","1","2","3","4","5","6","7","8","9"};
string in;
string rule;
vector<string> dict;

void solve (int index, string out) {
    if (index == rule.size()) {
        cout << out << endl;
    } else {
        if (rule[index]=='#') {
            for (int i=0;i<n;i++) {
                solve(index+1, out + dict[i]);
            }
        } else if (rule[index]=='0') {
            for (int i=0;i<10;i++) {
                solve(index+1, out + numbers[i]);
            }
        }
    }
}

int main() {
    while(cin>>n) {
        for(int i=0;i<n;i++) {
            cin>>in;
            dict.push_back(in);
        }
        cin>>m;
        cout<<"--"<<endl;
        for(int i=0;i<m;i++) {
            cin>>rule;
            solve(0, "");
        }
        dict.clear();
    }
    return 0;
}
