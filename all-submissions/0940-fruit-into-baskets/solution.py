class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        if fruits is None: return -1
        if len(fruits) == 1: return 1
        right = 0
        left = 0
        basket = {}
        totalmax = 1

        while(right < len(fruits)):
            basket[fruits[right]] = basket.get(fruits[right], 0) + 1
            if len(basket) >2:
                while left <= right and len(basket) > 2:
                    basket[fruits[left]] -=1
                    if basket[fruits[left]] == 0:
                        basket.pop(fruits[left])
                    left +=1
            else:
                totalmax = max(totalmax, right - left +1)
            right +=1
        return totalmax

