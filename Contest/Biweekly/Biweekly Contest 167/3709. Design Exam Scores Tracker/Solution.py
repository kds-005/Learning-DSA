from bisect import bisect_left, bisect_right


class ExamTracker:

    def __init__(self):
        self.time = []
        self.score = [0]

    def record(self, time: int, score: int) -> None:
        self.time.append(time)
        self.score.append(score + self.score[-1])

    def totalScore(self, startTime: int, endTime: int) -> int:
        startIdx = bisect_left(self.time, startTime)
        endIdx = bisect_right(self.time, endTime)
    
        # print(startIdx, endIdx, self.score[startIdx : endIdx + 1])
        return self.score[endIdx] - self.score[startIdx]