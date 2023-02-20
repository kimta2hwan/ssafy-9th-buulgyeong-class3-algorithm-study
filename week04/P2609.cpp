#include <iostream>
#define endl '\n'

using namespace std;

int a, b;

int gcd(int a, int b);
int lcm(int a, int b);

int main(void) {
	cin >> a >> b;
	cout << gcd(a, b) << endl << lcm(a, b);

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