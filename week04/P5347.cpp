#include <iostream>
#include <cmath>
#define endl '\n'

typedef long long ll;

using namespace std;

int T;

ll a, b;
ll gcd(ll a, ll b);
ll lcm(ll a, ll b);

int main(void) {
	cin >> T;

	while (T--) {
		cin >> a >> b;
		cout << lcm(a, b) << endl;
	}
}

ll gcd(ll a, ll b) {

	if (a < b) {
		ll tmp = a;
		a = b; b = tmp;
	}

	while (b != 0) {
		ll tmp = a % b;
		a = b;
		b = tmp;
	}

	return a;


}

ll lcm(ll a, ll b) { return (a*b) / gcd(a, b); }