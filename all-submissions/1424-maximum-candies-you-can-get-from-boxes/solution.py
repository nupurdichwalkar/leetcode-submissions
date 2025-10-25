class Solution:
    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]], initialBoxes: List[int]) -> int:
        boxes = initialBoxes #[0]
        unopened = []
        get_keys = []
        total = 0
        seen = []
        while boxes:
            cur_b = boxes.pop() #3
            if (status[cur_b] == 1 or cur_b in get_keys) and cur_b not in seen:
                seen.append(cur_b)
                total += candies[cur_b] # 7 + 4 + 5
                contained = containedBoxes[cur_b]
                if contained:
                    boxes.extend(contained) # [3]
                cur_keys = keys[cur_b]
                if cur_keys:
                    get_keys.extend(cur_keys) #[1]
                if get_keys:
                    for u in unopened:
                        if u in get_keys:
                            boxes.append(u)
                            unopened.remove(u)
            else:
                unopened.append(cur_b)
        return total
