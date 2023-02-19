#include <iostream>
#include <cmath>

#define endl '\n'

using namespace std;

int N, ans;

int main(void) {
	cin >> N;
	for (int i = 0; i < N; ++i) {
		int x; cin >> x;
		if (x == 1) continue;
		else {
			bool flag = false;
			int sq = sqrt(x);
			for (int j = 2; j <= sq; ++j) {
				if (x%j == 0) {
					flag = true;
					break;
				}
			}
			ans += (flag) ? 0 : 1;

		}
	}

	cout << ans << endl;
}
