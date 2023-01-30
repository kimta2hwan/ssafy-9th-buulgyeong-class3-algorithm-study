import sys
input = lambda : sys.stdin.readline().rstrip()
import heapq 


T = int(input())
for _ in range(T):
    M = int(input())
    value=[]
    for i in range(((M-1)//10)+1):
        value.extend(list(map(int,input().split())))
    
    answer=[value[0]]
    front=[] #앞
    end=[] #뒤
    #m=value[0]
    heapq.heappush(front,-value[0])
    for i in range(1,M):
        f=heapq.heappop(front)
        if len(end)>0:
            e=heapq.heappop(end)

            if (i%2)==0: #홀수 인 경우
                if value[i]<(-f):
                    answer.append(-f)
                    heapq.heappush(front,-value[i])
                    heapq.heappush(front,f)
                    heapq.heappush(end,e)
                else:
                    if value[i]<e:
                        answer.append(value[i])
                        heapq.heappush(front,-value[i])
                        heapq.heappush(front,f)
                        heapq.heappush(end,e)
                    else:
                        answer.append(e)
                        heapq.heappush(end,value[i])
                        heapq.heappush(front,f)
                        heapq.heappush(front,-e)

            else: #짝수인 경우
                if value[i]<(-f):
                    heapq.heappush(front,-value[i])
                    if len(front)==len(end):
                        if value[i]<e:
                            heapq.heappush(front,-value[i])
                            heapq.heappush(end,e)
                        else:
                            heapq.heappush(front,-e)
                            heapq.heappush(end,value[i])
                    elif len(front)>len(end):
                        heapq.heappush(end,-f)
                        heapq.heappush(end,e)
                else:
                    heapq.heappush(front,f)
                    if len(front)==len(end):
                        if value[i]<e:
                            heapq.heappush(front,-value[i])
                            heapq.heappush(end,e)
                        else:
                            heapq.heappush(front,-e)
                            heapq.heappush(end,value[i])
                    elif len(front)>len(end):
                        heapq.heappush(end,value[i])
                        heapq.heappush(end,e)
                    
        else:
            if -f < value[i]:
                heapq.heappush(end,value[i])
                heapq.heappush(front,f)
            else:
                heapq.heappush(end,-f)
                heapq.heappush(front,-value[i])
        #print(front, end)

    print(len(answer))
    for i in range(((len(answer)-1)//10)+1):
        print(*answer[i*10:i*10+10])

        
