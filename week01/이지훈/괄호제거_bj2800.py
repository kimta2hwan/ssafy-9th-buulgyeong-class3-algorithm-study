global formula 
global stack
global pairs
global results

formula = input()
results = []
stack = []
pairs = []

# 괄호 쌍별로 인덱스를 배열로 담음
for i in range(len(formula)):
    char = formula[i]
    if char == '(':
        stack.append([char, i])
    elif char == ')':
        startIndex = stack.pop()[1]
        pairs.append([startIndex, i])

# 괄호쌍 인덱스 배열을 받아 괄호를 제거한 문자열 반환
def getRemoved(arr):
    indeces = []
    for i in range(len(arr)):
        for num in arr[i]:
            indeces.append(num)
    indeces.sort(reverse=True)
    text = formula
    for index in indeces:
        text = text[:index] + text[index+1:]
    return text

# 재귀적으로 해당 괄호 쌍이 들어간것과 안들어간것 모든 순서쌍 찾기
def dfs(arr, depth=0):
    if depth == len(pairs):
        if len(arr) == 0:
            return
        results.append(getRemoved(arr))
        return

    appended = arr.copy()
    appended.append(pairs[depth])
    
    dfs(appended, depth+1)
    dfs(arr.copy(), depth+1)
dfs([], 0)

# 중복제거하고 사전순 정렬하여 출력
results = list(set(results))
results.sort()
for r in results:
    print(r)