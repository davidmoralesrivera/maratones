/** 10651 Pebble Solitaire(Juego de piedras y cavidades) - Problema de Recursividad. */
#include<iostream>
#include<cstring>

using namespace std;

int min_acum;

void solve (char game[]) {
    char game_aux[15];
    strcpy (game_aux, game);
    for (int i=0;i<11;i++) {
        if (game[i]=='o' && game[i+1]=='o') {
            if (i-1>=0 && game[i-1]=='-') {
                game[i-1] = 'o';
                game[i] = game[i+1] = '-';
                solve (game);
                strcpy (game, game_aux);
            }
            if (i+2<12 && game[i+2]=='-') {
                game[i+2] = 'o';
                game[i] = game[i+1] = '-';
                solve(game);
                strcpy(game, game_aux);
            }
        }
    }
    int acum = 0;
    for (int i=0;i<12;i++) {
        if (game[i]=='o') acum++;
    }
    if (acum<min_acum) min_acum = acum;
}

int main() {
    int n;
    char game[20];
    cin>>n;
    while(n-->0) {
        cin>>game;
        min_acum=1000;
        solve(game);
        cout<<min_acum<<endl;
    }
    return 0;
}
