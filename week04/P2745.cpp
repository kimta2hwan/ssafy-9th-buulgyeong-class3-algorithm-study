#include <iostream>
#include <cmath>
#include <string>
#define endl '\n'

using namespace std;

string s;
int n;
// A =17
int main(void) {
	int tmp = 0;
	cin >> s >> n;


	for (int i = 0; i < s.length(); ++i) {
		if (s[s.length() - 1 - i] >= '0'&&s[s.length() - 1 - i] <= '9')
			tmp += pow(n, i) * (s[s.length() - 1 - i] - '0');
		else
			tmp += pow(n, i) * (s[s.length() - 1 - i] - '0' - 7);
	}

	cout << tmp << endl;

}