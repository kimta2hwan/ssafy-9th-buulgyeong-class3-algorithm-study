#include <iostream>
#include <cmath>
#define endl '\n'
#define MAX 1001
using namespace std;

int N, K, ans;
bool arr[MAX];
bool isPrime(int x);
int main(void) {
	cin >> N >> K;

	int chk = 0;
	bool flag = false;
	for (int i = 2; i <= N; ++i) {
		if (flag) break;
		if (isPrime(i)) {
			for (int j = i; j <= N; j += i) {

				if (!arr[j]) {
					//cout << j << endl;
					++chk;
					arr[j] = true;
				}

				if (chk == K) {
					ans = j;
					flag = true;
					break;
				}
			}
		}
	}
	cout << ans;
}

bool isPrime(int x) {
	int s = sqrt(x);

	for (int i = 2; i <= s; ++i) {
		if (x%i == 0) return false;
	}
	return true;

}