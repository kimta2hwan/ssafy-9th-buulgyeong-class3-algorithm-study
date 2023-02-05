#include <iostream>
#include <queue>
#include <vector>
#define endl '\n'

using namespace std;

int N;
priority_queue<int> pq;
vector<int>v;
int main(void) {

	cin >> N;
	while (N--) {
		int x; cin >> x;
		if (x ==0) {
			if (pq.empty())v.push_back(0);
			else {
				v.push_back(pq.top());
				pq.pop();
			}
		}
		else {
			pq.push(x);
		}
	}

	for (int i : v)cout << i << endl;
}