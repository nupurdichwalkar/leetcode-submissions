class Solution:
    def convertTime(self, current: str, correct: str) -> int:
            # def convertToMinutes(time):
            #     hr, mins = time.split(":")
            #     hr_int = int(hr)
            #     mins_int = int(mins)
            #     return hr_int*60 + mins_int
            curr_time = int(current.split(":")[1]) + (int(current.split(":")[0])*60)
            correct_time = int(correct.split(":")[1]) + (int(correct.split(":")[0])*60) 
            min_count = 0
            operations = [60,15,5,1]
            for operation in operations:
                while(correct_time - curr_time >= operation):
                    min_count +=1
                    curr_time += operation
            return min_count
