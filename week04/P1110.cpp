#include <iostream>

#define endl '\n'

using namespace std;

int N, tmp, ans;
int tmp2;

int main() {
	cin >> N;
	tmp = N;
	while (1) {
		++ans;
		int a = tmp % 10;
		int b = ((tmp / 10) + a) % 10;
		tmp = a * 10 + b;
		if (tmp == N) break;
	}

	cout << ans << endl;

}