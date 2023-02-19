#include <iostream>
#include <vector>
#include <queue>

#define endl '\n'
using namespace std;

int n;
int num[3];
int gcd(int a, int b);
int a, b;
vector<int> sol;

int main(void) {

	queue<int> q;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> num[i];
		q.push(num[i]);
	}

	a = q.front();
	q.pop();
	while (!q.empty()) {
		b = q.front();
		q.pop();
		a = gcd(a, b);
	}


	for (int i = 1; i <= a; ++i)
		if (a%i == 0)
			sol.push_back(i);


	for (int i : sol) cout << i << endl;

}

int gcd(int a, int b) {

	if (a < b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	while (b != 0) {
		int tmp = a % b;
		a = b;
		b = tmp;
	}

	return a;

}