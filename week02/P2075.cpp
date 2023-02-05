#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;
int N;
int main(void) {
	ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
	cin >> N;
	for (int i = 0; i < N*N; ++i) {
		int x; cin >> x;
		pq.push(x);
		if (pq.size() > N) pq.pop();
		
	}

	cout << pq.top() << endl;
	return 0;
}