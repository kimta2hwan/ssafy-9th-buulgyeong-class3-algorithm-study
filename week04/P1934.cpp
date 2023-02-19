#include <iostream>
#define endl '\n'

using namespace std;

int t, a, b;

int gcd(int a, int b);
int lcm(int a, int b);

int main(void) {
	cin >> t;
	for (int i = 0; i < t; ++i) {
		cin >> a >> b;
		cout << lcm(a, b) << endl;
	}

}

int gcd(int a, int b) {
	if (a < b) {
		int tmp = a;
		a = b; b = tmp;
	}

	while (b != 0) {
		int tmp = a % b;
		a = b;
		b = tmp;
	}
	return a;
}

int lcm(int a, int b) {
	return (a * b) / gcd(a, b);

}