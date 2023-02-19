#include <iostream>
#include <cmath>

#define endl '\n'

using namespace std;

int N, M;
bool isFirst = false;
bool isPrime(int x);
pair<int, int> p;
int main(void) {
	cin >> N >> M;

	for (int i = N; i <= M; ++i) {
		if (i == 1) continue;
		if (isPrime(i)) {
			if (!isFirst) {
				p.second = i;
				isFirst = true;
			}
			p.first += i;
		}

	}

	if (p.first)cout << p.first << endl << p.second << endl;
	else cout << -1 << endl;


}

bool isPrime(int x) {

	int sq = sqrt(x);
	for (int i = 2; i <= sq; ++i)
		if (x%i == 0) return false;
	return true;

}