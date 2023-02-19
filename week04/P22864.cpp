#include <iostream>
#define endl '\n'

using namespace std;

int A, B, C, M, t = 24, ans;

int main(void) {
	cin >> A >> B >> C >> M;

	int cur = 0;
	while (t > 0) {
		if (cur + A > M) {
			cur -= C;
			if (cur < 0) cur = 0;
			t--;
			continue;
		}
		cur += A;
		ans += B;
		t--;
	}
	cout << ans << endl;
}