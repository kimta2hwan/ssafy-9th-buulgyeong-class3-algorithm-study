#include <iostream>
#include <string>
#include <map>

#define endl '\n'

using namespace std;

map<string, int> m;

int main(void) {
	
	ios_base::sync_with_stdio(0); cin.tie(0);

	string s;
	int cnt = 0;
	while (1) {
		getline(cin, s);
		if (s.length() == 0) break;
		++cnt;
		if (m.find(s) == m.end())
			m.insert({ s,1 });
		else {
			m[s]++;
		}

	}
	cout << fixed;
	cout.precision(4);
	for (auto iter = m.begin(); iter != m.end(); iter++) {
		cout << (iter->first) <<' '<< (iter->second / (double)cnt) * 100 << endl;
	}

}